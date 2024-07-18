package org.example.report;

import java.time.LocalDate;

public class Report {
    private int reportID;
    private String title;
    private LocalDate reportDate;

    public Report(int reportID, String title, LocalDate reportDate){
        this.reportID = reportID;
        this.title = title;
        this.reportDate = reportDate;
    }

    public int getReportID(){
        return  reportID;
    }
    public String getTitle(){
        return title;
    }
    public LocalDate getReportDate(){
        return reportDate;
    }
}
