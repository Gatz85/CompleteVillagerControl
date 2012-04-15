package com.gmail.gatz85.CVC;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class CVC extends JavaPlugin {

	protected Server server;
	protected PluginManager manager;
	protected BukkitScheduler scheduler;

	protected String pluignDirPath;
	protected File configFile;

	public Logger log;
	public File PlayerSelc = null;

	public CVCconfig config;

	@SuppressWarnings("unchecked")
	public void onEnable() {
		// Short Simple and Fast

		// Base
		this.server = this.getServer();
		this.manager = this.server.getPluginManager();
		this.scheduler = this.server.getScheduler();

		log = this.getLogger();
		// Configure
		this.pluignDirPath = this.getDataFolder().getAbsolutePath();
		this.configFile = new File(this.pluignDirPath + File.separator
				+ "config.yml");
		this.config = new CVCconfig(this.configFile, this);
		this.PlayerSelc = new File(this.pluignDirPath + File.separator
				+ "Users.elcs");

		// Main Plugin

		if (this.config.getBoolean("pluginEnabled")) {
			log.info("Registering Listener");
			this.manager.registerEvents(new CVCEventListener(this), this);
			log.info("Listener Registered");
			log.info("Loading Commands");
			getCommand("cvc").setExecutor(new CVCcmds(this));
			log.info("Loaded Commands");
			log.info("Loading Overrides");
			try {

				Class[] args = new Class[3];
				args[0] = Class.class;
				args[1] = String.class;
				args[2] = int.class;

				Method a = net.minecraft.server.EntityTypes.class
						.getDeclaredMethod("a", args);
				a.setAccessible(true);

				a.invoke(a, VillagerEntity.class, "Villager", 120);
			} catch (Exception e) {
				e.printStackTrace();
				this.setEnabled(false);
			}
			log.info("Loading Overrides Done!");

			if (!PlayerSelc.exists())
				try {
					PlayerSelc.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

		} else {
			log.info("CVC is Disabled in CVC/config.yml Please Enable It.");
			this.manager.disablePlugin(this);
		}

	}

	public void onDisable() {
		log.info("shutting Down CVC");
		// cleanup
		this.saveConfig();
		this.config = null;

	}

}
