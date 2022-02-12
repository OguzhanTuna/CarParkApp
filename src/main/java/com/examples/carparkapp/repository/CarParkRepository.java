package com.examples.carparkapp.repository;

import com.examples.carparkapp.entity.Park;
import com.examples.carparkapp.repository.abstraction.ICarParkRepository;
import com.examples.exceptionlib.exceptionlib.util.FunctionalExceptionUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.LongStream;

@Repository
public class CarParkRepository implements ICarParkRepository {
    private static final Map<Long, Park> parkMap;
    //...

    //Static initializer.
    static{
        parkMap = new HashMap<>();
        LongStream.rangeClosed(1, 10)
                .forEach(key -> parkMap.put(key, Park.builder().setParkId(key).setStatus("EMPTY").build()));
        parkMap.values().forEach(System.out::println);
    }

    private long getAvailableParkIdCallback()
    {
        return LongStream.rangeClosed(1, 10)
                .filter(parkId -> parkMap.get(parkId).getStatus().equals("EMPTY"))
                .sorted()
                .findFirst()
                .orElse(0); //Hiç boş park alanı mevcut değilse slot 'O(Sıfır)' dönsün.
    }

    private void updateAvailableSlotForParkCallback(long availableSlot, String plate, String color)
    {
        Park park = parkMap.get(availableSlot);

        park.setPlate(plate);
        park.setColor(color);
        park.setStatus("FILL");
    }

    private void updateSlotForLeaveByParkIdCallback(long parkId)
    {
        Park park = parkMap.get(parkId);

        park.setPlate(null);
        park.setColor(null);
        park.setStatus("EMPTY");
    }

    //Default constructor
    public CarParkRepository() {}

    @Override
    public synchronized Iterable<Park> findAll()
    {
        return FunctionalExceptionUtil.
                doWorkForRepositoryException(parkMap::values,
                        "Repository Exception for 'FIND ALL' method");
    }

    @Override //@Override is marker annotation.
    public synchronized long getAvailableParkId()
    {
        return FunctionalExceptionUtil
                .doWorkForRepositoryException(this::getAvailableParkIdCallback,
                        "Repository Exception for 'GET AVAILABLE PARK ID' method");
    }

    @Override
    public synchronized void updateAvailableSlotForPark(long availableSlot,
                                                        String plate,
                                                        String color)
    {
        FunctionalExceptionUtil
                .doWorkForRepositoryException(() -> updateAvailableSlotForParkCallback(availableSlot, plate, color),
                        "Repository Exception for 'UPDATE AVAILABLE SLOT FOR PARK' method");
    }

    @Override
    public synchronized void updateSlotForLeaveByParkId(long parkId)
    {
        FunctionalExceptionUtil
                .doWorkForRepositoryException(() -> updateSlotForLeaveByParkIdCallback(parkId),
                        "Repository Exception for 'UPDATE SLOT FOR LEAVE BY PARK ID' method");
    }

    //////////////////////////////
    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Park entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<Park> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Park> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Park> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E extends Park> E save(Park entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E extends Park> Iterable<E> saveAll(Iterable<E> entities) {
        throw new UnsupportedOperationException();
    }
}
