package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

        ArrayList<String> listSymptoms = new ArrayList<String>();
        BufferedReader reader = new BufferedReader (new FileReader("C:\\Users\\dieze\\Videos\\OC_Projet\\P2\\DIAZ_Paul_Debug_Java_OC\\Project02Eclipse\\symptoms.txt"));
		String line = reader.readLine();
        TreeMap<String, Integer> symptoms = new TreeMap<String, Integer>();

		while (line != null) {
            listSymptoms.add(line);
            line = reader.readLine();

        }
        for(String symptom : listSymptoms) {
            if(symptoms.containsKey(symptom)) {
                symptoms.put(symptom, symptoms.get(symptom) + 1);
            }else{
                symptoms.put(symptom, 1);
            }
        }
        FileWriter fileWriter = new FileWriter ("result.out");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue()+ "\n" );
        }
        writer.close();
	}
}
