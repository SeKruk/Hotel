package org.example.report;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

    @Test
    void testCreateReport(){
        //given
        LocalDate reportDate =  LocalDate.of(2023, 5, 28);
        Report report = new Report(1, "Hotel Marriott", reportDate);

        //then
        assertEquals(1, report.getReportID());
        assertEquals("Hotel Marriott", report.getTitle());
        assertEquals(reportDate, report.getReportDate());

    }
}
