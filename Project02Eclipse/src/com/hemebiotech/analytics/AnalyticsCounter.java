package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static TreeMap<String, Integer> countSymptoms(List<String> getSymptoms) {
        TreeMap<String, Integer> countSymptomsMap = new TreeMap<String, Integer>();


        for(String symptom : getSymptoms) {
            if(countSymptomsMap.containsKey(symptom)) {
                countSymptomsMap.put(symptom, countSymptomsMap.get(symptom) + 1);
            }else{
                countSymptomsMap.put(symptom, 1);
            }
        }
        return countSymptomsMap;
    }


	public static void main(String args[]) throws Exception {

        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> getSymptoms = readSymptomDataFromFile.GetSymptoms();
        ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile();
        TreeMap <String, Integer> countSymptomsMap = AnalyticsCounter.countSymptoms(getSymptoms);
        writeSymptomDataToFile.writeSymptoms(countSymptomsMap);


       /* ArrayList<String> listSymptoms = new ArrayList<String>();
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
        writer.close();*/
	}
}
