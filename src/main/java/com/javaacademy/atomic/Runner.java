package com.javaacademy.atomic;

import com.javaacademy.atomic.station_components.NuclearStation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
        NuclearStation station = context.getBean(NuclearStation.class);
        station.start(3);
    }

}
