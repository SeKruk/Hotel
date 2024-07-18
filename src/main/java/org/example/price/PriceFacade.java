package org.example.price;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class PriceFacade {
    private PriceRepository priceRepository;
    public PriceFacade(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }
    public void addPrice(String nameHotel, int room, double costs, LocalDate startDate, LocalDate endDate){
        Price price = new Price(nameHotel,room,costs,startDate,endDate);
        priceRepository.addPrice(price);
    }
    public boolean removePricee(String nameHotel, int room){
        return priceRepository.deletePrice(nameHotel,room);
    }
    public Price findPriceByHotel(String nameHotel){
        return priceRepository.findPriceByHotel(nameHotel);
    }
    public Price findPriceByRoomAndDate(int roomNumber, LocalDate date) {
        return priceRepository.findPriceByRoomAndDate(roomNumber, date);
    }
}
