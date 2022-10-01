package com.schexnayder.crusademap;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.schexnayder.crusademap.World.Classification;

public class MapGenerator {
	final static int DIE = 6;
	int nWorlds = 0;
	ArrayList<World> worlds = new ArrayList<World>();
	Random ran = new Random();
	
	public MapGenerator() {
		
		//There should be 2 + nPlayer worlds including moons
		nWorlds = 2+Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
		generateWorlds(nWorlds);
		assignMoons();
		assignDesignation();
		
	}
	
	//Generate worlds
	public void generateWorlds(int nPlayers) {
		for (int i = 0; i < nWorlds; i++) {
			//Generate number of Sectors
			int roll = ran.nextInt(DIE) + ran.nextInt(DIE) + 2;
			
			World world = new World(roll);
			
			//Destroy planet on bad roll
			if (ran.nextInt(DIE) == 0) {
				continue;
			}
			else {
				worlds.add(world);
			}
		}
	}
	
	//Assign moon to nearest planet; remove it from the list
	public void assignMoons() {
		for (int i = 0; i < worlds.size(); i++) {
			World moon = worlds.get(i);
			if (moon.classification == Classification.MOON) {
				if (i == 0 && worlds.size()>1) {
					worlds.get(i+1).moons.add(moon);
				}
				else if (i == worlds.size()-1) {
					worlds.get(i-1).moons.add(moon);
				}
				else if (worlds.get(i-1).nSectors>worlds.get(i).nSectors) {
					worlds.get(i-1).moons.add(moon); 
				}
				else {
					worlds.get(i+1).moons.add(moon);
				}
				worlds.remove(i);
				i--;
			}
		}
	}
	
	public void assignDesignation() {
		for (World w : worlds) {
			switch(ran.nextInt(DIE)) {
			case 0: w.designation = "Hive World, Imperialis"; break;
			case 1: w.designation = "Shrine World, Imperialis"; break;
			case 2: w.designation = "Forge World, Mechanicus"; break;
			case 3: w.designation = "Mining World, Mechanicus"; break;
			case 4: w.designation = "Research World, Exotic"; break;
			case 5: w.designation = "Frontier World, Exotic"; break;
			}
			
			for (World m : w.moons) {
				switch(ran.nextInt(DIE)) {
				case 0: m.designation = "Trade Port"; break;
				case 1: m.designation = "Defense Outpost"; break;
				case 2: m.designation = "Colony Settlement"; break;
				case 3: m.designation = "Dead World"; break;
				case 4: m.designation = "Archeology Site"; break;
				case 5: m.designation = "Waste Site"; break;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (World w : worlds) {
			s += w.toString() + "\n\n";
		}
		return s;
	}
}
