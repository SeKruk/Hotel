package org.example.Price;

import org.example.price.Price;
import org.example.price.PriceFacade;
import org.example.price.PriceRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PriceFacadeTest {
    @Test
    void testAddPrice(){
        //given
        PriceRepository repository = new PriceRepository();
        PriceFacade facade = new PriceFacade(repository);

        //when
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        facade.addPrice("Marriott", 32,200.99,startDate, endDate);

        //then
        assertEquals(1, repository.getAllPrices().size());

    }
    @Test
    void testRemovePrices(){
        //given
        PriceRepository repository = new PriceRepository();
        PriceFacade facade = new PriceFacade(repository);

        //when
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        facade.addPrice("Marriott", 32,200.99,startDate, endDate);
        boolean removed = facade.removePricee("Marriott",32);
        assertTrue(removed);

        //then
        assertNull(repository.findPriceByRoomAndDate(32,startDate));
    }
    @Test
    void testFindPriceByHotel(){
        //given
        PriceRepository repository = new PriceRepository();
        PriceFacade facade = new PriceFacade(repository);
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        facade.addPrice("Marriott", 32,200.99,startDate, endDate);

        //when
        Price foundPrice = facade.findPriceByHotel("Marriott");

        //then
        assertNotNull(foundPrice);
        assertEquals("Marriott", foundPrice.getNameHotel());
    }
    @Test
    void testFindPriceByRoomAndDate(){
        //given
        PriceRepository repository = new PriceRepository();
        PriceFacade facade = new PriceFacade(repository);
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        facade.addPrice("Marriott", 32,200.99,startDate, endDate);

        //when
        Price foundPrice = facade.findPriceByRoomAndDate(32, startDate);

        //then
        assertNotNull(foundPrice);
        assertEquals(32, foundPrice.getRoom());
        assertEquals(startDate, foundPrice.getStartDate());

    }
}
