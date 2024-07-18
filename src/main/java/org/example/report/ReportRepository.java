package org.example.report;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ReportRepository {
    private List<Report> reports;
    private int nextId;

    public ReportRepository(){
        this.reports = new ArrayList<>();
        this.nextId =1;
    }
    public void addReport(Report report){reports.add(report);}
    public boolean deleteReport(int reportID){
        return reports.removeIf(report -> report.getReportID() == reportID);
    }

    public Report findReportById(int reportId){
        for(Report report : reports){
            if(report.getReportID() == reportId)
                return report;
        }
        return null;
    }
    public List<Report> getAllReport(){
        return new ArrayList<>(reports);
    }
    public int getNextId(){
        return nextId++;
    }
}
