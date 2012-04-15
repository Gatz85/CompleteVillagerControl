package com.gmail.gatz85.CVC;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class CVCEventListener implements Listener {

	Logger log;
	public CVC plugin;

	public CVCEventListener(CVC plgin) {
		this.plugin = plgin;
	}

	// Left Click Event
	@EventHandler
	public void onEntityDam(EntityDamageByEntityEvent event) {
		/*
		 * Refrence if(event.getEntity() instanceof Player){ //If the entity
		 * being damaged is a player then...
		 * 
		 * event.setCancelled(true); //Cancel the damage event, this will give
		 * the player unlimited health }
		 */
		if (event.getDamager() instanceof Player
				&& event.getEntity() instanceof Villager) {

			// Define Selfs and Said Villager
			Villager vtmp = (Villager) event.getEntity();
			Player player = (Player) event.getDamager();
			if (CVCflatfile.getSelectionID(player, this.plugin.PlayerSelc) > 0) {
				// Info Tool aka wood stick 280 ID
				// TODO List More info
				// Set Breeding Status
				if (player.getItemInHand().getType().getId() == 281) {
					event.setCancelled(true);
					if (vtmp.canBreed() == false) {
						vtmp.setBreed(true);
					} else {
						vtmp.setBreed(false);
					}

				}
				if (player.getItemInHand().getType().getId() == 280) {
					event.setCancelled(true);
					player.sendMessage("Villager's Curnnt Age            : "
							+ vtmp.getAge());
					player.sendMessage("Villager's Curnnt Health         : "
							+ vtmp.getHealth());
					player.sendMessage("Villager's Curnnt Profession     : "
							+ vtmp.getProfession().name());
					player.sendMessage("Villager's Curnnt Breeding Status: "
							+ vtmp.canBreed());
					if (vtmp instanceof VillagerEntity) {
						player
								.sendMessage("Villager's Curnnt Breeding Status: "
										+ vtmp.canBreed());

					}
				}

					// Professions Tool
					if (player.getItemInHand().getType().getId() == 340) {
						event.setCancelled(true);
						Profession ptmp = vtmp.getProfession();

						player
								.sendMessage("Villager's Current Profession     : "
										+ vtmp.getProfession().name());
						player
								.sendMessage("Villager's Current ProfessionID   : "
										+ vtmp.getProfession().getId());

						switch (ptmp) {
						case FARMER:
							vtmp.setProfession(Profession.LIBRARIAN);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;

						case LIBRARIAN:
							vtmp.setProfession(Profession.PRIEST);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;
						case PRIEST:
							vtmp.setProfession(Profession.BLACKSMITH);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;
						case BLACKSMITH:
							vtmp.setProfession(Profession.BUTCHER);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;

						case BUTCHER:
							vtmp.setProfession(Profession.FARMER);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;
						default:
							vtmp.setProfession(Profession.FARMER);
							player
									.sendMessage("Villager's Current Profession     : "
											+ vtmp.getProfession().name());
							player
									.sendMessage("Villager's Current ProfessionID   : "
											+ vtmp.getProfession().getId());
							break;
						}//end of switch

					}//end of book

				
			}

		}
	}

	@EventHandler
	public void onClick(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();
		// Rightclick events
		if (CVCflatfile.getSelectionID(player, this.plugin.PlayerSelc) > 0) {
			// Testing Grounds
			if (player instanceof Player && entity instanceof Villager) {

				// Raw Fish?? ROFL
				if (player.getItemInHand().getType().getId() == 280) {

					boolean HasAccount = CVCflatfile.containskey(player,
							this.plugin.PlayerSelc);
					if (HasAccount == true) {
						CVCflatfile.write(player, event.getRightClicked()
								.getEntityId(), this.plugin.PlayerSelc);
					}

				}
			}

		}
	}

	// Control Move
	@EventHandler
	public void onVillagerMove(VillagerMoveEvent event)
			throws NullPointerException

	{

		// A Must!!!! must link plugin or other methods don't work
		event.linkPlugin(plugin);
		// Don't Delete Above ME

		// Base of the Chat System
		List<Entity> entityList = event.getVillager()
				.getNearbyEntities(1, 1, 1);
		int listLength = entityList.size();
		for (int i = 0; i < listLength; i++) {
			if (entityList.get(i) instanceof Player) {
				Player player = (Player) entityList.get(i);
				player.sendMessage("Hi There My Friend");

			}

		}

		/*
		 * Base of AIif (){ }
		 */

	}

	// Control Spawn
	@EventHandler(priority = EventPriority.MONITOR)
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (event.isCancelled())
			return;

		/*
		 * got to use this some how maybe a control in the config.yml
		 * event.getSpawnReason()
		 */

		Location location = event.getLocation();
		Entity entity = event.getEntity();
		EntityType creatureType = event.getEntityType();
		World world = location.getWorld();

		net.minecraft.server.World mcWorld = ((CraftWorld) world).getHandle();
		net.minecraft.server.Entity mcEntity = (((CraftEntity) entity)
				.getHandle());

		if (creatureType == EntityType.VILLAGER
				&& mcEntity instanceof VillagerEntity == false) {
			VillagerEntity villagerentity = new VillagerEntity(mcWorld);

			villagerentity.setPosition(location.getX(), location.getY(),
					location.getZ());

			mcWorld
					.removeEntity((net.minecraft.server.EntityVillager) mcEntity);
			mcWorld.addEntity(villagerentity, SpawnReason.CUSTOM);
			plugin.log.info("just Spawned Custom Villager");
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();

		boolean HasAccount = CVCflatfile.containskey(player,
				this.plugin.PlayerSelc);
		if (HasAccount == false) {
			CVCflatfile.write(player, 0, this.plugin.PlayerSelc);
		}
	}

}
