package org.example.hotel;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Repository
public class HotelRepository {
    private final Map<UUID, Hotel> map = new HashMap();
    public void addHotel(Hotel hotel){
        map.put(hotel.getId(), hotel);
    }
    public  void deleteHotel(Hotel hotel){map.put(hotel.getId(), hotel);};
    public Hotel findHotelById(UUID id) {
        return map.get(id);
    }

    // baza danych
}
