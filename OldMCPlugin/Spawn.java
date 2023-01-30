package me.wtyczka.komendy;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import me.wtyczka.Main;
import net.md_5.bungee.api.ChatColor;

public class Spawn implements CommandExecutor, Listener {
	
	private Main plugin;
	
	public Map<String, Integer> delayPlayers = new HashMap<String, Integer>();
	public Map<Player, Integer> nieRusz = new HashMap<Player, Integer>();
	public Map<Player, Location> lokacja = new HashMap<Player, Location>();
	public Map<Player, Integer> taskID = new HashMap<Player, Integer>();
	public Map<Player, Integer> taskID2 = new HashMap<Player, Integer>();
	
	public Spawn(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawn").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		//tu zmienic na bedzin
		ItemStack oplata = new ItemStack(Material.OXIDIZED_COPPER, 3);
		if(delayPlayers.get(p.getName().toString()) == null) { 
			delayPlayers.put(p.getName().toString(), 0);
		}
		if(delayPlayers.get(p.getName().toString()) == 0) {
			//tutaj ze nie maja opoznienia
			if (p.getInventory().containsAtLeast(oplata, 3) == true) {
				nieRusz.put(p.getPlayer(), 10); //10 sekund
				lokacja.put(p.getPlayer(), p.getLocation());
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				taskID.put(p.getPlayer(), scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
					@Override
					public void run() {
						if(p.getLocation().equals(lokacja.get(p.getPlayer()))) {
							nieRusz.replace(p.getPlayer(), nieRusz.get(p.getPlayer())-1);
							lokacja.replace(p.getPlayer(), p.getLocation());
								if(nieRusz.get(p.getPlayer()) == 0) {
									if (p.getInventory().containsAtLeast(oplata, 3) == true) {
										nieRusz.remove(p.getPlayer());
										delayPlayers.replace(p.getName().toString(), 120);
										lokacja.remove(p.getPlayer());
										Location spawnloc = new Location(Bukkit.getWorld("bedzin"), -254.5, 69.5, -1271.5);
										spawnloc.setPitch(0);
										spawnloc.setYaw(90);
										p.teleport(spawnloc);
										p.getInventory().removeItem(oplata);
										p.sendMessage(ChatColor.GREEN + "ZAEBYŒCIE");
										Bukkit.getScheduler().cancelTask(taskID.get(p.getPlayer()));
									} else {
										p.sendMessage(ChatColor.RED + "MIEDZI CI SZKODA?" + ChatColor.AQUA + "   znalezione by Kamil");
										Bukkit.getScheduler().cancelTask(taskID.get(p.getPlayer()));
									}
								} else {
									p.sendMessage(ChatColor.YELLOW + "Poczekaj jeszcze " + nieRusz.get(p.getPlayer()) + " sekund!");
							}
						} else {
							p.sendMessage(ChatColor.RED + "Pan siê nie rusza.");
							Bukkit.getScheduler().cancelTask(taskID.get(p.getPlayer()));
						}
					}
				}, 0L, 20L));
			} else {
				p.sendMessage(ChatColor.RED + "Potrzebujesz 3 b³oki ut³enionej miedzi. (tej zie³onej)");
			}		
		} else {
			p.sendMessage(ChatColor.RED + "Musisz odczekaæ jeszcze " + delayPlayers.get(p.getName().toString()) + " minut!"); 
		}
		
		BukkitScheduler scheduler2 = Bukkit.getServer().getScheduler();
		taskID2.put(p.getPlayer(), scheduler2.scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if(p.getPlayer().isOnline() == true) {
					if(delayPlayers.get(p.getName().toString()) == 0) {
						delayPlayers.remove(p.getName().toString());
						Bukkit.getScheduler().cancelTask(taskID2.get(p.getPlayer()));
					} else
						delayPlayers.replace(p.getName().toString(), delayPlayers.get(p.getName().toString())-1);
				}
			}
		}, 60 * 20L));
		return false;
	}

}
