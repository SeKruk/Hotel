package org.example.hotel;

import java.util.UUID;

public class Hotel {
    private UUID id;
    private String name;
    private String country;
    private String city;

    public Hotel(UUID id, String name, String country, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getCountry(){return country;}
    public String getCity(){ return city;}

}
