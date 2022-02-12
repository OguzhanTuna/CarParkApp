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

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof ParkStatusDto))
            return false;

        if(this == o)
            return true;

        ParkStatusDto dto = (ParkStatusDto) o; //Downcasting.

        return this.slot == dto.slot
                && this.plate.equals(dto.plate)
                && this.color.equals(dto.color);
    }

    @Override
    public String toString()
    {
        return String.format("Slot: %d, Plate: %s, Color: %s\n", slot, plate, color);
    }
}
