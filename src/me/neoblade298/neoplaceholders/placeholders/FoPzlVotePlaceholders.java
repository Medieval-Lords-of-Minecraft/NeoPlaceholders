package me.neoblade298.neoplaceholders.placeholders;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.fopzl.vote.bukkit.io.BukkitVoteIO;
import me.fopzl.vote.bukkit.io.VoteStats;
import me.neoblade298.neocore.bukkit.NeoCore;

public class FoPzlVotePlaceholders extends PlaceholderExpansion {
	@Override
	public boolean canRegister() {
		return true;
	}
	
	@Override
	public boolean register() {
		return canRegister() && super.register();
	}
	
	@Override
	public String getAuthor() {
		return "FoPzl";
	}
	
	@Override
	public boolean persist() {
		return true;
	}
	
	@Override
	public String getIdentifier() {
		return "fopzlvote";
	}
	
	@Override
	public String getRequiredPlugin() {
		return "FoPzlVote";
	}
	
	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String onPlaceholderRequest(Player p, String identifier) {
		if(p == null) return "Loading...";
		if (!NeoCore.isLoaded(p)) return "Loading...";
		
		String args[] = identifier.split("_");
		// fopzlvote_all, fopzlvote_month, and fopzlvote_streak
		VoteStats stats = BukkitVoteIO.getStats(p);
		switch (args[0]) {
		case "all":
			return stats.getTotalVotes() + "";
		case "month":
			return stats.getVotesThisMonth() + "";
		case "streak":
			return stats.getStreak() + "";
		}
		
    	return "§cInvalid placeholder!";
	}
}
