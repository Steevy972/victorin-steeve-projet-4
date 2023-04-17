package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Implementation de ISymptomReader.
* 
* @author Steeve VICTORIN
*/
public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  /**
  * Lecture du fichier.
  * 
  * @param filepath un chemin complet ou partiel vers un fichier
  *                              contenant des chaines de symptomes, un par ligne
  */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();
    
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    return result;
  }

}