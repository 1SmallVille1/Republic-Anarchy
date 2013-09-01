package com.RepublicAnarchy.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class WelcomeBook {

	public ItemStack getBook() {

		// creates the welcome book
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);

		BookMeta bookMeta = (BookMeta) book.getItemMeta();

		bookMeta.setTitle(ChatColor.GREEN + "Welcome to RepublicAnarchy!");

		// writes the book's pages
		bookMeta.addPage(ChatColor.RED
				+ "     "
				+ ChatColor.UNDERLINE
				+ ""
				+ ChatColor.BOLD
				+ "RepublicAnarchy\n"
				+ ChatColor.BLACK
				+ "\nWelcome to RepublicAnarchy! We wish you the best here and hope you stay and join our community.\n"
				+ "Naturally, we have some rules to make sure everyone plays fair and to keep the lying, cheating scum out of here ;)");

		bookMeta.addPage(ChatColor.BLUE
				+ ""
				+ ChatColor.UNDERLINE
				+ "#1 Hacked clients suck, as do the people that use them\n"
				+ ChatColor.BLACK
				+ "\nYup, if you use a hacked client go find a lamer server that allows you to. Here at RepublicAnarchy we use an extremely well designed version of NoCheat that "
				+ ChatColor.ITALIC + "will " + ChatColor.BLACK
				+ "catch you so just don't. If");

		bookMeta.addPage(ChatColor.BLACK
				+ "you're caught using a hacked client you will be banned permanently. It will be highly unlikely to be banned accidently for this because you have to first be caught by NoCheat, then an admin will come make sure you actually are hacking.");

		bookMeta.addPage(ChatColor.BLUE
				+ ""
				+ ChatColor.UNDERLINE
				+ "Harrassing is a no-no\n"
				+ ChatColor.BLACK
				+ "\nWe at RepublicAnarchy value our players so if you decide that you want to harrass/threaten them we have no place for you in this community. That being said, if you're ever harassed, please contact an admin. The ban for");

		bookMeta.addPage(ChatColor.BLACK
				+ "harassment will be gauged by admins and can range from a day temp-ban to a permanent ban.");

		bookMeta.addPage(ChatColor.BLUE
				+ ""
				+ ChatColor.UNDERLINE
				+ "Admins are people too\n"
				+ ChatColor.BLACK
				+ "\nYes we admins are not robots, we are not perfect and we like to have a good joke. If you feel you have been wrongly treated (by player or admin) contact a different admin or the head admin 1SmallVille1. We make mistakes");

		bookMeta.addPage(ChatColor.BLACK
				+ "occasionally and sometimes the best way to deal with said mistakes is to stop the server, go over what went wrong and fix it from there. There may be some times when we set out a carpet ban if we come across an abused glitch. This ban does not mean you");

		bookMeta.addPage(ChatColor.BLACK
				+ "are actually banned permanently, it just means you're banned until further notice. We admins also don't love sitting around banning everyone (though we do get a kick out of it) sometimes we need to let of some steam so we'll stop the server and get an");

		bookMeta.addPage(ChatColor.BLACK
				+ "event going. But don't worry YOUR PLAYER WAS SAVED DON'T CRY. Also, if you just want to chat with one of us, go ahead and send us a message, if we aren't busy we'd love to talk.");

		book.setItemMeta((ItemMeta) bookMeta);
		
		return book;

	}

}
