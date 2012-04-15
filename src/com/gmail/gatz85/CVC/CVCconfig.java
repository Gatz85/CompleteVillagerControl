package com.gmail.gatz85.CVC;

/*
 * Outline  Copied from package uk.co.jacekk.bukkit.bloodmoon;
 * Original Source here http://dev.bukkit.org/server-mods/bloodmoon/#w-source-code
 * License GNU General Public License version 3 (GPLv3) 
 * Thanks For the Config()
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class CVCconfig {

		private YamlConfiguration config;
		private LinkedHashMap<String, Object> configDefaults;
		
		public CVCconfig(File configFile, CVC plugin){
			this.configDefaults = new LinkedHashMap<String, Object>();
			this.config = new YamlConfiguration();
			
						
			this.configDefaults.put("pluginEnabled", false);
			this.configDefaults.put("Wand", 280);
			this.configDefaults.put("Worlds", Arrays.asList("world", "world_nether", "world_the_end","YOUREXTRAWORLDSHERE"));
						
			if (configFile.exists()){
				try {
					this.config.load(configFile);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
			boolean updateNeeded = false;
			
			for (String key : this.configDefaults.keySet()){
				if (this.config.contains(key) == false){
					this.config.set(key, this.configDefaults.get(key));
					
					updateNeeded = true;
				}
			}
			
			if (updateNeeded){
				try {
					this.config.save(configFile);
					plugin.log.info("The config.yml file has been updated.");
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		
		public boolean getBoolean(String key){
			if (this.configDefaults.containsKey(key) == false){
				return false;
			}
			
			return this.config.getBoolean(key, (Boolean) this.configDefaults.get(key));
		}
		
		public int getInt(String key){
			if (this.configDefaults.containsKey(key) == false){
				return 0;
			}
			
			return this.config.getInt(key, (Integer) this.configDefaults.get(key));
		}
		
		public double getDouble(String key){
			if (this.configDefaults.containsKey(key) == false){
				return 0.0;
			}
			
			return this.config.getDouble(key, (Double) this.configDefaults.get(key));
		}
		
		public List<String> getStringList(String key){
			if (this.configDefaults.containsKey(key) == false){
				return new ArrayList<String>();
			}
			
			return this.config.getStringList(key);
		}
		
		public String getRandomStringFromList(String key){
			List<String> list = this.getStringList(key);
			
			return list.get((int) (Math.random() * (list.size() - 1)));
		}
		
		
	}
	


