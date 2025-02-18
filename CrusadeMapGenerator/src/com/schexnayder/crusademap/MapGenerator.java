package com.schexnayder.crusademap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

import com.schexnayder.crusademap.CUtility.*;
import com.schexnayder.crusademap.World.Classification;

public class MapGenerator {
	
	int nWorlds = 0;
	int nPlayers = 0;
	int mapSize = 0; //0.Only War: No gaps between players //1.Eternal Crusade: Players only get one starting planet and have small gaps between them //2. Space Opera: Player's get three starting planets and a large map between them
	ArrayList<World> worlds = new ArrayList<World>();
	ArrayList<Player> players = new ArrayList<Player>();
	Random ran = new Random();
	
	public MapGenerator() {
		
		nPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
		
		
		//There should be 2 + nPlayer worlds including moons
		nWorlds = 2+nPlayers;
		generateWorlds(nWorlds);
		assignMoons();
		
	}
	
	public MapGenerator(ArrayList<Player> playerList) {
		players = playerList;
		for (Player p : players) {
			
		}
	}
	
	//Generate worlds
	public void generateWorlds(int nPlayers) {
		for (int i = 0; i < nWorlds; i++) {
			//Generate number of Sectors
			int sectors = ran.nextInt(5) + 3;
			int largeSectors = ran.nextInt(4);
			
			World world = new World(sectors, largeSectors);
			
			worlds.add(world);
			
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
	
	
	@Override
	public String toString() {
		String s = "";
		for (World w : worlds) {
			s += w.toString() + "\n\n";
		}
		return s;
	}
}
