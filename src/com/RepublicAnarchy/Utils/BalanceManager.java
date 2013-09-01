package com.RepublicAnarchy.Utils;

import org.bukkit.configuration.file.FileConfiguration;

public class BalanceManager {

	SettingsManager settings = SettingsManager.getInstance();

	// gets the balance of the specified player
	public int getBalance(String playerName) {

		settings.reloadPInfo();

		int b = 0;

		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".balance") == null)
			return b;

		b = info.getInt(playerName + ".balance");

		return b;

	}

	// sets the balance of the specified player to the specified amount
	public void setBalance(String playerName, int b) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		info.set(playerName + ".balance", b);

		settings.savePInfo();

	}

	// adds the specified amount to the specified player's balance
	public void addBalance(String playerName, int a) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".balance") == null)
			return;

		int i = info.getInt(playerName + ".balance");

		int b = i + a;

		info.set(playerName + ".balance", b);

		settings.savePInfo();

	}

	// subtracts the specified amount from the the specified player's balance
	public void subtractBalance(String playerName, int s) {

		settings.reloadPInfo();

		FileConfiguration info = settings.getPInfo();

		if (info.get(playerName + ".balance") == null)
			return;

		int i = info.getInt(playerName + ".balance");

		int b = i - s;

		info.set(playerName + ".balance", b);

		settings.savePInfo();

	}

}
