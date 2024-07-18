package org.example.report;

import org.example.guest.GuestRepository;
import org.example.hotel.HotelRepository;
import org.example.price.PriceRepository;
import org.example.reservation.ReservationRepository;
import org.example.room.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportFacade {
    private ReportRepository reportRepository;
    private ReservationRepository reservationRepository;
    private GuestRepository guestRepository;
    private RoomRepository roomRepository;
    private PriceRepository priceRepository;
    private HotelRepository hotelRepository;

    public ReportFacade(ReportRepository reportRepository,ReservationRepository reservationRepository,
                        GuestRepository guestRepository,RoomRepository roomRepository, PriceRepository priceRepository,
                        HotelRepository hotelRepository){
        this.reportRepository = reportRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.priceRepository = priceRepository;
        this.hotelRepository = hotelRepository;
    }
    


}
