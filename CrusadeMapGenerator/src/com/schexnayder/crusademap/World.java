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
	String climate = "";
	ArrayList<String> quirks = new ArrayList<String>();
	ArrayList<World> moons = new ArrayList<World>();
	Random ran = new Random();
	public World(int nSectors) {
		this.nSectors = nSectors;
		assignDesignation();
		determineClimate();
		narrativeQuirks();
	}

	public void narrativeQuirks() {
		int rollD3 = ran.nextInt(MapGenerator.DIE/2);
		int rollD6 = ran.nextInt(MapGenerator.DIE);
		switch(rollD3) {
		case 0:
			switch(rollD6) {
			case 0: quirks.add("Civil Unrest"); break;
			case 1: quirks.add("Evacuated Population"); break;
			case 2: quirks.add("Terraformed Biosphere"); break;
			case 3: quirks.add("Lost Xeno Relic"); break;
			case 4: quirks.add("Atmospheric Interference"); break;
			case 5: quirks.add("Unreliable Power Grid"); break;
			}
			break;
		case 1:
			switch(rollD6) {
			case 0: quirks.add("Noxious Atmosphere"); break;
			case 1: quirks.add("Localized Warp Storms"); break;
			case 2: quirks.add("Unreliable Maps"); break;
			case 3: quirks.add("Resettled World"); break;
			case 4: quirks.add("Magnetic Flux"); break;
			case 5: quirks.add("Ancient Labyrinths"); break;
			}
			break;
		case 2:
			switch(rollD6) {
			case 0: quirks.add("Turbulent Weather"); break;
			case 1: quirks.add("Tidally Locked"); break;
			case 2: quirks.add("Historic Battleground"); break;
			case 3: quirks.add("Unsettling Ambience"); break;
			case 4: quirks.add("Exterminated Biosphere"); break;
			case 5: quirks.add("Volatile Tectonics"); break;
			}
			break;
		}
		
		if (classification == Classification.LARGE_PLANET && quirks.size()==1) {
			narrativeQuirks();
		}
	}
	
	public void determineClimate() {
		int roll2D3 = 2 + ran.nextInt(MapGenerator.DIE/2) + ran.nextInt(MapGenerator.DIE/2);
		if (classification == Classification.MOON) {
			switch (roll2D3) {
			case 2: climate = "Captured Asteroid"; break;
			case 3: climate = "Molten"; break;
			case 4: climate = "Frozen Wastes"; break;
			case 5: climate = "Molten"; break;
			case 6: climate = "Toxic Mire"; break;
			case 7: climate = "Captured Asteroid"; break;
			case 8: climate = "Artificial"; break;
			case 9: climate = "Toxic Mire"; break;
			}
		}
		else {
			switch (roll2D3) {
			case 2: climate = "Wasteland"; break;
			case 3: climate = "Desert"; break;
			case 4: climate = "Artic"; break;
			case 5: climate = "Oceanic"; break;
			case 6: climate = "Swamp"; break;
			case 7: climate = "Wasteland"; break;
			case 8: climate = "Artificial"; break;
			case 9: climate = "Tropical"; break;
			}
		}
	}
	
	public void assignDesignation() {
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
		s += classification + "\nSectors: " + nSectors + "\nClimate: " + climate 
				+ "\nDesignation: " + designation + "\nQuirks:\n";
		
		for (String q : quirks) {
			s += q + "\n";
		}

		if (!moons.isEmpty()) {
			s += "\nMOONS:\n\n";
			for (World m : moons) {
				s += m.toString();
			}
		}

		return s;
	}
}
