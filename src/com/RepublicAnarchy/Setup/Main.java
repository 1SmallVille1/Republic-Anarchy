package com.RepublicAnarchy.Setup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.RepublicAnarchy.Commands.LogoutCommand;
import com.RepublicAnarchy.Listeners.JoinListener;
import com.RepublicAnarchy.Listeners.LogListener;
import com.RepublicAnarchy.Listeners.QuitListener;
import com.RepublicAnarchy.Utils.BalanceManager;
import com.RepublicAnarchy.Utils.BountyManager;
import com.RepublicAnarchy.Utils.InfluenceManager;
import com.RepublicAnarchy.Utils.InsanityManager;
import com.RepublicAnarchy.Utils.SettingsManager;

public class Main extends JavaPlugin {

	SettingsManager settings = SettingsManager.getInstance();

	BalanceManager bam = new BalanceManager();
	BountyManager bom = new BountyManager();
	InfluenceManager im = new InfluenceManager();
	InsanityManager insm = new InsanityManager();

	JoinListener jl = new JoinListener(this);
	QuitListener ql = new QuitListener(this);
	LogListener ll = new LogListener();
	
	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();

		// setups all the files
		settings.setup(this);

		pm.registerEvents(jl, this);
		pm.registerEvents(ql, this);
		pm.registerEvents(ll, this);

		LogoutCommand lc = new LogoutCommand(this);
		
		getCommand("logout").setExecutor(lc);
		
	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("s")) {

			Player player = (Player) sender;

			player.setDisplayName(args[0]);

		}

		return false;
	}

}
