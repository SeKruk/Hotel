package org.example.guest;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class GuestRepository {
    private List<Guest> guests;
    public GuestRepository(){ this.guests = new ArrayList<>();}
    public void addGuest(Guest guest){ guests.add(guest);}
    public boolean removeGuest(int guestId){return guests.removeIf(guest -> guest.getId() == guestId);}

public List<Guest> getAllGuests(){ return new ArrayList<>(guests);}

public Guest findGuestById(int guestId){
        for (Guest guest : guests){
            if(guest.getId() == guestId){
                return guest;
            }
        }
        return null;

}


    // baza danych
}
