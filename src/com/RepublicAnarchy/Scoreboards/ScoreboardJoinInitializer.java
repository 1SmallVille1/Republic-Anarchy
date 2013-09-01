package com.RepublicAnarchy.Scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.RepublicAnarchy.Utils.BalanceManager;
import com.RepublicAnarchy.Utils.BountyManager;
import com.RepublicAnarchy.Utils.InfluenceManager;
import com.RepublicAnarchy.Utils.InsanityManager;

public class ScoreboardJoinInitializer {

	BalanceManager bam = new BalanceManager();
	BountyManager bom = new BountyManager();
	InfluenceManager im = new InfluenceManager();
	InsanityManager insm = new InsanityManager();

	public void newScoreboard(Player p) {

		String n = p.getName();

		// sets up the player's scoreboard based on their score
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("Influence", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.BLUE + p.getName());

		Score influence = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.DARK_AQUA + "Influence"));
		influence.setScore(bam.getBalance(n));
		Score bounty = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.GREEN + "Bounty"));
		bounty.setScore(bom.getBounty(n));
		Score balance = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.DARK_GREEN + "Balance"));
		balance.setScore(im.getInfluence(n));
		Score insanity = objective.getScore(Bukkit
				.getOfflinePlayer(ChatColor.DARK_RED + "Insanity"));

		int i = insm.getInsanity(n);

		if (i > 0) {

			insanity.setScore(i);

		}

		p.setScoreboard(board);

	}

}
