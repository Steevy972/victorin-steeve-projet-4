package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private static final String filepathSorti = "result.out";

	public ISymptomReader reader;
	public ISymptomWriter writer;

	public Map<String, Integer> countedSymptoms;
	public Map<String, Integer> sortedSymptoms;
	public Map<String, Integer> counter;

	private String filepath;

	public AnalyticsCounter(String filepathFromParameter) {
		this.filepath = filepathFromParameter;
	}

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return this.reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		HashMap<String, Integer> countedSymptoms = new HashMap<>();

		for (String symptom : symptoms) {

			countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1);

		}
		return countedSymptoms;

	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();

		sortedSymptoms.putAll(symptoms);

		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms){
		this.writer.writeSymptoms(symptoms);
	}

	}