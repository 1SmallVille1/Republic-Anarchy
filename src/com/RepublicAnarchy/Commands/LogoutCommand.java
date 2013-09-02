package com.RepublicAnarchy.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.RepublicAnarchy.Utils.SettingsManager;

public class LogoutCommand implements CommandExecutor, Runnable {

	SettingsManager settings = SettingsManager.getInstance();

	Plugin plugin;

	public LogoutCommand(Plugin instance) {

		this.plugin = instance;

	}

	public int t = 0, y = 0;

	public Player p;

	Location loc = null;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (!(sender instanceof Player)) {

			sender.sendMessage(ChatColor.RED
					+ "You must be a player to do that");

			return true;

		}

		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("logout")) {

			p = player;

			settings.reloadPInfo();

			if (settings.getPInfo().getBoolean(p.getName() + ".loggingout")) {

				p.sendMessage(ChatColor.RED + "You are already logging out!");

				return true;

			}

			loc = null;

			t = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(plugin, this, 0L, 20L);

			settings.getPInfo().set(p.getName() + ".loggingout", true);
			settings.getPInfo().set(p.getName() + ".logoutTask", t);
			settings.savePInfo();

			y = plugin.getConfig().getInt("logoutTimer");

		}

		return true;
	}

	public void run() {

		Location l = new Location(p.getLocation().getWorld(), p.getLocation()
				.getBlockX(), p.getLocation().getBlockY(), p.getLocation()
				.getBlockZ());

		if (loc == null) {

			loc = l;

		} else {

			if (loc.getBlockX() != l.getBlockX()
					|| loc.getBlockY() != l.getBlockY()
					|| loc.getBlockZ() != l.getBlockZ()) {

				Bukkit.getServer().getScheduler().cancelTask(t);

				p.sendMessage(ChatColor.RED
						+ "Cancelled logout due to movement");

				settings.getPInfo().set(p.getName() + ".loggingout", false);
				settings.savePInfo();

				loc = null;

				return;

			}

		}

		p.sendMessage(ChatColor.DARK_GREEN + "You have " + y
				+ "s until you safely log out");

		if (y == 0) {

			settings.getPInfo().set(p.getName() + ".tempBan",
					plugin.getConfig().getInt("tempBanTimer"));
			settings.savePInfo();

			p.kickPlayer(ChatColor.RED
					+ "You have successfully logged out! You must wait "
					+ plugin.getConfig().getInt("tempBanTimer")
					+ "s until you can play again");

			Bukkit.getServer().getScheduler().cancelTask(t);

			return;

		}

		y--;

	}

}
