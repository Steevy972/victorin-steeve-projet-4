package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
* Le point d'entree du programme.
* 
* @author Steeve VICTORIN
*
*/
public class Main {

  /**
  *Instancie les objet et rappelle les differentes méthodes d'AnalyticsCounter.
  * @param args un tableau d'argument de ligne de commande
  */
  public static void main(String[] args) {

    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
    List<String> symptoms = counter.getSymptoms();

    Map<String, Integer> countedSymptom = counter.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptom);
    counter.writeSymptoms(sortedSymptoms);

  }
}
