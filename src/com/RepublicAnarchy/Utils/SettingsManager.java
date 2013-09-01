package com.RepublicAnarchy.Utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

	private SettingsManager() {

	}

	static SettingsManager instance = new SettingsManager();

	Plugin p;

	FileConfiguration config;
	File cfile;

	FileConfiguration pInfo;
	File ifile;

	public static SettingsManager getInstance() {

		return instance;
	}

	public void setup(Plugin p) {

		if (!p.getDataFolder().exists()) {

			p.getDataFolder().mkdir();
		}

		cfile = new File(p.getDataFolder(), "config.yml");

		if (!cfile.exists()) {

			config = p.getConfig();

			saveConfig();

		}

		ifile = new File(p.getDataFolder(), "Player_Info.yml");

		if (!ifile.exists()) {

			try {

				ifile.createNewFile();

			} catch (IOException e) {

				Bukkit.getServer()
						.getLogger()
						.severe(ChatColor.RED
								+ "A Player_Info.yml file could not be created");
			}
		}

		pInfo = YamlConfiguration.loadConfiguration(ifile);

	}

	public void reloadConfig() {

		config = YamlConfiguration.loadConfiguration(cfile);
	}

	public void saveConfig() {
		try {

			this.config.save(cfile);

		} catch (IOException e) {

			Bukkit.getServer()
					.getLogger()
					.severe(ChatColor.RED
							+ "The config.yml file could not be saved");
		}
	}

	public FileConfiguration getPInfo() {

		return pInfo;
	}

	public void savePInfo() {

		try {

			this.pInfo.save(ifile);

		} catch (IOException e) {

			Bukkit.getServer()
					.getLogger()
					.severe(ChatColor.RED
							+ "The Player_Info.yml file could not be saved");
		}
	}
	
	public void reloadPInfo() {

		pInfo = YamlConfiguration.loadConfiguration(ifile);
	}

}
