package com.examples.carparkapp.service;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.LinkedList;
import java.util.List;

//Test işlemi sadece örnek olması açısından Service Layer da includePark metoduna ilişkin
//test kodu yazımı amaçlanmıştır.
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_carParkService_includePark {
    private static final List<ParkStatusDto> dataList;
    private List<ParkStatusDto> actualList;
    private List<ParkStatusDto> expectedList;
    @Autowired //field injection. Fakat field injection da veri elemanını(field) final tanımlayamayız.
    private ICarParkService carParkService;
    //...

    static {
        dataList = new LinkedList<>(){{
            this.add(new ParkStatusDto(1, "35-ABC-54", "White"));
            this.add(new ParkStatusDto(2, "22-FUT-005", "Black"));
            this.add(new ParkStatusDto(3, "34-AGF-1016", "Red"));
            this.add(new ParkStatusDto(4, "55-O-07", "Purple"));
            this.add(new ParkStatusDto(5, "31-ATY-113", "Green"));
            this.add(new ParkStatusDto(6, "06-MN-509", "Yellow"));
            this.add(new ParkStatusDto(7, "11-E-086", "Blue"));
            this.add(new ParkStatusDto(8, "07-PUK-5712", "Grey"));
            this.add(new ParkStatusDto(9, "21-UT-83", "Brown"));
            this.add(new ParkStatusDto(10, "08-RR-44", "Orange"));
        }};
    }

    @Before
    public void setUp()
    {
        actualList = dataList;
    }

    @Test
    public void test_carParkService_includePark()
    {
        dataList.stream()
                .forEach(dtoData -> carParkService.includePark(new IncludeParkDto(dtoData.getSlot(), dtoData.getPlate(), dtoData.getColor())));

        expectedList = carParkService.status();

        Assert.assertEquals(expectedList, actualList);
    }
}