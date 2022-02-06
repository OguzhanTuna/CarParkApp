package com.examples.carparkapp.dto;

public class ParkStatusDto {
    private long slot;
    private String plate;
    private String color;
    //...

    public ParkStatusDto() {}

    public ParkStatusDto(long slot, String plate, String color)
    {
        this.slot = slot;
        this.plate = plate;
        this.color = color;
    }

    public long getSlot()
    {
        return slot;
    }

    public void setSlot(long slot)
    {
        this.slot = slot;
    }

    public String getPlate()
    {
        return plate;
    }

    public void setPlate(String plate)
    {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
