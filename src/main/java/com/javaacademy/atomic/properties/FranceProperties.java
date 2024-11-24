package com.javaacademy.atomic.properties;

import com.javaacademy.atomic.economic_departments.Country;
import com.javaacademy.atomic.economic_departments.Currency;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@ConfigurationProperties(prefix = "france")
@Profile("france")
@Getter
public class FranceProperties {
    private Country country;
    private Currency currency;
}
