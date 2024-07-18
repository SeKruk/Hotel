package org.example.Price;

import org.example.price.Price;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @Test
    void  testPrice(){
        //given
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Price price = new Price("Marriott", 32,200.99,startDate, endDate);

        //then
        assertEquals("Marriott", price.getNameHotel());
        assertEquals(32, price.getRoom());
        assertEquals(200.99, price.getCosts());
        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
    }
}
