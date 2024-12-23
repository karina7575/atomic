package com.javaacademy.atomic.economic_departments;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class FranceEconomicDepartment extends EconomicDepartment {
    private final Country country;
    private final Currency currency;
    private final BigDecimal price;

    public FranceEconomicDepartment(Country country, Currency currency, BigDecimal price) {
        this.country = country;
        this.currency = currency;
        this.price = price;
    }

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long step = 1_000_000_000;
        BigDecimal income = BigDecimal.ZERO;
        int i = 0;
        for (; countElectricity - step >= 0; i++) {
            income = income.add(BigDecimal.valueOf(step).multiply(price)
                    .multiply(BigDecimal.valueOf(Math.pow(0.99, i))));
            countElectricity -= step;
        }
        if (countElectricity > 0) {
            income = income.add(BigDecimal.valueOf(countElectricity).multiply(price)
                    .multiply(BigDecimal.valueOf(Math.pow(0.99, i))));
        }
        return income;
    }
}
