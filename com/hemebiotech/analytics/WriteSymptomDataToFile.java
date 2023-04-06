package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
  /** writeSymptoms ecrit les symptoms dans le fichier result.out . */
  public void writeSymptoms(Map<String, Integer> symptoms) {

    try {
      FileWriter writer = new FileWriter(new File("result.out"));
      for (String symptom : symptoms.keySet()) {
        writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

  