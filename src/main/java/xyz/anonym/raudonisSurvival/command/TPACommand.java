package xyz.anonym.raudonisSurvival.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.anonym.raudonisSurvival.RaudonisSurvival;

import java.nio.Buffer;

public class TPACommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player teleportPlayer;
        Player argumentPlayer;
        if (commandSender instanceof Player) {
            teleportPlayer = (Player) commandSender;
            argumentPlayer = Bukkit.getPlayer(strings[0]);
        } else {
            commandSender.sendMessage("[§6§lRaudonisSurvival§r] §4You can't execute this!");
            return true;
        }
        try {
            argumentPlayer.sendMessage("[§6§lRaudonisSurvival§r] §e" + teleportPlayer.getName() + "§r is teleporting to you!");
            teleportPlayer.sendMessage("[§6§lRaudonisSurvival§r] Teleporting to §e" + argumentPlayer.getName() + "§r...");
            RaudonisSurvival.sleep(1500);
            teleportPlayer.teleport(argumentPlayer);
            return true;
        } catch (Exception e) {
            teleportPlayer.sendMessage("[§6§lRaudonisSurvival§r] §4The Player is not online!");
            return false;
        }
    }
}
