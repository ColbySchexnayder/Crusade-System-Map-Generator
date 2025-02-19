package com.schexnayder.crusademap;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.schexnayder.crusademap.CUtility.Alliances;
import com.schexnayder.crusademap.CUtility.Factions;

public class Window implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	ArrayList<JLabel> playerNumbers = new ArrayList<JLabel>();
	ArrayList<JTextField> playerNames = new ArrayList<JTextField>();
	ArrayList<JComboBox<Alliances>> allianceSelections = new ArrayList<JComboBox<Alliances>>();
	ArrayList<JComboBox<Factions>> factionSelections = new ArrayList<JComboBox<Factions>>();
	
	JButton addPlayer = new JButton("Add Player");
	JButton removePlayer = new JButton("Remove Player");
	JComboBox<String> gameSize = new JComboBox<String>(new String[] {"Small Map", "Medium Map", "Large Map"});
	JButton generateMap = new JButton("Generate Map");
	
	MapPanel mapPanel = new MapPanel();
	
	public Window() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(0,4));
		playerNumbers.add(new JLabel("Player #1: "));
		playerNumbers.add(new JLabel("Player #2: "));
		
		playerNames.add(new JTextField(10));
		playerNames.add(new JTextField(10));
		
		allianceSelections.add(new JComboBox<Alliances>(Alliances.values()));
		allianceSelections.add(new JComboBox<Alliances>(Alliances.values()));
		
		factionSelections.add(new JComboBox<Factions>(Factions.values()));
		factionSelections.add(new JComboBox<Factions>(Factions.values()));
		
		for (int i = 0; i < playerNumbers.size(); i++) {
			panel.add(playerNumbers.get(i));
			panel.add(playerNames.get(i));
			panel.add(allianceSelections.get(i));
			panel.add(factionSelections.get(i));
		}
		
		addPlayer.addActionListener(this);
		removePlayer.addActionListener(this);
		generateMap.addActionListener(this);
		
		panel.add(addPlayer);
		panel.add(removePlayer);
		panel.add(gameSize);
		panel.add(generateMap);
		frame.add(panel);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == addPlayer) {
			playerNumbers.add(new JLabel("Player #" + (playerNumbers.size()+1) + ": "));
			playerNames.add(new JTextField(10));
			allianceSelections.add(new JComboBox<Alliances>(Alliances.values()));
			factionSelections.add(new JComboBox<Factions>(Factions.values()));
			
			panel.remove(addPlayer);
			panel.remove(removePlayer);
			panel.remove(gameSize);
			panel.remove(generateMap);
			
			panel.add(playerNumbers.get(playerNumbers.size()-1));
			panel.add(playerNames.get(playerNames.size()-1));
			panel.add(allianceSelections.get(allianceSelections.size()-1));
			panel.add(factionSelections.get(allianceSelections.size()-1));
			
			panel.add(addPlayer);
			panel.add(removePlayer);
			panel.add(gameSize);
			panel.add(generateMap);
			
			frame.pack();
		}
		else if (source == removePlayer) {
			panel.remove(addPlayer);
			panel.remove(removePlayer);
			panel.remove(gameSize);
			panel.remove(generateMap);
			
			panel.remove(playerNumbers.get(playerNumbers.size()-1));
			panel.remove(playerNames.get(playerNames.size()-1));
			panel.remove(allianceSelections.get(allianceSelections.size()-1));
			panel.remove(factionSelections.get(allianceSelections.size()-1));
			
			playerNumbers.remove(playerNumbers.size()-1);
			playerNames.remove(playerNames.size()-1);
			allianceSelections.remove(allianceSelections.size()-1);
			factionSelections.remove(factionSelections.size()-1);
			
			panel.add(addPlayer);
			panel.add(removePlayer);
			panel.add(gameSize);
			panel.add(generateMap);
			
			frame.pack();
		}
		else if (source == generateMap) {
			ArrayList<Player> p = new ArrayList<Player>();
			for (int i = 0; i < playerNumbers.size(); i++) {
				Alliances a = (Alliances) allianceSelections.get(i).getSelectedItem();
				Factions f = (Factions) factionSelections.get(i).getSelectedItem();
				String n = playerNames.get(i).getText();
				p.add(new Player(n, a, f));
				
			}
			int mapSize = gameSize.getSelectedIndex();
			
			MapGenerator mg = new MapGenerator(p, mapSize);
		}
	}
	
	
}
