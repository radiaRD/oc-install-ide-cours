package com.openclassrooms.ideinstall;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomeAnalyse;

public class BasicExample {

	public static void main(String[] args) {
		// String filepath =
		// "C:\\Users\\USER\\eclipse-workspace\\Project_1Java_Application
		// bug\\Project02Eclipse\\symptoms.txt";

		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile(filepath);

		// System.out.println(file.GetSymptoms());

		SymptomeAnalyse hm = new SymptomeAnalyse(file.GetSymptoms());

		hm.occurencesSortedSymptoms();

		for (int i = 0; i < hm.occurencesSortedSymptoms().size(); i++) {

			System.out.println(hm.occurencesSortedSymptoms().keySet().toArray()[i] + " = "
					+ hm.occurencesSortedSymptoms().values().toArray()[i]);

		}

		SymptomeAnalyse result = new SymptomeAnalyse(hm.occurencesSortedSymptoms());
		result.writeSymptoms();
	}
}
