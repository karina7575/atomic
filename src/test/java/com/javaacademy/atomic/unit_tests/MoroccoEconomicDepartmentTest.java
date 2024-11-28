package com.javaacademy.atomic.unit_tests;

import com.javaacademy.atomic.economic_departments.MoroccoEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("morocco")
public class MoroccoEconomicDepartmentTest {
    @Autowired
    private MoroccoEconomicDepartment moroccoDepartment;

    @Test
    public void computeYearIncomesSuccessMorocco() {
        BigDecimal expected = BigDecimal.valueOf(37_000_000_000L);
        BigDecimal result = moroccoDepartment.computeYearIncomes(7_000_000_000L);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void computeYearIncomesSuccess1Morocco() {
        BigDecimal expected = BigDecimal.valueOf(20_000_000_000L);
        BigDecimal result = moroccoDepartment.computeYearIncomes(4_000_000_000L);
        Assertions.assertEquals(expected, result);
    }
}
