package terranetworkorg.ItemRestriction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

class ItemRestrictionPlayerListener implements Listener {
		
	private final ItemRestriction plugin;
	 	 
	public ItemRestrictionPlayerListener(ItemRestriction plugin)
	{
	this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItem(event.getNewSlot());
		
		Set<String> blacklistArray = new HashSet<String>(Arrays.asList(this.plugin.getConfig().getString("General.Blacklist").split(",")));
		
		if(item != null)
		{
			int itemtype = item.getTypeId();
			String itemString = "";
			if (blacklistArray.contains("" + itemtype)){
				itemString = (new Integer(itemtype)).toString().replace("'", "");
			} else{
				int itemdamage = item.getDurability();
				if(itemdamage == 0){
					itemString = (new Integer(itemtype)).toString().replace("'", "");
				} else{
					itemString = (new Integer(itemtype)).toString().replace("'", "") + ":" + (new Integer(itemdamage)).toString().replace("'", "");
				}				
			}
			
			PlayerInventory inventory = player.getInventory();
			
			ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
	    	Set<String> allKeys = section.getKeys(false);
			if(allKeys.contains(itemString)){
				if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
					return;
				} else{
					if (inventory.firstEmpty() == -1){
						inventory.clear(event.getNewSlot());
						player.getWorld().dropItem(player.getLocation().add(0, 1, 0), item);
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED"));
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED_FULL_INVENTORY"));
						return;
					} else{
						int newItemSlot = inventory.firstEmpty();
						inventory.setItem(newItemSlot, item);
						inventory.clear(event.getNewSlot());
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED"));
						return;
					}
				}
			} else{
				return;
			}
		} else{
			return;
		}
		
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItemInHand();
		
		Set<String> blacklistArray = new HashSet<String>(Arrays.asList(this.plugin.getConfig().getString("General.Blacklist").split(",")));
		
		if(item != null)
		{
			int itemtype = item.getTypeId();
			String itemString = "";
			if (blacklistArray.contains("" + itemtype)){
				itemString = (new Integer(itemtype)).toString().replace("'", "");
			} else{
				int itemdamage = item.getDurability();
				itemString = (new Integer(itemtype)).toString().replace("'", "") + ":" + (new Integer(itemdamage)).toString().replace("'", "");
			}
			
			PlayerInventory inventory = player.getInventory();
			
			ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
	    	Set<String> allKeys = section.getKeys(false);
			if(allKeys.contains(itemString)){
				if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
					return;
				} else{
					if (inventory.firstEmpty() == -1){
						inventory.clear(player.getInventory().getHeldItemSlot());
						player.getWorld().dropItem(player.getLocation().add(0, 1, 0), item);
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED"));
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED_FULL_INVENTORY"));
						return;
					} else{
						int newItemSlot = inventory.firstEmpty();
						inventory.setItem(newItemSlot, item);
						inventory.clear(player.getInventory().getHeldItemSlot());
						player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.TOOL_DENIED"));
						return;
					}
				}
			} else{
				return;
			}
		} else{
			return;
		}
		
	}
	
}
