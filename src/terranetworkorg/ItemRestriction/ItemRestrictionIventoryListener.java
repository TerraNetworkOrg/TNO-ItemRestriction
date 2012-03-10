package terranetworkorg.ItemRestriction;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;
import org.getspout.spoutapi.event.inventory.InventoryCloseEvent;
import org.getspout.spoutapi.event.inventory.InventorySlotType;

@SuppressWarnings("unused")
class ItemRestrictionInventoryListener implements Listener {
		
	private final ItemRestriction plugin;
	 	 
	public ItemRestrictionInventoryListener(ItemRestriction plugin)
	{
	this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onInventoryClose(InventoryCloseEvent event) {
		
		Player player = event.getPlayer();

		ItemStack itemType = player.getInventory().getHelmet();
		if (itemType == null){
			
		} else if (itemType.getTypeId() == 0){
			
		}
		else{
			manageHelmet(player, itemType);
		}
		
		itemType = player.getInventory().getChestplate();
		if (itemType == null){
			
		} else if (itemType.getTypeId() == 0){
			
		}
		else{
			manageChestplate(player, itemType);
		}
		
		itemType = player.getInventory().getLeggings();
		if (itemType == null){
			
		} else if (itemType.getTypeId() == 0){
			
		}
		else{
			manageLeggings(player, itemType);
		}
		
		itemType = player.getInventory().getBoots();
		if (itemType == null){
			
		} else if (itemType.getTypeId() == 0){
			
		}
		else{
			manageBoots(player, itemType);
		}
		return;
		
	}
	
	public void manageHelmet(Player player, ItemStack itemType){
		int itemID = itemType.getTypeId();
		String itemString = (new Integer(itemID)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
    	Set<String> allKeys = section.getKeys(false);
		if(allKeys.contains(itemString)){
			if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setHelmet(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setHelmet(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
	}
	
	public void manageChestplate(Player player, ItemStack itemType){
		int itemID = itemType.getTypeId();
		String itemString = (new Integer(itemID)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
    	Set<String> allKeys = section.getKeys(false);
		if(allKeys.contains(itemString)){
			if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setChestplate(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setChestplate(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
	}
	
	public void manageLeggings(Player player, ItemStack itemType){
		int itemID = itemType.getTypeId();
		String itemString = (new Integer(itemID)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
    	Set<String> allKeys = section.getKeys(false);
		if(allKeys.contains(itemString)){
			if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setLeggings(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setLeggings(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
	}
	
	public void manageBoots(Player player, ItemStack itemType){
		int itemID = itemType.getTypeId();
		String itemString = (new Integer(itemID)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		ConfigurationSection section = this.plugin.getConfig().getConfigurationSection("Restrict.ID");
    	Set<String> allKeys = section.getKeys(false);
		if(allKeys.contains(itemString)){
			if (ItemRestriction.permission.has(player, this.plugin.getConfig().getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setBoots(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setBoots(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ this.plugin.getLanguage().getString("Messages.ARMOR_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
	}
}