package me.neoblade298.neoplaceholders.placeholders.other;

import org.bukkit.entity.Player;

import me.ShanaChans.LordTags.TagManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.neoblade298.neocore.NeoCore;

public class LordsTagsPlaceholders extends PlaceholderExpansion {

    @Override
    public boolean canRegister(){
        // return Bukkit.getPluginManager().getPlugin("SkillAPI") != null;
        return true; // Replace with above line with your plugin
    }
    
    @Override
    public boolean register(){
    	if (!canRegister()) return false;
    	return super.register();
    }

	@Override
	public String getAuthor() {
		return "Neoblade298";
	}
	
    @Override
    public boolean persist(){
        return true;
    }

	@Override
	public String getIdentifier() {
		return "lordstags";
	}

    @Override
    public String getRequiredPlugin(){
        return null; // Replace with your plugin name
    }
    
	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String onPlaceholderRequest(Player p, String identifier) {
		if (p == null) return "Loading...";
		if (!NeoCore.isLoaded(p)) return "Loading...";
		
		String args[] = identifier.split("_");
		
		if (args[0].equalsIgnoreCase("activetag")) {
			return TagManager.getPlayers().get(p.getUniqueId()).getCurrentTag();
		}
		return "";
	}
}
