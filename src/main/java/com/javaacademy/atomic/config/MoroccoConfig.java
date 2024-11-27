package com.javaacademy.atomic.config;

import com.javaacademy.atomic.economic_departments.Country;
import com.javaacademy.atomic.economic_departments.Currency;
import com.javaacademy.atomic.economic_departments.FranceEconomicDepartment;
import com.javaacademy.atomic.economic_departments.MoroccoEconomicDepartment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@Configuration
@Profile("morocco")
@PropertySource("classpath:application-morocco.yaml")
public class MoroccoConfig {
    @Value("${morocco.country}")
    private Country country;
    @Value("${morocco.currency}")
    private Currency currency;
    @Value("${morocco.price}")
    private BigDecimal price;
    @Value("${morocco.bigger-price}")
    private BigDecimal biggerPrice;


    @Bean
    public MoroccoEconomicDepartment moroccoEconomicDepartment() {
        return new MoroccoEconomicDepartment(country, currency, price, biggerPrice);
    }
}
