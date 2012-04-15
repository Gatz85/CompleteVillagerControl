package com.gmail.gatz85.CVC;

//import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Villager;


import net.minecraft.server.World;

public class VillagerEntity extends net.minecraft.server.EntityVillager {

	//Logger log = this.world.getServer().getLogger();

	public VillagerEntity(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	// Override OnlivingUpdate i think
	@Override
	public void e() {
		//log.info("Villager Just Moved!!");
		Villager vtmp = (Villager) this.getBukkitEntity();
		Location from = new Location(vtmp.getWorld(), this.lastX, this.lastY,
				this.lastZ, this.lastYaw, this.lastPitch);
		Location to = new Location(vtmp.getWorld(), this.locX, this.locY,
				this.locZ, this.yaw, this.pitch);
		VillagerMoveEvent event = new VillagerMoveEvent(vtmp, from, to);
		this.world.getServer().getPluginManager().callEvent(event);

		if (event.isCancelled() && vtmp.isDead() == false) {
			return;
		}

		super.e();
	}

}
