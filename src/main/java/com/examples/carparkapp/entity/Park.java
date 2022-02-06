package com.examples.carparkapp.entity;

import javax.persistence.*;


@Entity
@Table(name = "t_park", schema = "park")
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "park_id")
    private long parkId;

    @Column(name = "status")
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
}
