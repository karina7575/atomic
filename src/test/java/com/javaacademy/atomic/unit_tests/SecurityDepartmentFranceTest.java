package com.javaacademy.atomic.unit_tests;

import com.javaacademy.atomic.station_components.SecurityDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
public class SecurityDepartmentFranceTest {

    @Autowired
    private SecurityDepartment securityDepartment;

    @Test
    public void resetSuccess() {
        securityDepartment.addAccident();
        securityDepartment.addAccident();
        securityDepartment.reset();
        Assertions.assertEquals(0, securityDepartment.getCountAccidents());
    }
}
