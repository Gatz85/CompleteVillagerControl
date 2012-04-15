package com.gmail.gatz85.CVC;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

//SuppressWarnings("unused")
public class CVCcmds implements CommandExecutor {
	private CVC plugin;

	public CVCcmds(CVC plgin) {
		this.plugin = plgin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player == false) {
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		} else {
			if ((args.length < 1)) {
				sender.sendMessage("You must be stupid!");
				return true;
			}

			if (args[0].equalsIgnoreCase("enable")) {
				sender.sendMessage(ChatColor.GREEN
						+ "You just Enabled CVC Wand["
						+ plugin.config.getInt("Wand") + "]");
				CVCflatfile.write((Player) sender, 1, this.plugin.PlayerSelc);
				plugin.log.info(sender.getName() + "Has use a CVC command"
						+ args[0]);
				return true;
			}

			if (args[0].equalsIgnoreCase("disable")) {
				sender.sendMessage(ChatColor.DARK_RED
						+ "You just Diabled CVC Wand");
				CVCflatfile.write((Player) sender, 0, this.plugin.PlayerSelc);
				plugin.log.info(sender.getName() + " Has use a CVC command "
						+ args[0]);
				return true;
			}
			//Start of Command
			if (args[0].equalsIgnoreCase("setage")) {
				if (CVCflatfile.getSelectionID((Player) sender,
						this.plugin.PlayerSelc) > 0) {
					int slID = CVCflatfile.getSelectionID((Player) sender,
							this.plugin.PlayerSelc);
					if (args.length > 2) {
						sender.sendMessage(ChatColor.DARK_RED
								+ "You must supply a Age");
						return true;
					}
					if (args.length == 2) {
						int age;
						try {
							age = Integer.parseInt(args[1]);

						} catch (Exception e) {
							e.printStackTrace();
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Age in the form of a number! :P");
							return true;
						}

						if (age >= 0) {

							Player player = (Player) sender;
							List<Entity> elist = player.getWorld()
									.getEntities();
							for (int i = 0; i < elist.size(); i++) {
								if (elist.get(i).getEntityId() == slID) {
									Villager vtmp = (Villager) elist.get(i);
									vtmp.setAge(age);
									sender.sendMessage(ChatColor.GREEN
											+ "You just set Villager["
											+ slID
											+ "] to the age[" + age + "]");
									return true;
								} else {
								}
							}
							sender.sendMessage(ChatColor.DARK_RED
									+ "We can't find Villager["
									+ slID + "]");
							return true;
						} else {
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Age in the form of a number! :P");
							return true;
						}

					} 
				
				}else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You must Enable CVC");
				}
				this.plugin.log.info(sender.getName() + "Has use a CVC command"
						+ args[0]);
				return true;
				
			}
			//End of Command
		

			
			
			
			
			
			
			//Start of Command
			if (args[0].equalsIgnoreCase("setHealth")) {
				if (CVCflatfile.getSelectionID((Player) sender,
						this.plugin.PlayerSelc) > 0) {
					int slID = CVCflatfile.getSelectionID((Player) sender,
							this.plugin.PlayerSelc);
					if (args.length > 2) {
						sender.sendMessage(ChatColor.DARK_RED
								+ "You must supply a Health in the form of a number.");
						return true;
					}
					if (args.length == 2) {
						int hlth;
						try {
							hlth = Integer.parseInt(args[1]);

						} catch (Exception e) {
							e.printStackTrace();
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Health in the form of a number! :P");
							return true;
						}

						if (hlth >= 0 && hlth < 20) {

							Player player = (Player) sender;
							List<Entity> elist = player.getWorld()
									.getEntities();
							for (int i = 0; i < elist.size(); i++) {
								if (elist.get(i).getEntityId() == slID && elist.get(i) instanceof Villager) {
									Villager vtmp = (Villager) elist.get(i);
									//This is where we set the value
									vtmp.setHealth(hlth);
									sender.sendMessage(ChatColor.GREEN
											+ "You just set Villager["
											+ slID
											+ "] to the Health[" + hlth + "]");
									return true;
								} else {
								}
							}
							sender.sendMessage(ChatColor.DARK_RED
									+ "We can't find Villager["
									+ slID + "]");
							return true;
						} else {
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Health in the form of a number from 1 to 20");
							return true;
						}

					} 
				
				}else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You must Enable CVC");
				}
				this.plugin.log.info(sender.getName() + "Has use a CVC command"
						+ args[0]);
				return true;
				
			}
			//End of Command

			
			
			
			
			
			
			
			
			
			
			
			
			
			//Start of Command
			if (args[0].equalsIgnoreCase("setHealth")) {
				if (CVCflatfile.getSelectionID((Player) sender,
						this.plugin.PlayerSelc) > 0) {
					int slID = CVCflatfile.getSelectionID((Player) sender,
							this.plugin.PlayerSelc);
					if (args.length > 2) {
						sender.sendMessage(ChatColor.DARK_RED
								+ "You must supply a Health in the form of a number.");
						return true;
					}
					if (args.length == 2) {
						int hlth;
						try {
							hlth = Integer.parseInt(args[1]);

						} catch (Exception e) {
							e.printStackTrace();
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Health in the form of a number! :P");
							return true;
						}

						if (hlth >= 0 && hlth < 20) {

							Player player = (Player) sender;
							List<Entity> elist = player.getWorld()
									.getEntities();
							for (int i = 0; i < elist.size(); i++) {
								if (elist.get(i).getEntityId() == slID && elist.get(i) instanceof Villager) {
									Villager vtmp = (Villager) elist.get(i);
									//This is where we set the value
									vtmp.setHealth(hlth);
									sender.sendMessage(ChatColor.GREEN
											+ "You just set Villager["
											+ slID
											+ "] to the Health[" + hlth + "]");
									return true;
								} else {
								}
							}
							sender.sendMessage(ChatColor.DARK_RED
									+ "We can't find Villager["
									+ slID + "]");
							return true;
						} else {
							sender
									.sendMessage(ChatColor.DARK_RED
											+ "You must supply a Health in the form of a number from 1 to 20");
							return true;
						}

					} 
				
				}else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You must Enable CVC");
				}
				this.plugin.log.info(sender.getName() + "Has use a CVC command"
						+ args[0]);
				return true;
				
			}
			//End of Command
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			return false;
		
		}
	}
}
	

