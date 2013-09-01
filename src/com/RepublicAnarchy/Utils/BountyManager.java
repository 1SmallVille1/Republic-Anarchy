package com.RepublicAnarchy.Utils;

import org.bukkit.configuration.file.FileConfiguration;

public class BountyManager {

	SettingsManager settings = SettingsManager.getInstance();

	// gets the bounty of the specified player
	public int getBounty(String playerName) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		int b = 0;

		if (info.get(playerName + ".bounty") == null)
			return b;

		b = info.getInt(playerName + ".bounty");

		return b;

	}

	// sets the bounty of the specified player to the specified amount
	public void setBounty(String playerName, int b) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		info.set(playerName + ".bounty", b);

		settings.savePInfo();

	}

	// adds the specified amount to the specified player's bounty
	public void addBounty(String playerName, int a) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".bounty") == null)
			return;

		int i = info.getInt(playerName + ".bounty");

		int b = i + a;

		info.set(playerName + ".bounty", b);

		settings.savePInfo();

	}

	// subtracts the specified amount from the the specified player's balance
	public void subtractBounty(String playerName, int s) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".bounty") == null)
			return;

		int i = info.getInt(playerName + ".bounty");

		int b = i - s;

		info.set(playerName + ".bounty", b);

		settings.savePInfo();

	}

}
