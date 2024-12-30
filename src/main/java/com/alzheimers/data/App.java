package com.alzheimers.data;

import java.util.List;

import com.alzheimers.data.model.PatientData;
import com.alzheimers.data.cleaning.PatientDataCleaner;
public class App {
    public static void main(String[] args) {
        PatientDataCleaner cleaner = new PatientDataCleaner();
        String inputFilePath = "alzheimers_disease_data.csv"; // Change to your input file path
        String outputFilePath = "cleaned_alzheimers_data.csv"; // Change to your output file path

        List<PatientData> rawData = cleaner.loadData(inputFilePath); // Load data
        List<PatientData> cleanedData = cleaner.cleanData(rawData); // Perform checks or minor cleaning
        cleaner.saveData(cleanedData, outputFilePath); // Save cleaned dat
    }
}
