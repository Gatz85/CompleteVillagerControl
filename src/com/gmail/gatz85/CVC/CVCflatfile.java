package com.gmail.gatz85.CVC;
/*
 * The base was grab from package com.bukkit.samkio.MoneyBukkit; not sure where i found it 
 * will remove if it is a license problem
 */

	

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.bukkit.entity.Player;

	public class CVCflatfile {
		
		public static void write(Player p, int SelctionID, File file) {
			Properties pro = new Properties();
			String selctionID = (new Integer(SelctionID)).toString();
			String player = p.getName();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);
				pro.setProperty(player, selctionID);
				pro.store(new FileOutputStream(file), null);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		public static int getSelectionID(Player p, File file) {
			Properties pro = new Properties();
			String player = p.getName();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);
				String string = pro.getProperty(player);
				int selctionID = Integer.parseInt(string);
				return selctionID;
			} catch (IOException e) {
				System.out.println(e.getMessage());

			}
			return 0;
		}

		public static boolean containskey(Player p, File file) {
			Properties pro = new Properties();
			String player = p.getName();
			try {
				FileInputStream in = new FileInputStream(file);
				pro.load(in);

				if (pro.containsKey(player))
					return true;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return false;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

