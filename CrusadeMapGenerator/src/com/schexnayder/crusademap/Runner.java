package com.schexnayder.crusademap;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapGenerator m = new MapGenerator();
		JOptionPane.showMessageDialog(null, m);
		
		try {
			FileWriter fw = new FileWriter("SystemMap.txt");
			fw.write(m.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
