package com.RepublicAnarchy.Utils;

import org.bukkit.configuration.file.FileConfiguration;

public class InfluenceManager {

	SettingsManager settings = SettingsManager.getInstance();

	// gets the influence of the specified player
	public int getInfluence(String playerName) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();

		int b = 0;

		if (info.get(playerName + ".influence") == null)
			return b;

		b = info.getInt(playerName + ".influence");

		return b;

	}

	// sets the influence of the specified player to the specified amount
	public void setInfluence(String playerName, int b) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();

		info.set(playerName + ".influence", b);

		settings.savePInfo();

	}

	// adds the specified amount to the specified player's insanity
	public void addInfluence(String playerName, int a) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".influence") == null)
			return;

		int i = info.getInt(playerName + ".influence");

		int b = i + a;

		info.set(playerName + ".influence", b);

		settings.savePInfo();

	}

	// subtracts the specified amount from the the specified player's insanity
	public void subtractInfluence(String playerName, int s) {

		settings.reloadPInfo();
		
		FileConfiguration info = settings.getPInfo();
		
		if (info.get(playerName + ".influence") == null)
			return;

		int i = info.getInt(playerName + ".influence");

		int b = i - s;

		info.set(playerName + ".influence", b);

		settings.savePInfo();

	}

}
