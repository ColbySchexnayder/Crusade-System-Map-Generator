package com.schexnayder.crusademap;

import java.util.ArrayList;
import java.util.Random;

public class World {
	static enum Classification {
		MOON, PLANET, LARGE_PLANET
	}

	Classification classification = Classification.MOON;
	int nSectors = 0;
	int nLargeSectors = 0;
	int tValue = 0;
	char designationClass = ' ';
	String designation = "";
	String climate = "";
	ArrayList<String> quirks = new ArrayList<String>();
	ArrayList<World> moons = new ArrayList<World>();
	Random ran = new Random();

	public World(int nSectors, int largeSectors) {
		this.nSectors = nSectors;
		this.nLargeSectors = largeSectors;

		tValue = nSectors + largeSectors * 2;

		assignDesignation();
		determineClimate();
		narrativeQuirks();
	}
	
	public World(int nSectors, int largeSectors, String[] designationArray) {
		
	}

	public void narrativeQuirks() {
		
		quirks.add(CUtility.getQuirk());

		if (classification == Classification.LARGE_PLANET && quirks.size() == 1) {
			narrativeQuirks();
		}
	}

	public void determineClimate() {
		// 2D3 didn't give the full range so duplicates have been removed and the
		// roll changed to 2D4. This is a temporary fix until the design has been
		// updated.
		int roll2D4 = ran.nextInt(4) + ran.nextInt(4);
		if (classification == Classification.MOON) {
			climate = CUtility.possibleMoonClimates[roll2D4];
		} else {
			//int planetClimate = ran.nextInt(4);
			// TODO: Use designation class to aid with more realistic climates
			climate = CUtility.possiblePlanetClimates[roll2D4];
		}
	}

	public void assignDesignation() {
		int genPercent = ran.nextInt(100);
		if (genPercent < 10) {
			designation = "Hive World, Imperialis";
			designationClass = 'A';
		} else if (genPercent < 30) {
			designation = "Agriculture World, Imperialis";
			designationClass = 'B';
		} else if (genPercent < 50) {
			designation = "Civilized World, Imperialis";
			designationClass = 'A';
		} else if (genPercent < 60) {
			designation = "Shrine World, Imperialis";
			designationClass = 'A';
		} else if (genPercent < 75) {
			designation = "Forge World, Mechanicus";
			designationClass = 'A';
		} else if (genPercent < 90) {
			designation = "Mining World, Mechanicus";
			designationClass = 'C';
		} else if (genPercent < 95) {
			designation = "Dead World, Exotic";
			designationClass = 'C';
		} else {
			designation = "Frontier World, Exotic";
			designationClass = 'B';
		}

		if (tValue < 6) {
			classification = Classification.MOON;
			designation = CUtility.possibleDesignations[ran.nextInt(CUtility.DIE)][0];
			designationClass = 'M';
		} else if (nLargeSectors == 3) {
			classification = Classification.LARGE_PLANET;
		} else {
			classification = Classification.PLANET;

		}
	}

	@Override
	public String toString() {
		String s = "";
		s += classification + "\nSectors: " + nSectors + "\nLarge Sectors: " + nLargeSectors + "\nClimate: " + climate
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
