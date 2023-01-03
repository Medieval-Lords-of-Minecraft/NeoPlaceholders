package me.neoblade298.neoplaceholders.placeholders.other;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ShanaChans.LordTags.Tag;
import me.ShanaChans.LordTags.TagManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.neoblade298.neocore.NeoCore;

public class LordTagsPlaceholders extends PlaceholderExpansion {

    @Override
    public boolean canRegister(){
        return Bukkit.getPluginManager().getPlugin("LordTags") != null;
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
		return "lordtags";
	}

    @Override
    public String getRequiredPlugin(){
        return "LordTags";
    }
    
	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String onPlaceholderRequest(Player p, String identifier) {
		if (p == null) return "";
		if (!NeoCore.isLoaded(p)) return "";
		Tag tag = TagManager.getPlayerTag(p);
		if (tag == null) return "";
		
		String args[] = identifier.split("_");
		
		if (args[0].equalsIgnoreCase("display")) {
			return tag.getDisplay() + " ";
		}
		else if (args[0].equalsIgnoreCase("desc")) {
			return tag.getDesc();
		}
		else if (args[0].equalsIgnoreCase("id")) {
			return tag.getId();
		}
		return "";
	}
}
