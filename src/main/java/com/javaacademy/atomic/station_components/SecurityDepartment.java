package com.javaacademy.atomic.station_components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
отдел безопасности
 */
@Component
public class SecurityDepartment {
    private int accidentCountPeriod;
    private NuclearStation nuclearStation;

    public SecurityDepartment(@Lazy NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        accidentCountPeriod++;
    }

    public int getCountAccidents() {
        return this.accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        this.accidentCountPeriod = 0;
    }
}
