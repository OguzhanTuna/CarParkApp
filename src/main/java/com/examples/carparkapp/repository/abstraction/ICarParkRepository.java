package com.examples.carparkapp.repository.abstraction;

import com.examples.carparkapp.entity.Park;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ICarParkRepository extends CrudRepository<Park, Long> {
    //...

    @Query("select coalesce(min(p.parkId), 0) from Park p where p.status = 'EMPTY'")
    long getAvailableParkId();

    @Query("update Park p set p.plate = :plate, p.color = :color, p.status = 'FILL' where p.parkId = :parkId")
    @Modifying //Eğer manipulation işlemi yapıyorsak(update, insert, delete) @Modifiying annotation kullanmamız
    //gerekir.
    void updateAvailableSlotForPark(@Param("parkId") Long parkId,
                             @Param("plate") String plate,
                             @Param("color") String color);

    @Query("update Park p set p.plate = null, p.color = null, p.status = 'EMPTY' where p.parkId = ?1")
    @Modifying
    void updateAvailableSlotForLeave(@Param("parkId") Long parkId);
}
