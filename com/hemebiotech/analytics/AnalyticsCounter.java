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

public class AnalyticsCounter implements ISymptomReader, ISymptomWriter {

	public ISymptomReader reader;
	public ISymptomWriter writer;

	public Map<String, Integer> countedSymptoms;
	public Map<String, Integer> sortedSymptoms;
	public Map<String, Integer> counter;

	private String filepath;
	private static final String filepathSorti = "result.out";

	public AnalyticsCounter(List<String> symptoms) {

	}

	public AnalyticsCounter(String filepathFromParameter) {
		this.filepath = filepathFromParameter;
	}

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public List<String> getSymptoms() {
		List<String> symptoms = new ArrayList<String>();

		if (this.filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
				{
					String line = reader.readLine();

					while (line != null) {

						symptoms.add(line);
						line = reader.readLine();
					}
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return symptoms;
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		HashMap<String, Integer> countedSymptoms = new HashMap<>();

		for (String symptom : symptoms) {

			countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 1) + 1);

		}
		return countedSymptoms;

	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();

		sortedSymptoms.putAll(symptoms);

		return sortedSymptoms;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Stub de la méthode généré automatiquement
		try {
			FileWriter writer = new FileWriter(new File(filepathSorti));
			for (String sympetom : symptoms.keySet()) {
				writer.write(sympetom + ":" + symptoms.get(sympetom) + "\n");
			}
			writer.close();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		AnalyticsCounter reader = new AnalyticsCounter("symptoms.txt");
		AnalyticsCounter writer = new AnalyticsCounter(filepathSorti);
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = reader.getSymptoms();

		// for (String sort : symptoms) {

		// System.out.println("Symptom " + sort + " -> ");
		// }
		

		Map<String, Integer> countedSymptom = counter.countSymptoms(symptoms);

		// for (String soret : countedSymptom.keySet()) {

		// System.out.println("Symptom " + soret + " -> " + countedSymptom.get(soret));
		// }

		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptom);
		for (String key : sortedSymptoms.keySet()) {

			
			counter.writeSymptoms(sortedSymptoms);

		}

	}
}
