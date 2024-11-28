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
@ActiveProfiles("france")
public class NuclearStationFranceUnitTest {
    @Autowired
    private NuclearStation nuclearStationFrance;
    @SpyBean
    private ReactorDepartment reactorDepartmentFrance;

    @Test
    public void startYearSuccess() {
        Mockito.when(reactorDepartmentFrance.run()).thenThrow(ReactorWorkException.class);
        Assertions.assertDoesNotThrow(() -> nuclearStationFrance.startYear());
    }

}
