package com.schexnayder.crusademap;

import com.schexnayder.crusademap.CUtility.Alliances;
import com.schexnayder.crusademap.CUtility.Factions;

public class Player {
	String name;
	Alliances alliance;
	Factions faction;
	World startingWorld;
	
	public Player(String name, Alliances allies, Factions faction) {
		this.name = name;
		alliance = allies;
		this.faction = faction;
	}
	
	public void setWorld(World world) {
		startingWorld = world;
	}
	
	public World getWorld() {
		return startingWorld;
	}
}
