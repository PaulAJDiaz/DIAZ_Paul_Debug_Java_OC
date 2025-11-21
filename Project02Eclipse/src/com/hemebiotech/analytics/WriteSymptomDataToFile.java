package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class WriteSymptomDataToFile implements ISymptomWriter {
    abstract ArrayList<String> GetSymptoms();
    TreeMap<String, Integer> writeSymptoms = new TreeMap<String, Integer>();

     for(String symptom : GetSymptoms) {
        if(writeSymptoms.containsKey(symptom)) {
            writeSymptoms.put(symptom, writeSymptoms.get(symptom) + 1);
        }else{
            writeSymptoms.put(symptom, 1);
        }
    }
    FileWriter fileWriter = new FileWriter ("result.out");
    BufferedWriter writer = new BufferedWriter(fileWriter);

        for(Map.Entry<String, Integer> entry ; writeSymptoms.entrySet()) {
        writer.write(entry.getKey() + ": " + entry.getValue()+ "\n" );
    }
        writer.close();
}


