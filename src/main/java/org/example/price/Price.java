package org.example.price;

import java.time.LocalDate;

public class Price {
    private String nameHotel;
    private int room;
    private double costs;
    private LocalDate startDate;
    private LocalDate endDate;


    public Price(String nameHotel, int room,double costs, LocalDate startDate, LocalDate endDate){
        this.nameHotel = nameHotel;
        this.room = room;
        this.costs = costs;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public String getNameHotel(){
        return this.nameHotel;
    }
    public int getRoom(){
        return this.room;
    }
    public double getCosts(){
        return costs;
    }
    public LocalDate getStartDate(){
        return this.startDate;
    }
    public LocalDate getEndDate(){
        return this.endDate;
    }
}
