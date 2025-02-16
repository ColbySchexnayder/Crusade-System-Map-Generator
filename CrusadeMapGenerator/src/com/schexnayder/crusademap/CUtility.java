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
	
	static enum factions {
		Adeptus_Astartes,
		Adeptus_Sororitas,
		Adeptus_Mechanicus,
		Astra_Militarum,
		Inquisition,
		Black_Legion,
		Tzeentch,
		Khorne,
		Slaanesh,
		Nurgle,
		Craft_World,
		Harlequinn,
		Ynnari,
		Drukhari,
		Leagues_Of_Votann,
		Nekron,
		Ork,
		Tau,
		Tyranids
	}
	
	static enum alliances{
		Imperium,
		Chaos,
		Aeldari,
		Xenos,
		Generic
	}
	
	static String [][] factionWorlds = {
			{"Homeworld", "Breeding World", "Fief World", "Recruiting World"},//Adeptus_Astartes,
			{"Sanctuary World", "Shrine World", "Archive World", "Cardinal World", "Cemetary World"},//Adeptus_Sororitas,
			{"Forge World", "Knight World", "Mining World", "Quarry World"},//Adeptus_Mechanicus,
			{},//Astra_Militarum,
			{"Quarantined World"},//Inquisition,
			{},//Black_Legion,
			{},//Tzeentch,
			{},//Khorne,
			{},//Slaanesh,
			{},//Nurgle,
			{},//Craft_World,
			{},//Harlequinn,
			{},//Ynnari,
			{"Quarry World"},//Drukhari,
			{"Kin World", "Hold World", "Mining World", "Merchant World"},//Leagues_Of_Votann,
			{"Crown World", "Core World", "Fringe World", "Quarry World"},//Nekron,
			{"Ork World"},//Ork,
			{"Homeworld", "First Phase Colony", "Second Phase Colony", "Third Phase Colony", "Fifth Phase Colony", "Sept World", "Splinter Sept World"},//Tau,
			{"Larder World"},//Tyranids
	};
	
	static String [][] allianceWorlds = {
			/*Imperium*/{"Agri World", "Civilised World", "Feral World", "Feudal World", "Frontier World", "Fortress World", "Hive World", "Penal World", "Repository World", "Sentinal World", 
				"Merchant World", "Battery World", "Warden World", "Astropathic Relay Station"}, //Imperium,
			
			/*Chaos*/{"Daemon World", "Hell Forge", "Heretic Astartes Fief World", "Heretic Astartes Recruiting World", "Fallen Knight World", "Cache World", "Crone World"}, //Chaos,
			
			/*Aeldari*/{"Exodite World", "Crone World", "Major Craft World", "Minor Craft World"}, //Aeldari,
			
			/*Xenos*/{"Warden World"}, //Xenos,
			
			/*Generic*/{"Dead World", "Death World", "Gas Giant", "Derelict World", "Chem World", "Mountain World", "Rad World", "Maiden World", "Industrial World", "Labyrinth World", "Paradise World",
				"Research Station", "Relic World"},//Generic
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
