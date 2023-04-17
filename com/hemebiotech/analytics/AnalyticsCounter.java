package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* Analyse les symptomes.
* 
* @author Steeve VICTORIN
*
*/
public class AnalyticsCounter {

  /**
  * Lit les symptomes.
  */
  public ISymptomReader reader;

  /**
  * Ecrit les symptomes.
  */
  public ISymptomWriter writer;

  /**
  * Liste des Symptomes avec leur nombre d'occurence.
  */
  public Map<String, Integer> countedSymptoms;
  
  /**
  * Liste des symptomes et des occurrences par ordre alphabetique.
  */
  public Map<String, Integer> sortedSymptoms;
  
  /**
  * Liste qui peut etre utilisee pour la lecture et l'ecriture.
  */
  public Map<String, Integer> counter;

  /**
  * Qui assigne les valeurs de ces deux parametres a deux attibuts de classe.
  * 
  * @param reader lit les symptomes
  * @param writer ecrit les symptomes
  */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
  * Recupere la liste des entrees dans le fichier.
  * 
  * @return une liste de symptomes
  */
  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /**
  * Compte les occurences de chaque symptome existant.
  * 
  * @param symptoms c'est la liste de symptomes
  * @return Une liste des symptoms avec le nombre d'occurence
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {

    HashMap<String, Integer> countedSymptoms = new HashMap<>();

    for (String symptom : symptoms) {

      countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1);

    }
    return countedSymptoms;

  }

  /**
  * Trie la liste de symptomes et d'occurrences par ordre alphabetique.
  * 
  * @param symptoms c'est la liste des symptomes avec le nombre d'occurence
  * @return Une liste de symptomes et d'occurence par ordre alphabetiquement
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

    TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();

    sortedSymptoms.putAll(symptoms);

    return sortedSymptoms;
  }

  /**
  * Ecrit le résultat dans le fichier de sortie.
  * 
  * @param symptoms liste des symptomes tries alphabetiquement
  */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    this.writer.writeSymptoms(symptoms);
  }

}