package org.example.guest;


import org.example.room.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestFacade {
    private GuestRepository guestRepository;
    public GuestFacade(GuestRepository guestRepository){this.guestRepository = guestRepository;}
   public void addGuest(String name, String surname, String email, int phone, int id, String password){
        Guest guest = new Guest(name,surname,email,phone,id, password);
        guestRepository.addGuest(guest);
   }
   public boolean removeGuest(int id){
        return guestRepository.removeGuest(id);
   }


}
