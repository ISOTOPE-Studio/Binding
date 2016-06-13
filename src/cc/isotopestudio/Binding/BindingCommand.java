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
                sender.sendMessage(S.toPrefixRed("��û��Ȩ��"));
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(S.toPrefixRed("����Ҫ��Ҳ���ִ��"));
                return true;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                player.sendMessage(S.toPrefixGreen("/binding <Ȩ��> - ��������Ʒ���Ȩ��"));
                return true;
            }
            ItemStack item = player.getItemInHand();
            if (item == null || item.getType() == Material.AIR) {
                player.sendMessage(S.toPrefixRed("����û����Ʒ"));
                return true;
            }
            player.setItemInHand(ItemUtil.addPerm(item, args[0]));
            player.sendMessage(S.toPrefixGreen("�ɹ����Ȩ��"));
            return true;
        }
        return false;
    }
}
