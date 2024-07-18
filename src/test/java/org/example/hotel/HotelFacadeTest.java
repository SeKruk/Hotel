package org.example.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HotelFacadeTest {

    @Test
    void shouldAddHotel() {
        // given
        HotelRepository repository = new HotelRepository();
        HotelFacade facade = new HotelFacade(repository);


        // when
        UUID id = facade.addHotel("first", "Poland", "Warsaw");


        // then
        Hotel result = facade.pobierz(id);
        System.out.println(id);
        Assertions.assertEquals("first", result.getName());
    }

}