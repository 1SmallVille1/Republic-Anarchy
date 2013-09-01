package com.RepublicAnarchy.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import com.RepublicAnarchy.Utils.SettingsManager;

import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;
import de.kumpelblase2.remoteentities.api.DespawnReason;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.entities.RemotePlayer;

public class QuitListener implements Listener, Runnable {

	SettingsManager settings = SettingsManager.getInstance();

	boolean log = false;

	int x = 0, t = 0, y = 0;

	String name;

	Plugin plugin;

	RemotePlayer human;

	public QuitListener(Plugin instance) {

		plugin = instance;

	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent evt) {

		Player player = evt.getPlayer();
		name = player.getName();

		FileConfiguration pInfo = settings.getPInfo();

		if (pInfo.getBoolean(name + ".loggingout")) {

			log = true;

			x = plugin.getConfig().getInt("tempBanTimer");

			t = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(plugin, this, 0L, 20L);
			
			pInfo.set(name + ".loggingout", false);

		} else {

			Location loc = player.getLocation();

			EntityManager manager = RemoteEntities.createManager(plugin);

			RemoteEntity entity = manager.createNamedEntity(
					RemoteEntityType.Human, loc, name);

			human = (RemotePlayer) entity;

			human.copyInventory(player);

			human.spawn(loc);

			y = plugin.getConfig().getInt("NPCTimer");

			x = plugin.getConfig().getInt("tempBanTimer");

			t = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(plugin, this, 0L, 20L);

		}

	}

	public void run() {

		if (log) {

			settings.getPInfo().set(name + ".tempBan", x);
			settings.savePInfo();

			if (x == 0) {

				Bukkit.getServer().getScheduler().cancelTask(t);

				return;

			}

			x--;

			return;

		} else {

			settings.getPInfo().set(name + ".tempBan", x + y);
			settings.savePInfo();

			if (y == 0) {

				human.despawn(DespawnReason.CUSTOM);

				Bukkit.getServer().getScheduler().cancelTask(t);

				log = true;

				t = Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(plugin, this, 0L, 20L);

				return;

			}

			y--;

		}

	}

}
