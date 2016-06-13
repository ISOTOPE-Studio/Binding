package cc.isotopestudio.Binding;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 6/13/2016.
 * Copyright ISOTOPE Studio
 */
class ItemUtil {

    private static final String key = S.toRed("х╗оч: ");

    static ItemStack addPerm(ItemStack item, String perm) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<String>();
        lore.add(key + S.toGray(perm));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    static String getPerm(ItemStack item) {
        try {
            for (String line : item.getItemMeta().getLore()) {
                if (line.contains(key)) {
                    return ChatColor.stripColor(line).substring(4);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }


}
