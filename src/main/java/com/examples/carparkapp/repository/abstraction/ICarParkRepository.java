package com.examples.carparkapp.repository.abstraction;

import com.example.crudlibrary.ICrudRepository;
import com.examples.carparkapp.entity.Park;

//Customize ICrudRepository<T, ID> interface
public interface ICarParkRepository extends ICrudRepository<Park, Long> {
    //...

    long getAvailableParkId();

    void updateAvailableSlotForPark(long availableSlot, String plate, String color);

    void updateSlotForLeaveByParkId(long parkId);
}
