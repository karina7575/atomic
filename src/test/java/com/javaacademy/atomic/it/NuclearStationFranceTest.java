package com.javaacademy.atomic.it;

import com.javaacademy.atomic.station_components.NuclearStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class NuclearStationFranceTest {
    @Autowired
    private NuclearStation nuclearStationFrance;

    @Test
    public void incrementAccidentSuccess() {
        nuclearStationFrance.incrementAccident(3);
        int expected = 3;
        Assertions.assertEquals(expected, nuclearStationFrance.getAccidentCountAllTime());
    }

    @Test
    public void startYearCountEnergy() {
        nuclearStationFrance.startYear();
        long expected = 3_620_000_000L;
        Assertions.assertEquals(expected, nuclearStationFrance.getAmountGeneratedEnergy());
    }

    @Test
    public void startOneYearSuccess() {
        String expected = "Количество инцидентов за всю работу станции: 10";
        Assertions.assertEquals(expected, nuclearStationFrance.start(3));
    }


}
