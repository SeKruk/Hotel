package org.example.room;


public class Room {
    private int number;
    private int beds;
    private String typeRoom;
    private double pricePerNight;
    private boolean available;

    public Room(int number, int beds,String typeRoom, double pricePerNight) {
        this.number = number;
        this.beds = beds;
        this.typeRoom = typeRoom;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }
    public int getNumber() {
        return number;
    }

    public int getBeds() {
        return beds;
    }
    public String getTypeRoom(){
        return typeRoom;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }
    public void book() {
        if (available) {
            available = false;
        }
    }
}
