package org.example.report;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportRepositoryTest {

    @Test
    void testAddReport(){
        //given
        ReportRepository repository = new ReportRepository();
        LocalDate createReport = LocalDate.of(2024,5,20);
        Report report = new Report(1, "Report Marriott", createReport);

        //when
        repository.addReport(report);

        //then
        assertEquals(1, repository.getAllReport().size());
    }
    
    @Test
    void testDeleteReport(){
        //given
        ReportRepository repository = new ReportRepository();
        LocalDate createReport = LocalDate.of(2024,5,20);
        Report report = new Report(1, "Report Marriott", createReport);

        //when
        repository.addReport(report);
        boolean removed = repository.deleteReport(1);

        //then
        assertTrue(removed);
        assertNull(repository.findReportById(1));
    }

    @Test
    void testFindReportById(){
        //given
        ReportRepository repository = new ReportRepository();
        LocalDate createReport = LocalDate.of(2024,5,20);
        Report report = new Report(1, "Report Marriott", createReport);

        //when
        repository.addReport(report);
        Report foundReport = repository.findReportById(1);

        //then
        assertEquals(1, foundReport.getReportID());
    }

    @Test
    void testGetAllReport(){
        //given
        ReportRepository repository = new ReportRepository();
        LocalDate timeCreateReport1 = LocalDate.of(2024,5,20);
        Report report1 = new Report(1, "Report Marriott", timeCreateReport1);
        Report report2 = new Report(2, "Report Tina", timeCreateReport1);

        repository.addReport(report1);
        repository.addReport(report2);

        //when
        List<Report> allReports = repository.getAllReport();

        //then
        assertEquals(2,allReports.size());
        assertTrue(allReports.contains(report1));
        assertTrue(allReports.contains(report2));
    }

}
