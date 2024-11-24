package com.javaacademy.atomic.economic_departments;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class EconomicDepartment {
    private Country country;
    private Currency currency;


    public abstract BigDecimal computeYearIncomes(long countElectricity);

}
