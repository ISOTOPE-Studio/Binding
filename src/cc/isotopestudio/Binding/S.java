package cc.isotopestudio.Binding;

import org.bukkit.ChatColor;

class S {
    static String toRed(String s) {
        return String.valueOf(ChatColor.RED) + s + ChatColor.RESET;
    }

    static String toGray(String s) {
        return String.valueOf(ChatColor.GRAY) + s + ChatColor.RESET;
    }

    static String toPrefixRed(String s) {
        return Binding.prefix + ChatColor.RED + s + ChatColor.RESET;
    }

    static String toPrefixGreen(String s) {
        return Binding.prefix + ChatColor.GREEN + s + ChatColor.RESET;
    }

}
