package cc.isotopestudio.Binding;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Mars on 6/13/2016.
 * Copyright ISOTOPE Studio
 */
public class BindingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("binding")) {
            if (!sender.hasPermission("binding")) {
                sender.sendMessage(S.toPrefixRed("你没有权限"));
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(S.toPrefixRed("必须要玩家才能执行"));
                return true;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                player.sendMessage(S.toPrefixGreen("/binding <权限> - 给手中物品添加权限"));
                return true;
            }
            ItemStack item = player.getItemInHand();
            if (item == null || item.getType() == Material.AIR) {
                player.sendMessage(S.toPrefixRed("手中没有物品"));
                return true;
            }
            player.setItemInHand(ItemUtil.addPerm(item, args[0]));
            player.sendMessage(S.toPrefixGreen("成功添加权限"));
            return true;
        }
        return false;
    }
}
