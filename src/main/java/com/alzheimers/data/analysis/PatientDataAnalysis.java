package com.alzheimers.data.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.inference.TTest;

import com.alzheimers.data.model.PatientData;

public class PatientDataAnalysis {

  public static Map<String, Double> diagnosisByAgeGroup(List<PatientData> patientList) {
    Map<String, List<PatientData>> ageGroups = patientList.stream()
            .collect(Collectors.groupingBy(patient -> {
                int age = patient.getAge();
                if (age > 60 && age < 70) return "60-69";
                else if (age > 70 && age < 80) return "70-79";
                else return "80 and above";
            }));

    Map<String, Double> diagnosisRateByAgeGroup = new HashMap<>();
    for (Map.Entry<String, List<PatientData>> entry : ageGroups.entrySet()) {
        long totalInGroup = entry.getValue().size();
        long diagnosedInGroup = entry.getValue().stream()
                .filter(patient -> patient.getDiagnosis() == 1)
                .count();

        double diagnosisRate = (double) diagnosedInGroup / totalInGroup;
        diagnosisRateByAgeGroup.put(entry.getKey(), diagnosisRate);
    }

    return diagnosisRateByAgeGroup;
}
  
  public static Map<String, Double> diagnosisByGender(List<PatientData> patientList) {
    Map<String, List<PatientData>> genderGroups = patientList.stream()
            .collect(Collectors.groupingBy(patient -> patient.getGender() == 0 ? "Male" : "Female"));

    Map<String, Double> diagnosisRateByGender = new HashMap<>();
    for (Map.Entry<String, List<PatientData>> entry : genderGroups.entrySet()) {
        long totalInGroup = entry.getValue().size();
        long diagnosedInGroup = entry.getValue().stream()
                .filter(patient -> patient.getDiagnosis() == 1)
                .count();

        double diagnosisRate = (double) diagnosedInGroup / totalInGroup;
        diagnosisRateByGender.put(entry.getKey(), diagnosisRate);
    }

    return diagnosisRateByGender;
  }
  
  public static Map<String, Double> diagnosisByBMIGroup(List<PatientData> patientList) {
    Map<String, List<PatientData>> bmiGroups = patientList.stream()
            .collect(Collectors.groupingBy(patient -> {
                float bmi = patient.getBmi();
                if (bmi < 18.5) return "Underweight";
                else if (bmi < 24.9) return "Normal weight";
                else if (bmi < 29.9) return "Overweight";
                else return "Obese";
            }));

    Map<String, Double> diagnosisRateByBMIGroup = new HashMap<>();
    for (Map.Entry<String, List<PatientData>> entry : bmiGroups.entrySet()) {
        long totalInGroup = entry.getValue().size();
        long diagnosedInGroup = entry.getValue().stream()
                .filter(patient -> patient.getDiagnosis() == 1)
                .count();

        double diagnosisRate = (double) diagnosedInGroup / totalInGroup;
        diagnosisRateByBMIGroup.put(entry.getKey(), diagnosisRate);
    }

    return diagnosisRateByBMIGroup;
  }

  public static Map<String, Double> diagnosisByPhysicalActivity(List<PatientData> patientList) {
    Map<String, List<PatientData>> activityGroups = patientList.stream()
            .collect(Collectors.groupingBy(patient -> {
                float activity = patient.getPhysicalactivity();
                if (activity < 2.0) return "Low";
                else if (activity < 4.0) return "Moderate";
                else return "High";
            }));

    Map<String, Double> diagnosisRateByActivityGroup = new HashMap<>();
    for (Map.Entry<String, List<PatientData>> entry : activityGroups.entrySet()) {
        long totalInGroup = entry.getValue().size();
        long diagnosedInGroup = entry.getValue().stream()
                .filter(patient -> patient.getDiagnosis() == 1)
                .count();

        double diagnosisRate = (double) diagnosedInGroup / totalInGroup;
        diagnosisRateByActivityGroup.put(entry.getKey(), diagnosisRate);
    }

    return diagnosisRateByActivityGroup;
  }

  public static Map<String, Double> diagnosisByFamilyHistory(List<PatientData> patientList) {
    Map<String, List<PatientData>> historyGroups = patientList.stream()
            .collect(Collectors.groupingBy(patient -> patient.getHistory() == 1 ? "Family History" : "No Family History"));

    Map<String, Double> diagnosisRateByHistoryGroup = new HashMap<>();
    for (Map.Entry<String, List<PatientData>> entry : historyGroups.entrySet()) {
        long totalInGroup = entry.getValue().size();
        long diagnosedInGroup = entry.getValue().stream()
                .filter(patient -> patient.getDiagnosis() == 1)
                .count();

        double diagnosisRate = (double) diagnosedInGroup / totalInGroup;
        diagnosisRateByHistoryGroup.put(entry.getKey(), diagnosisRate);
    }

    return diagnosisRateByHistoryGroup;
  }

  public static double tTestPhysicalActivity(List<PatientData> patientList) {
    List<Double> diagnosed = new ArrayList<>();
    List<Double> notDiagnosed = new ArrayList<>();

    for (PatientData patient : patientList) {
        if (patient.getDiagnosis() == 1) diagnosed.add((double) patient.getPhysicalactivity());
        else notDiagnosed.add((double) patient.getPhysicalactivity());
    }

    TTest tTest = new TTest();
    double[] diagnosedArray = diagnosed.stream().mapToDouble(Double::doubleValue).toArray();
    double[] notDiagnosedArray = notDiagnosed.stream().mapToDouble(Double::doubleValue).toArray();

    return tTest.tTest(diagnosedArray, notDiagnosedArray);
  }
}
