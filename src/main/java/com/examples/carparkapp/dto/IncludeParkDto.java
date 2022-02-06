package com.examples.carparkapp.dto;

public class IncludeParkDto {
    private long slot;
    private String plate;
    private String color;
    //...

    public IncludeParkDto(long slot, String plate, String color)
    {
        this.plate = plate;
        this.color = color;
    }

    public long getSlot() { return slot; }

    public void setSlot(long slot) { this.slot = slot; }

    public String getPlate()
    {
        return plate;
    }

    public void setPlate(String plate)
    {
        this.plate = plate;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        return sb
                .append("Slot :").append(slot)
                .append(", Plate: ").append(plate)
                .append(", Color: ").append(color)
                .toString();
    }
}
