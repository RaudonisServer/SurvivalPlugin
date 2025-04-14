package xyz.anonym.raudonisSurvival.death;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHeadDrop implements Listener {
    @EventHandler
    private void onDeath(PlayerDeathEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD); // Create a new ItemStack of the Player Head type.
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta(); // Get the created item's ItemMeta and cast it to SkullMeta so we can access the skull properties
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(e.getPlayer().getName())); // Set the skull's owner so it will adapt the skin of the provided username (case sensitive).
            skull.setItemMeta(skullMeta);
            e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), skull);
            try {
                Bukkit.broadcast(Component.text("[§6§lRaudonisSurvival§r] ").append(e.deathMessage()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
