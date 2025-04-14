package xyz.anonym.raudonisSurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.anonym.raudonisSurvival.command.TPACommand;
import xyz.anonym.raudonisSurvival.death.PlayerHeadDrop;

import java.util.Objects;

public final class RaudonisSurvival extends JavaPlugin {

    public static void log(String text) {
        // Write into the log
        Bukkit.getConsoleSender().sendMessage(text);
    }

    public static void sleep(int sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onEnable() {
        log("[§6§lRaudonisSurvival§r] Registering...");
        register();
        log("[§6§lRaudonisSurvival§r] Done!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void register() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        Objects.requireNonNull(Bukkit.getPluginCommand("tpa")).setExecutor(new TPACommand());
        pluginManager.registerEvents(new PlayerHeadDrop(), this);
    }
}
