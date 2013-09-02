package com.RepublicAnarchy.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.RepublicAnarchy.Utils.SettingsManager;

public class LoginListener implements Listener {

	SettingsManager settings = SettingsManager.getInstance();

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent evt) {

		Player player = evt.getPlayer();

		settings.reloadPInfo();

		if (settings.getPInfo().get(player.getName()) == null)
			return;

		if (settings.getPInfo().getInt(player.getName() + ".tempBan") == 0)
			return;

		evt.disallow(Result.KICK_OTHER, ChatColor.RED + "You must wait "
				+ settings.getPInfo().getInt(player.getName() + ".tempBan")
				+ "s until you can play again");

	}

}
