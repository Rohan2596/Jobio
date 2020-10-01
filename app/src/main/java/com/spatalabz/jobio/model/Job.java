package com.spatalabz.jobio.model;


public class Job {

    private String title;
    private String company;
    private String wagePerHour;
    private String wagePerYear;

    public Job(String title, String company, String wagePerHour, String wagePerYear) {
        this.title = title;
        this.company = company;
        this.wagePerHour = wagePerHour;
        this.wagePerYear = wagePerYear;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getWagePerHour() {
        return wagePerHour;
    }

    public String getWagePerYear() {
        return wagePerYear;
    }
}
