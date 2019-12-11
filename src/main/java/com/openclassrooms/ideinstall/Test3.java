package com.openclassrooms.ideinstall;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test3 {
	public ArrayList<String> listSymptoms;

	public Map<String, Integer> sortedMap;

	String s;

	int i;

	/**
	 * @param listSymptoms list of symptoms get from filepath.
	 */
	public SymptomeAnalyse(List<String> listSymptoms) {
		this.listSymptoms = (ArrayList<String>) listSymptoms;

	}

	/**
	 * @param sortedMap sortedMap is the list of symptoms with their occurrences.
	 *                  sortedMap is sorted alphabetically.
	 */
	public SymptomeAnalyse(Map<String, Integer> sortedMap) {
		this.sortedMap = (Map<String, Integer>) sortedMap;

	}

	/**
	 * occurencesSortedSymptoms sorts and calculates the occurrences of symptoms.
	 * 
	 * @return returns the list of symptoms in the form of map with (key: symptom ,
	 *         value: frequency), sorted alphabetically.
	 */
	public Map<String, Integer> occurencesSortedSymptoms() {

		HashMap<String, Integer> symptoms = new HashMap<String, Integer>();

		for (int i = 0; i < listSymptoms.size(); i++) {

			String s = listSymptoms.get(i);

			if (symptoms.containsKey(s)) {

				symptoms.put(s, symptoms.get(s) + 1);

			} else {

				symptoms.put(s, 1);
			}

		}

		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(symptoms);

		return sortedMap;
	}

	/**
	 * writeSymptoms writes the contents of the Map: sortedMap in the text file :
	 * "result.out".
	 * 
	 * @throws IOException If access to writing the file is refused.
	 *
	 */
	public void writeSymptoms() throws IOException {
		Map<String, Integer> sortedMap1 = new TreeMap<String, Integer>(sortedMap);
		try (FileWriter writer = new FileWriter("result.out");

				BufferedWriter bw = new BufferedWriter(writer)) {
			for (int i = 0; i < sortedMap1.size(); i++) {

				bw.write(sortedMap1.keySet().toArray()[i] + " = " + sortedMap1.values().toArray()[i] + "\n");

			}

			bw.close();
			writer.close();

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);

		}

	}
}
