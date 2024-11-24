package com.javaacademy.atomic.economic_departments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("morocco")
@Getter
@PropertySource("classpath:application-morocco.yaml")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private final Country country;
    private final Currency currency;

    public MoroccoEconomicDepartment(@Value("${morocco.country}") Country country, @Value("${morocco.currency}") Currency currency) {
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


    //    double income = 0.0;

//        if (kilowattHours > 5_000_000_000) {
//        long baseKilowattHours = 5_000_000_000;
//        long increasedKilowattHours = kilowattHours - baseKilowattHours;
//
//        income += baseKilowattHours * BASE_RATE; // доход от первых 5 миллиардов
//        income += increasedKilowattHours * INCREASED_RATE; // доход от остального
//    } else {
//        income += kilowattHours * BASE_RATE; // доход полностью по базовой ставке
//    }
//
//        return income;
}
