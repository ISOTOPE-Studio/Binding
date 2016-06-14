package cc.isotopestudio.Binding;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Mars on 6/13/2016.
 * Copyright ISOTOPE Studio
 */
class BindingListener implements Listener {

    @EventHandler
    public void onItemUse(PlayerInteractEvent event) {
        String perm = ItemUtil.getPerm(event.getItem());
        if (perm == null) return;
        Player player = event.getPlayer();
        if (!player.hasPermission(perm)) {
            player.setItemInHand(null);
            player.sendMessage(S.toPrefixRed("你没有权限使用"));
        }
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = player.getInventory();
        for (int i = 0; i < inv.getContents().length; i++) {
            ItemStack item = inv.getContents()[i];
            String perm = ItemUtil.getPerm(item);
            if (perm != null && !player.hasPermission(perm)) {
                inv.setItem(i, null);
                player.sendMessage(S.toPrefixRed("你没有权限使用"));
            }
        }
        ItemStack[] armors = player.getEquipment().getArmorContents();
        boolean changed = false;
        for (int i = 0; i < armors.length; i++) {
            ItemStack item = armors[i];
            String perm = ItemUtil.getPerm(item);
            if (perm != null && !player.hasPermission(perm)) {
                changed = true;
                armors[i] = null;
                player.sendMessage(S.toPrefixRed("你没有权限使用"));
            }
        }
        if (changed) {
            player.getEquipment().setArmorContents(armors);
        }
    }
}
