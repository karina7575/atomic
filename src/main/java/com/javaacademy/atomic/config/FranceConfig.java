package com.javaacademy.atomic.config;

import com.javaacademy.atomic.economic_departments.Country;
import com.javaacademy.atomic.economic_departments.Currency;
import com.javaacademy.atomic.economic_departments.FranceEconomicDepartment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@Configuration
@Profile("france")
@PropertySource("classpath:application-france.yaml")
public class FranceConfig {
    @Value("${france.country}")
    private Country country;
    @Value("${france.currency}")
    private Currency currency;
    @Value("${france.price}")
    private BigDecimal price;

    @Bean
    public FranceEconomicDepartment franceEconomicDepartment() {
        return new FranceEconomicDepartment(country, currency, price);
    }
}
