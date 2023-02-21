package me.neoblade298.neoplaceholders.placeholders.other;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.ShanaChans.LordTags.Tag;
import me.ShanaChans.LordTags.TagAccount;
import me.ShanaChans.LordTags.TagManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

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
	
	// lordtags_tag_id/desc/display
	// lordtags_name
	// lordtags_nick
	// lordtags_chatcolor
	@Override
	public String onPlaceholderRequest(Player p, String identifier) {
		if (p == null) return "";
		
		String args[] = identifier.split("_");
		
		TagAccount acct = TagManager.getAccount(p.getUniqueId());
		if (acct == null) {
			if (args[0].equalsIgnoreCase("name") || args[0].equalsIgnoreCase("nick")) {
				return p.getName();
			}
			else {
				return "";
			}
		}
		
		switch (args[0]) {
		case "name":
			return acct.getDisplay(false);
		case "nick":
			return acct.getDisplay(true);
		case "chatcolor":
			return acct.getChatColor() + "";
		case "tag":
			if (acct.getTag() == null) return "";
			Tag tag = acct.getTag();
			switch (args[1]) {
			case "display":
				return tag.getDisplay() + " ";
			case "desc":
				return tag.getDesc();
			case "id":
				return tag.getId();
			}
		}
		return "Invalid placeholder!";
	}
}
