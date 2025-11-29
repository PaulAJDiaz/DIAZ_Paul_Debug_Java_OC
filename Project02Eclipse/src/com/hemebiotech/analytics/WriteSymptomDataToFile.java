package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter fileWriter = new FileWriter("result.out", false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                System.out.println(symptom.getKey() + ": " + symptom.getValue());
                writer.write(symptom.getKey() + ": " + symptom.getValue() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}




