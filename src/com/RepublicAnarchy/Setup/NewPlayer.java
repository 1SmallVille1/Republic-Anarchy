package com.RepublicAnarchy.Setup;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.RepublicAnarchy.Utils.SettingsManager;

public class NewPlayer {

	SettingsManager settings = SettingsManager.getInstance();

	public void setupNewPlayer(Player p) {

		String name = p.getName();
		
		FileConfiguration pInfo = settings.getPInfo();
		
		pInfo.set(name + ".balance", 0);
		pInfo.set(name + ".bounty", 0);
		pInfo.set(name + ".influence", 0);
		pInfo.set(name + ".insanity", 0);
		pInfo.set(name + ".dead", 2);
		
	}

}
