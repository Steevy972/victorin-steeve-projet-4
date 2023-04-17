package com.hemebiotech.analytics;

import java.util.Map;

/**
* Qui ecrira des donnees de symptomes sur un format de sortie de donnees valide.
* 
* @author Steeve VICTORIN
*
*/
public interface ISymptomWriter {
  /**
  * Ecrit les symptomes et leurs quantites dans le fichier result.out .
  * 
  * @param symptoms la liste des symptomes triees alphabetiquement avec le nombre
  *                 d'occurence
  */
  public void writeSymptoms(Map<String, Integer> symptoms);
}
