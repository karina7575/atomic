package com.javaacademy.atomic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
отдел безопасности
 */
@Component
public class SecutiryDepartment {
    private int accidentCountPeriod;
    private NuclearStation nuclearStation;

    public SecutiryDepartment(@Lazy NuclearStation nuclearStation) {
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
