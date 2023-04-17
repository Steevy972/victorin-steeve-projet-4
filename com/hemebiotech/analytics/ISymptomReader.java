package com.hemebiotech.analytics;

import java.util.List;

/**
* Lit les donnees a partir de la source Symptoms.txt .
* 
* @author Steeve VICTORIN
*/
public interface ISymptomReader {
  /**
  * Si aucune donnee n'est disponible, renvoie une liste vide.
  * 
  * @return une liste brute de tous les symptomes obtenus a partir d'une source
  *         de donnees, les doublons sont possibles/probables
  */
  List<String> getSymptoms();
}
