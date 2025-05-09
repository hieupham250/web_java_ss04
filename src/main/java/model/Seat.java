package model;

public class Seat {
    private String id;
    private String name;
    private double price;
    private boolean booked;

    public Seat(String id, String name, double price, boolean booked) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.booked = booked;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isBooked() { return booked; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setBooked(boolean booked) { this.booked = booked; }
}
