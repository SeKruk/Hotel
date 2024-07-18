package org.example.hotel;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class HotelFacade {
    //dodawanie, usuwanie hotel

    private HotelRepository hotelRepository;

    public HotelFacade(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public UUID addHotel(String name, String country, String city) {
        Hotel hotel = new Hotel(
                UUID.randomUUID(),
                name,
                country,
                city

        );
        hotelRepository.addHotel(hotel);
        return hotel.getId();
    }
    public void deleteHotel(UUID hotelId) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);

        if (hotel != null) {
            hotelRepository.deleteHotel(hotel);

        }
    }
    public Hotel pobierz(UUID id) {
        return hotelRepository.findHotelById(id);
    }
}
