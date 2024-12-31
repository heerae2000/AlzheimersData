package com.alzheimers.data;

import java.util.List;

import com.alzheimers.data.model.PatientData;
import com.alzheimers.data.analysis.PatientDataAnalysis;
import com.alzheimers.data.model.CSVReader;
public class App {
    public static void main(String[] args) {
        String filePath = "alzheimers_disease_data.csv";
        List<PatientData> patientList = CSVReader.readCSV(filePath);
        double physicalActivityPValue = PatientDataAnalysis.tTestPhysicalActivity(patientList);
        System.out.println("Diagnosis by Physical Activity: " + PatientDataAnalysis.diagnosisByPhysicalActivity(patientList));
        System.out.println("P-value for Physical Activity vs. Diagnosis: " + physicalActivityPValue);
    }
}
