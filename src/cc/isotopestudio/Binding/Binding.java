package cc.isotopestudio.Binding;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Mars on 6/13/2016.
 * Copyright ISOTOPE Studio
 */
public class Binding extends JavaPlugin {

    private static final String pluginName = "Binding";
    static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("系统").append("]").append(ChatColor.GREEN).toString();

    @Override
    public void onEnable() {

        this.getCommand("binding").setExecutor(new BindingCommand());
        getServer().getPluginManager().registerEvents(new BindingListener(), this);
        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "成功卸载!");
    }
}
