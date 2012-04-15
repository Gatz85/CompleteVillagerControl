package com.gmail.gatz85.CVC;

/*
 * Outline  Copied from package uk.co.jacekk.bukkit.bloodmoon;
 * Original Source here http://dev.bukkit.org/server-mods/bloodmoon/#w-source-code
 * License GNU General Public License version 3 (GPLv3) 
 * Thanks For the onMoveEvent()
 */

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VillagerMoveEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();

	private boolean isCancelled = false;
	private boolean cantalk = true;
	
	private Villager villager;
	private Location from;
	private Location to;
	private CVC plugin;

	

	public VillagerMoveEvent(Villager villager, Location from, Location to) {
		this.villager = villager;
		this.from = from;
		this.to = to;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Villager getVillager() {
		return this.villager;
	}

	public Location getTo() {
		return this.to;
	}

	public Location getFrom() {
		return this.from;
	}

	public LivingEntity getTarget() {
		return villager.getTarget();
	}
	
	public void setTalk(Boolean talk){
		this.cantalk = talk;
	}
	
	public boolean canTalk(){
		return this.cantalk;
	}
	
	public boolean isCancelled() {
		return this.isCancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.isCancelled = cancelled;
	}
	
	
	//Plugin link for Methods 
	public void linkPlugin(CVC plgin){
		this.plugin = plgin;
	}
	
	public CVC returnPlugin() throws NullPointerException {
		return this.plugin;
	}

	

}