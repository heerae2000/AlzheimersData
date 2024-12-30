package com.alzheimers.data.model;

public class PatientData {

    private int diagnosis;
    private int history;
    private int age;
    private int gender;
    private float physical_activity;
    private float bmi;
    
    public PatientData(int diagnosis, int history, int age, int gender, float physical_activity, float bmi) {
        this.diagnosis = diagnosis;
        this.history = history;
        this.age = age;
        this.gender = gender;
        this.physical_activity = physical_activity;
        this.bmi = bmi;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public void setPhysicalactivity(float physical_activity) {
        this.physical_activity = physical_activity;
    }
    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public void setDiagnosis(int diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getHistory() {
        return history;
    }

    public int getDiagnosis() {
        return diagnosis;
    }

    public int getAge() {
        return age;
    }
    public int getGender() {
        return gender;
    }
    public float getPhysicalactivity() {
        return physical_activity;
    }
    public float getBmi() {
        return bmi;
    }


}
