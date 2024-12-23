package com.javaacademy.atomic.economic_departments;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private final Country country;
    private final Currency currency;
    private final BigDecimal price;
    private final BigDecimal biggerPrice;

    public MoroccoEconomicDepartment(Country country, Currency currency, BigDecimal price, BigDecimal biggerPrice) {
        this.country = country;
        this.currency = currency;
        this.price = price;
        this.biggerPrice = biggerPrice;
    }

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long firstStep = 5_000_000_000L;
        long step = 1_000_000_000;
        BigDecimal income = BigDecimal.ZERO;
        if (countElectricity - firstStep <= 0) {
            income = BigDecimal.valueOf(countElectricity).multiply(price);
        } else {
            income = BigDecimal.valueOf(firstStep).multiply(price);
            countElectricity -= firstStep;
            while (countElectricity - step > 0) {
                income = income.add(BigDecimal.valueOf(step).multiply(biggerPrice));
                countElectricity -= step;
            }
            income = income.add(BigDecimal.valueOf(countElectricity).multiply(biggerPrice));
        }
        return income;
    }
}
