package com.examples.carparkapp.entity;


import java.io.Serializable;
import java.util.Objects;

public class Park implements Serializable {
    private long parkId;
    private String status;
    private String plate;
    private String color;
    //...

    //Fluent-Builder pattern
    public static final class Builder{
        private final Park park;
        //...

        public Builder() { park = new Park(); }

        public Park.Builder setParkId(long parkId) { park.parkId = parkId; return this; }
        public Park.Builder setStatus(String status) { park.status = status; return this; }
        public Park.Builder setPlate(String plate) { park.plate = plate; return this; }
        public Park.Builder setColor(String color) { park.color = color; return this; }

        public Park build() { return park; }
    }

    public Park() {}

    public Park(long parkId, String status, String plate, String color)
    {
        this.parkId = parkId;
        this.status = status;
        this.plate = plate;
        this.color = color;
    }

    public static Park.Builder builder() { return new Park.Builder(); }

    public long getParkId() { return parkId; }
    public void setParkId(long parkId) { this.parkId = parkId; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(plate, color, status);
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null || this.getClass() != o.getClass())
            return false;

        if(this == o)
            return true;

        Park park = (Park)o; //Downcasting

        return this.plate.equals(park.plate)
                && this.color.equals(park.color)
                && this.status.equals(park.status);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        return sb
                .append("Slot: ").append(parkId)
                .append(", Plate: ").append(plate)
                .append(", Color: ").append(color)
                .append(", Status: ").append(status)
                .toString();
    }
}
