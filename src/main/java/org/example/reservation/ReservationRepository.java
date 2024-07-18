package org.example.reservation;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ReservationRepository {
    private List<Reservation> reservations;
    private int nextId;
 public ReservationRepository(){
     this.reservations = new ArrayList<>();
    this.nextId = 1;
 }
 public void addReservation(Reservation reservation){ reservations.add(reservation);}
 public boolean deleteReservation(int reservationID){
     return reservations.removeIf(reservation -> reservation.getReservationId() == reservationID);
 }
 public List<Reservation> getAllReservations(){ return new ArrayList<>(reservations);}


    public Reservation findReservationByGuestId(int guestIdNumber){
        for(Reservation reservation : reservations){
            if(reservation.getGuestIdNumber() == guestIdNumber)
                return reservation;
        }
        return  null;
    }
    public Reservation findReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId)
                return reservation;
            }
        return null;
    }
    public Reservation findReservationByHotelName(String hotelName){
     for( Reservation reservation : reservations){
         if(reservation.getHotelName().equals(hotelName))
             return reservation;
         }
     return null;
    }

    public int getNextId(){
     return nextId++;
    }
}
