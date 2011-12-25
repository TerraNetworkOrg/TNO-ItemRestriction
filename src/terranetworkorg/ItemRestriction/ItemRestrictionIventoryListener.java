package terranetworkorg.ItemRestriction;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;
import org.getspout.spoutapi.event.inventory.InventoryCloseEvent;
import org.getspout.spoutapi.event.inventory.InventoryListener;
import org.getspout.spoutapi.event.inventory.InventorySlotType;

@SuppressWarnings("unused")
class ItemRestrictionInventoryListener extends InventoryListener {
		
	private final ItemRestriction plugin;
	 	 
	public ItemRestrictionInventoryListener(ItemRestriction plugin)
	{
	this.plugin = plugin;
	}
	
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
		
		if(ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setHelmet(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setHelmet(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
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
		
		if(ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setChestplate(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setChestplate(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
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
		
		if(ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setLeggings(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setLeggings(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
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
		
		if(ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.setBoots(null);
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setBoots(null);
					inventory.setItem(newItemSlot, itemType);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.ARMOR_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
	}
}