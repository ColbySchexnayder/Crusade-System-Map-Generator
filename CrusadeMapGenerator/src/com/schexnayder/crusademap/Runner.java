package com.schexnayder.crusademap;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {

		do {
			MapGenerator m = new MapGenerator();
			JOptionPane.showMessageDialog(null, m);

			try {
				FileWriter fw = new FileWriter("SystemMap.txt", true);
				fw.write("NEW SYSTEM: \n");
				fw.write(m.toString());
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} while (JOptionPane.showConfirmDialog(null, "Generate another system?") == 0);
	}

}
