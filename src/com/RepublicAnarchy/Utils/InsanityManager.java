package com.RepublicAnarchy.Utils;

import org.bukkit.configuration.file.FileConfiguration;

public class InsanityManager {

	SettingsManager settings = SettingsManager.getInstance();

	// gets the insanity of the specified player
	public int getInsanity(String playerName) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();
		
		int b = 0;

		if (info.get(playerName + ".insanity") == null)
			return b;

		b = info.getInt(playerName + ".insanity");

		return b;

	}

	// sets the insanity of the specified player to the specified amount
	public void setInsanity(String playerName, int b) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();
		
		info.set(playerName + ".insanity", b);

		settings.savePInfo();

	}

	// adds the specified amount to the specified player's insanity
	public void addInsanity(String playerName, int a) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();
		
		if (info.get(playerName + ".insanity") == null)
			return;

		int i = info.getInt(playerName + ".insanity");

		int b = i + a;

		info.set(playerName + ".insanity", b);

		settings.savePInfo();

	}
	
	// subtracts the specified amount from the the specified player's insanity
	public void subtractInsanity(String playerName, int s) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();
		
		if (info.get(playerName + ".insanity") == null)
			return;

		int i = info.getInt(playerName + ".insanity");

		int b = i - s;

		info.set(playerName + ".insanity", b);

		settings.savePInfo();

	}

}
