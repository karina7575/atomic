package com.javaacademy.atomic.unit_tests;

import com.javaacademy.atomic.economic_departments.FranceEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("france")
public class FranceEconomicDepartmentTest {

    @Autowired
    private FranceEconomicDepartment franceDepartment;

    @Test
    public void computeYearIncomesSuccessFrance() {
        BigDecimal expected = BigDecimal.valueOf(500_000_000L);
        BigDecimal result = franceDepartment.computeYearIncomes(1_000_000_000L);
        Assertions.assertTrue(expected.compareTo(result) == 0);
    }

    @Test
    public void computeYearIncomesSuccess1France() {
        BigDecimal expected = BigDecimal.valueOf(1_970_199_500L);
        BigDecimal result = franceDepartment.computeYearIncomes(4_000_000_000L);
        Assertions.assertTrue(expected.compareTo(result) == 0);
    }

    @Test
    public void computeYearIncomesSuccess2France() {
        BigDecimal expected = BigDecimal.valueOf(747_500_000L);
        BigDecimal result = franceDepartment.computeYearIncomes(1_500_000_000L);
        Assertions.assertTrue(expected.compareTo(result) == 0);
    }
}
