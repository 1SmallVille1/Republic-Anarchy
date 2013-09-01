package com.RepublicAnarchy.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.RepublicAnarchy.Scoreboards.ScoreboardJoinInitializer;
import com.RepublicAnarchy.Setup.NewPlayer;
import com.RepublicAnarchy.Utils.SettingsManager;
import com.RepublicAnarchy.Utils.WelcomeBook;

public class JoinListener implements Listener, Runnable {

	ScoreboardJoinInitializer sji = new ScoreboardJoinInitializer();

	SettingsManager settings = SettingsManager.getInstance();

	NewPlayer np = new NewPlayer();

	WelcomeBook wb = new WelcomeBook();

	private Player p;

	Plugin plugin;

	public JoinListener(Plugin instance) {

		this.plugin = instance;

	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt) {

		Player player = evt.getPlayer();
		String name = player.getName();

		// if a player has never played before
		if (!player.hasPlayedBefore()) {

			// sets up the player in the data file
			np.setupNewPlayer(player);

			evt.setJoinMessage("");

			// make a new instance of the player in state 2 (dead, aka in the
			// spawn room)
			settings.getPInfo().set(name + ".dead", 2);

			ItemStack book = wb.getBook();

			player.getInventory().addItem(book);

			player.sendMessage(ChatColor.GREEN
					+ "Welcome to Republic Anarchy! Check out the signs around you for an in-depth tutorial into how to play the game");

		} else {

			// checks if the player is dead
			if (settings.getPInfo().getInt(name + ".dead") == 2) {

				// teleports the player to the spawnpoint
				player.teleport(player.getWorld().getSpawnLocation());

				ItemStack book = wb.getBook();
				
				player.getInventory().addItem(book);

				player.sendMessage(ChatColor.RED
						+ "You died. You suck. Be better next time. Type /ra spawn to try again");

			} else {

				p = player;

				Bukkit.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, this, 1L);

			}

		}

	}

	public void run() {

		// creates the player's scoreboard
		sji.newScoreboard(p);

	}

}
