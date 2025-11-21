package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void GetSymptoms() {
		ArrayList<String> GetSymptoms = new ArrayList<String>();

		if (filepath != null) {
			try {
                BufferedReader reader = new BufferedReader (new FileReader("C:\\Users\\dieze\\Videos\\OC_Projet\\P2\\DIAZ_Paul_Debug_Java_OC\\Project02Eclipse\\symptoms.txt"));
				String line = reader.readLine();

                while (line != null) {
                    GetSymptoms.add(line);
                    line = reader.readLine();

                }

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ;
	}

}
