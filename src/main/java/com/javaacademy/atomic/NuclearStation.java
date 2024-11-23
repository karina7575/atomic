package com.javaacademy.atomic;

import org.springframework.stereotype.Component;

/*
Атомная станция
 */
@Component
public class NuclearStation {
    private ReactorDepartment reactorDepartment;
    private long amountGeneratedEnergy = 0;

    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }
}
