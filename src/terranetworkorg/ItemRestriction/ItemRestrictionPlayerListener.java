package terranetworkorg.ItemRestriction;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;
import org.getspout.spoutapi.event.inventory.InventorySlotType;

@SuppressWarnings("unused")
class ItemRestrictionPlayerListener extends PlayerListener {
		
	private final ItemRestriction plugin;
	 	 
	public ItemRestrictionPlayerListener(ItemRestriction plugin)
	{
	this.plugin = plugin;
	}
	
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItem(event.getNewSlot());
		int itemtype = item.getTypeId();
		String itemString = (new Integer(itemtype)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		if (ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){
					inventory.clear(event.getNewSlot());
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), item);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setItem(newItemSlot, item);
					inventory.clear(event.getNewSlot());
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
		
	}
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItemInHand();
		int itemtype = item.getTypeId();
		String itemString = (new Integer(itemtype)).toString().replace("'", "");
		PlayerInventory inventory = player.getInventory();
		
		if (ItemRestriction.config.getKeys("Restrict.ID").contains(itemString)){
			if (ItemRestriction.permission.has(player, ItemRestriction.config.getString("Restrict.ID." + itemString))){
				return;
			} else{
				if (inventory.firstEmpty() == -1){				
					inventory.clear(player.getInventory().getHeldItemSlot());
					player.getWorld().dropItem(player.getLocation().add(0, 1, 0), item);
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED"));
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED_FULL_INVENTORY"));
					return;
				} else{
					int newItemSlot = inventory.firstEmpty();
					inventory.setItem(newItemSlot, item);
					inventory.clear(player.getInventory().getHeldItemSlot());
					player.sendMessage(ChatColor.GOLD+ ItemRestriction.language.getString("Messages.TOOL_DENIED"));
					return;
				}
			}
		} else{
			return;
		}
		
	}
	
}
