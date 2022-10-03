package com.schexnayder.crusademap;

import java.util.ArrayList;
import java.util.Random;

public class World {
	static enum Classification {
		MOON, PLANET, LARGE_PLANET
	}

	Classification classification = Classification.MOON;
	int nSectors = 0;
	String designation = "";
	ArrayList<World> moons = new ArrayList<World>();
	Random ran = new Random();
	public World(int nSectors) {
		this.nSectors = nSectors;
		
		switch(ran.nextInt(MapGenerator.DIE)) {
		case 0: designation = "Hive World, Imperialis"; break;
		case 1: designation = "Shrine World, Imperialis"; break;
		case 2: designation = "Forge World, Mechanicus"; break;
		case 3: designation = "Mining World, Mechanicus"; break;
		case 4: designation = "Research World, Exotic"; break;
		case 5: designation = "Frontier World, Exotic"; break;
		}
		
		if (nSectors < 6) {
			classification = Classification.MOON;
			
			switch(ran.nextInt(MapGenerator.DIE)) {
			case 0: designation = "Trade Port"; break;
			case 1: designation = "Defense Outpost"; break;
			case 2: designation = "Colony Settlement"; break;
			case 3: designation = "Dead World"; break;
			case 4: designation = "Archeology Site"; break;
			case 5: designation = "Waste Site"; break;
			}
		} else if (nSectors < 10) {
			classification = Classification.PLANET;
		} else {
			classification = Classification.LARGE_PLANET;
		}
	}

	@Override
	public String toString() {
		String s = "";
		s += classification + "\nSectors: " + nSectors + "\nDesignation: " + designation + "\n";

		if (!moons.isEmpty()) {
			s += "\nMOONS:\n\n";
			for (World m : moons) {
				s += m.toString();
			}
		}

		return s;
	}
}
