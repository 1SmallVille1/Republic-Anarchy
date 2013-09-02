package com.RepublicAnarchy.Setup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.RepublicAnarchy.Commands.LogoutCommand;
import com.RepublicAnarchy.Listeners.ChatListener;
import com.RepublicAnarchy.Listeners.JoinListener;
import com.RepublicAnarchy.Listeners.LoginListener;
import com.RepublicAnarchy.Listeners.QuitListener;
import com.RepublicAnarchy.Utils.BalanceManager;
import com.RepublicAnarchy.Utils.BountyManager;
import com.RepublicAnarchy.Utils.InfluenceManager;
import com.RepublicAnarchy.Utils.InsanityManager;
import com.RepublicAnarchy.Utils.SettingsManager;

public class Main extends JavaPlugin {
	
	/*
	 * TODO
	 * 
	 * First number is a scale of when I should do it (1 = yesterday, 10 = whenever). Second is how close it is being finished
	 * 
	 * #*Mobs*# 6/10 - 3/10
	 * 	 ~ Make skeletons shoot more often (probably easy, but knowing me, gonna be impossible)
	 * 	 ~ Make skeletons not burn in the sun (go Internet!)
	 * 	 ~ Make zombies move faster (done it before, simple)
	 * 	 ~ Make zombies not catch fire in sunlight (I love google)
	 *   ~ Make creepers explode bigger (hmm, something tells me this will be hard)
	 *   ~ Make spiders faster? (I have to do something to make them harder...)
	 *   ~ Change spawning (easy but I don't really know what I'm gonna do...)
	 * 
	 * #*Economy*# 3/10 - 1/10
	 * 	 ~ Add in mining/farming stuff where money is made (still need to figure out an outline on that)
	 * 	 ~ Setup the whole bounty system thingy (idk what I'm really gonna do...)
	 * 	 ~ Setup fancy shmancy shops ;) (I'm gonna like this)
	 * 	 ~ Setup a black market system (I'm gonna like this too)
	 * 
	 * #*Chat*# 5/10 - 7/10
	 * 	 ~ Setup format (super easy, except for the whole decision making thing)
	 * 	 ~ Setup a PM system (still working out kinks)
	 * 	 ~ Setup broadcast system (just need to finish, really easy though)
	 * 	 ~ Mail system? (might be a cool idea but it seems kinda weird... it's a maybe)
	 * 
	 * #*Police*# 2/10 - 1/10
	 * 	 ~ Setup how the whole police HQ will work (again don't really know how this will work... yet ;))
	 * 	 ~ Setup the whole leader process (I need people to tell me how to make this cool...)
	 * 	 ~ Jail? (could be cool... could be abused... I'll have to get a feel for that)
	 * 
	 * #*Mafia*# 2/10 - 1/10
	 * 	 ~ Setup HQ but it'll be different than the police (again no idea)
	 * 	 ~ Mafia leaders (you guessed it: no idea)
	 * 	 ~ Excommunication/shunning of players (haha "shunned!")
	 * 
	 * #*Interaction between police and mafia*# 2/10 - 0/10
	 * 	 ~ Awesome, cool police raids with flashing lights and other shizzzzz (can't wait! but I need a system for setting up a raid)
	 * 	 ~ Betrayal by both sides (ooh fun ;))
	 * 	 ~ Setup how the disguises will work (change name but not skin maybe?)
	 * 
	 * #*Miscellanious*# 10/10 - 3/10
	 * 	 ~ Setup the beginning of the game (oh, there's always a start)
	 * 	 ~ Setup the whole move across a line and join new server so there's one map, several cities and several servers (each city gets a server? very open to expansion)
	 * 
	 * #*Brainstorming*#
	 * 	 ~ How hard do I want it to be? (ie. how often do people die)
	 * 	 ~ Should admins act as just the overseers or actually take part in the game?
	 */

	SettingsManager settings = SettingsManager.getInstance();

	BalanceManager bam = new BalanceManager();
	BountyManager bom = new BountyManager();
	InfluenceManager im = new InfluenceManager();
	InsanityManager insm = new InsanityManager();

	JoinListener jl = new JoinListener(this);
	QuitListener ql = new QuitListener(this);
	LoginListener ll = new LoginListener();
	ChatListener cl = new ChatListener();
	
	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();

		// setups all the files
		settings.setup(this);

		pm.registerEvents(jl, this);
		pm.registerEvents(ql, this);
		pm.registerEvents(ll, this);
		pm.registerEvents(cl, this);

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
