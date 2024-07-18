package org.example.price;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PriceRepository {
    private List<Price> prices;
    public PriceRepository(){
        this.prices = new ArrayList<>();
    }
    public void addPrice(Price price){ prices.add(price);}

    public boolean deletePrice(String nameHotel, int room){
        return prices.removeIf(price -> price.getNameHotel().equals(nameHotel) && price.getRoom() == room);
    }
    public Price findPriceByHotel(String nameHotel){
        for(Price price : prices){
            if(price.getNameHotel().equals(nameHotel))
                return price;
        }
        return null;
    }
    public Price findPriceByRoomAndDate(int room, LocalDate date){
        for(Price price : prices){
            if(price.getRoom() == room &&
                    (date.isEqual(price.getStartDate()) || date.isEqual(price.getEndDate()) ||
                            (date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate())))) {
                return price;
            }
        }
        return null;
    }
    public List<Price> getAllPrices() {
        return new ArrayList<>(prices);
    }

}
