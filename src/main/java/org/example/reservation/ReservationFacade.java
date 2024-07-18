package org.example.reservation;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class ReservationFacade {
    private ReservationRepository reservationRepository;
    public ReservationFacade(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;}

    public void addReservation(int reservationID, int roomNumber, String hotelName, int guestIdNumber, LocalDate startDate, LocalDate endDate){
        Reservation reservation = new Reservation(reservationID,roomNumber,hotelName,guestIdNumber,startDate,endDate);
        reservationRepository.addReservation(reservation);
    }

    public boolean removeReservation(int reservationID){
        return reservationRepository.deleteReservation(reservationID);
    }


}
