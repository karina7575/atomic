package com.javaacademy.atomic.unit_tests;

import com.javaacademy.atomic.exceptions.ReactorWorkException;
import com.javaacademy.atomic.station_components.NuclearStation;
import com.javaacademy.atomic.station_components.ReactorDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("morocco")
public class NuclearStationMoroccoUnitTest {
    @Autowired
    private NuclearStation nuclearStation;
    @SpyBean
    private ReactorDepartment reactorDepartment;

    @Test
    public void startYearSuccessMorocco() {
        Mockito.when(reactorDepartment.run()).thenThrow(ReactorWorkException.class);
        Assertions.assertDoesNotThrow(() -> nuclearStation.startYear());
    }
}
