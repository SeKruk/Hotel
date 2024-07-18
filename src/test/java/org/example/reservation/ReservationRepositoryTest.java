package org.example.reservation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationRepositoryTest {

    @Test
    void testAddReservation(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //when
        repository.addReservation(reservation);

        //then
        assertEquals(1, repository.getAllReservations().size());
    }
    @Test
    void testDeleteReservation(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //when
        repository.addReservation(reservation);
        boolean removed = repository.deleteReservation(432432);
        assertTrue(removed);
        //then
        assertNull(repository.findReservationById(432432));
    }

    @Test
    void testGetAllReservations(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate1 = LocalDate.of(2023, 5, 28);
        LocalDate startDate2 = LocalDate.of(2023, 6, 28);
        LocalDate startDate3 = LocalDate.of(2023, 7, 28);
        LocalDate endDate1 = LocalDate.of(2023, 5, 29);
        LocalDate endDate2 = LocalDate.of(2023, 6, 29);
        LocalDate endDate3 = LocalDate.of(2023, 7, 29);
        Reservation reservation1 = new Reservation(432432, 5, "Marriott", 5432, startDate1, endDate1);
        Reservation reservation2 = new Reservation(432432, 5, "Marriott", 5432, startDate2, endDate2);
        Reservation reservation3 = new Reservation(432432, 5, "Marriott", 5432, startDate3, endDate3);
        repository.addReservation(reservation1);
        repository.addReservation(reservation2);
        repository.addReservation(reservation3);

        //when
        List<Reservation> allReservations = repository.getAllReservations();

        //then
        assertEquals(3,allReservations.size());
        assertTrue(allReservations.contains(reservation1));
        assertTrue(allReservations.contains(reservation2));
        assertTrue(allReservations.contains(reservation3));
    }

    @Test
    void testFindReservationsByGuestId(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //when
        repository.addReservation(reservation);
        Reservation foundReservation = repository.findReservationByGuestId(5432);

        //then
        assertEquals(5432, foundReservation.getGuestIdNumber());
    }
    @Test
    void testFindReservationById(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //when
        repository.addReservation(reservation);
        Reservation foundReservation = repository.findReservationById(432432);

        //then
        assertEquals(432432, foundReservation.getReservationId());
    }
    @Test
    void testFindReservationByHotelName(){
        //given
        ReservationRepository repository = new ReservationRepository();
        LocalDate startDate  = LocalDate.of(2023,5,28);
        LocalDate endDate = LocalDate.of(2023,5,29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //when
        repository.addReservation((reservation));
        Reservation foundReservation = repository.findReservationByHotelName("Marriott");

        //then
        assertEquals("Marriott", foundReservation.getHotelName());

    }

}
