package org.example.reservation;

import java.time.LocalDate;

public class Reservation {
private int reservationID;
private int roomNumber;
private String hotelName;
private int guestIdNumber;
private LocalDate startDate;
private LocalDate endDate;

public Reservation(int reservationID, int roomNumber,String hotelName, int guestIdNumber, LocalDate startDate, LocalDate endDate){
    this.reservationID = reservationID;
    this.roomNumber = roomNumber;
    this.hotelName = hotelName;
    this.guestIdNumber = guestIdNumber;
    this.startDate = startDate;
    this.endDate = endDate;
}
    public int getReservationId() {
        return reservationID;
    }

    public int getGuestIdNumber() {
        return guestIdNumber;
    }
    public String getHotelName() {
        return hotelName;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

