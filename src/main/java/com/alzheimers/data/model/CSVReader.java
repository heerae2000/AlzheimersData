package com.alzheimers.data.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<PatientData> readCSV(String filePath) {
        List<PatientData> patientList = new ArrayList<>();
        
        try {
            Reader reader = new FileReader(filePath);
            
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());
            
            for (CSVRecord record : csvParser) {
                int id = Integer.parseInt(record.get("PatientID"));
                int age = Integer.parseInt(record.get("Age"));
                int gender = Integer.parseInt(record.get("Gender"));
                float physical_activity = Float.parseFloat(record.get("PhysicalActivity"));
                float bmi = Float.parseFloat(record.get("BMI"));

                PatientData patient = new PatientData(id, age, gender, physical_activity, bmi);
                patientList.add(patient);
            }

            csvParser.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return patientList;
    }
}
