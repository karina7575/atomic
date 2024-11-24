package com.javaacademy.atomic.economic_departments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("france")
@Getter
@PropertySource("classpath:application-france.yaml")
public class FranceEconomicDepartment extends EconomicDepartment{
    private final Country country;
    private final Currency currency;

    public FranceEconomicDepartment(@Value("${france.country}") Country country, @Value("${france.currency}")Currency currency) {
        this.country = country;
        this.currency = currency;
    }

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long step = 1_000_000_000;
        BigDecimal income = BigDecimal.ZERO;
        double i = 0;
        for(; countElectricity % step > 0; countElectricity -= step, i++) {
            income = income.add(BigDecimal.valueOf(step).multiply(BigDecimal.valueOf(0.5)).multiply(BigDecimal.valueOf(Math.pow(0.99, i)))) ;
        }
        income = income.add(BigDecimal.valueOf(countElectricity).multiply(BigDecimal.valueOf(0.5)).multiply(BigDecimal.valueOf(Math.pow(0.99, i + 1))));
        return income;
    }
}
