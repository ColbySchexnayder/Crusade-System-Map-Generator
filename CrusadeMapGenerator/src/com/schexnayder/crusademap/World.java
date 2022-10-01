package com.schexnayder.crusademap;

import java.util.ArrayList;

public class World {
	static enum Classification {
		MOON, PLANET, LARGE_PLANET
	}

	Classification classification = Classification.MOON;
	int nSectors = 0;
	String designation = "";
	ArrayList<World> moons = new ArrayList<World>();

	public World(int nSectors) {
		this.nSectors = nSectors;

		if (nSectors < 6) {
			classification = Classification.MOON;
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
