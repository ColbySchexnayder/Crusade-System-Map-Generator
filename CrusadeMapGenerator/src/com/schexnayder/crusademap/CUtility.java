package com.schexnayder.crusademap;

import java.util.ArrayList;
import java.util.Random;

public class CUtility {
	
	final static int DIE = 6;
	static Random ran = new Random();
	static ArrayList <Integer> quirkFilter = new ArrayList<Integer>();
	ArrayList <Integer> moonClimateFilter = new ArrayList<Integer>();
	ArrayList <Integer> planetClimateFilter = new ArrayList<Integer>();
	ArrayList <Integer> planetDesignationFilter = new ArrayList<Integer>();
	ArrayList <Integer> moonDesignationFilter = new ArrayList<Integer>();
	
	static String [] possibleQuirks = {
			
		"Civil Unrest",
		"Evacuated Population",
		"Terraformed Biosphere",
		"Lost Xeno Relic",
		"Atmospheric Interference",
		"Unreliable Power Grid",
			
		"Noxious Atmosphere",
		"Localized Warp Storms",
		"Unreliable Maps",
		"Resettled World",
		"Magnetic Flux",
		"Ancient Labyrinths",
			
		"Turbulent Weather",
		"Tidally Locked",
		"Historic Battleground",
		"Unsettling Ambience",
		"Exterminated Biosphere",
		"Volatile Tectonics"
			
	};
	
	
	
	static String [] possibleMoonClimates = {
			"Organic Mass",
			"Jungle Moon",
			"Artificial",
			"Captured Asteroid",
			"Frozen Wastes",
			"Molten",
			"Toxic Mire",
	};
	
	static String [] possiblePlanetClimates = {
			"Wasteland",
			"Desert",
			"Artic",
			"Tropical",
			"Oceanic",
			"Swamp",			
			"Storm"
	};

	static String [][] possibleDesignations = {
			{"Hive World, Imperialis",			"A"},
			{"Agriculture World, Imperialis",	"B"}, 
			{"Civilized World, Imperialis",		"A"}, 
			{"Shrine World, Imperialis",		"A"},
			{"Forge World, Mechanicus",			"A"},
			{"Mining World, Mechanicus",		"C"},
			{"Dead World, Exotic",				"C"},
			{"Frontier World, Exotic",			"B"}			
	};
	
	static String [] possibleMoonDesignations = {
			"Trade Port",
			"Defense Outpost",
			"Colony Settlement",
			"Dead World",
			"Archeology Site",
			"Waste Site"
	};
	
	
	public static String getQuirk() {
		int num = ran.nextInt(possibleQuirks.length);
		int filterSize = quirkFilter.size();
		
		if (filterSize == 1) {
			while (num == quirkFilter.get(filterSize - 1)) {
				num = ran.nextInt(possibleQuirks.length);
			}
		}
		
		if (filterSize > 1) {
			while (num == quirkFilter.get(filterSize - 1) || num == quirkFilter.get(filterSize - 2)) {
				num = ran.nextInt(possibleQuirks.length);
			}
		}
		
		
		
		quirkFilter.add(num);
		
		if (quirkFilter.size() > 10) {
			quirkFilter.remove(0);
		}
		
		return possibleQuirks[num];
	}
	
}
