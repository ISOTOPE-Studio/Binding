package cc.isotopestudio.Binding;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

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

}
