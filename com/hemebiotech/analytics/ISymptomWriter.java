/**
 * Anything the will write symptom data on a valid data output format
 *
 */




package com.hemebiotech.analytics;

import java.util.Map;



public interface ISymptomWriter {
  public void writeSymptoms(Map<String, Integer> symptoms);
}
