package org.example.Price;

import org.example.price.Price;
import org.example.price.PriceRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PriceRepositoryTest {
    @Test
    void testAddPrice(){
        //given
        PriceRepository repository = new PriceRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Price price = new Price("Marriott", 32,200.99,startDate, endDate);

        //when
        repository.addPrice(price);

        //then
        assertEquals(1, repository.getAllPrices().size());
    }
    @Test
    void testDeletePrice(){
        //given
        PriceRepository repository  = new PriceRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Price price = new Price("Marriott", 32,200.99,startDate, endDate);

        //when
        repository.addPrice(price);
        boolean removed = repository.deletePrice("Marriott", 32);


        //then
        assertTrue(removed);
        assertNull(repository.findPriceByRoomAndDate(32, startDate));
    }
    @Test
    void testFindPriceByHotel(){
        //given
        PriceRepository repository  = new PriceRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Price price = new Price("Marriott", 32,200.99,startDate, endDate);

        //when
        repository.addPrice(price);
        Price foundPrice = repository.findPriceByHotel("Marriott");

        //then
        assertEquals("Marriott", foundPrice.getNameHotel());
    }
    @Test
    void testFindPriceByRoomAndDate(){
        //given
        PriceRepository repository  = new PriceRepository();
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Price price = new Price("Marriott", 32,200.99,startDate, endDate);

        //when
        repository.addPrice(price);
        Price foundPrice = repository.findPriceByRoomAndDate(32,startDate);

        //then
        assertEquals(32, foundPrice.getRoom());
        assertEquals(startDate, foundPrice.getStartDate());
    }
    @Test
    void testGetAlLPrices(){
        //given
        PriceRepository repository  = new PriceRepository();
        LocalDate startDate1 = LocalDate.of(2023, 5, 28);
        LocalDate endDate1 = LocalDate.of(2023, 5, 29);
        Price price1 = new Price("Marriott", 32,200.99,startDate1, endDate1);
        LocalDate startDate2 = LocalDate.of(2023, 6, 28);
        LocalDate endDate2 = LocalDate.of(2023, 6, 29);
        Price price2 = new Price("Marriott", 32,200.99,startDate2, endDate2);
        repository.addPrice(price1);
        repository.addPrice(price2);

        //when
        List<Price> allPrices = repository.getAllPrices();

        //then
        assertEquals(2,allPrices.size());
        assertTrue(allPrices.contains(price1));
        assertTrue(allPrices.contains(price2));
    }
}
