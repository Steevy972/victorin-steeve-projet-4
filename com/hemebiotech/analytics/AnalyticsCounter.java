/**
* Compte les symptoms
*

*
* @return void
* @return sortedSymptoms
* @return countedSymptoms

* @author Steeve VICTORIN
* @version 1.0
*/




package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

  public ISymptomReader reader;
  public ISymptomWriter writer;

  public Map<String, Integer> countedSymptoms;
  public Map<String, Integer> sortedSymptoms;
  public Map<String, Integer> counter;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /** countedSymptoms compte les symptoms. */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {

    HashMap<String, Integer> countedSymptoms = new HashMap<>();

    for (String symptom : symptoms) {

      countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1);

    }
    return countedSymptoms;

  }

  /** sortedSymptoms sort les symptoms en les triant aphabétiquement. */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

    TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();

    sortedSymptoms.putAll(symptoms);

    return sortedSymptoms;
  }

  public void writeSymptoms(Map<String, Integer> symptoms) {
    this.writer.writeSymptoms(symptoms);
  }

}