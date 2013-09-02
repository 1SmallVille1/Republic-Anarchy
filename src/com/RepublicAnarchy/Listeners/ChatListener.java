package com.RepublicAnarchy.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent evt) {

		Player player = evt.getPlayer();
		String msg = evt.getMessage();

		if (msg.startsWith("^")) {

			Bukkit.getServer().broadcastMessage(ChatColor.RED + "HI!");

		}

		evt.setFormat(ChatColor.DARK_GRAY + "[" + player.getName() + "] "
				+ ChatColor.GRAY + msg);

	}

}
