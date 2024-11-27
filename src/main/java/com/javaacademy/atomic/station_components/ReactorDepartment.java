package com.javaacademy.atomic.station_components;

import com.javaacademy.atomic.exceptions.NuclearFuelIsEmptyException;
import com.javaacademy.atomic.exceptions.ReactorWorkException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
/*
реакторный цех
 */
@Component
@Setter
@Getter
public class ReactorDepartment {
    private boolean isWorking;
    private int runs = 0;
    private final int finalRundelimeter = 100;
    private SecurityDepartment securityDepartment;

    public ReactorDepartment(SecurityDepartment securityDepartment) {
        this.securityDepartment = securityDepartment;
    }

    /*
        запустить реактор
         */
    public long run() throws ReactorWorkException, NuclearFuelIsEmptyException{
        if (isWorking == true) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает");
        }
        if(runs % finalRundelimeter == 0 && runs > 0) {
            runs++;
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException();
        }
        runs++;
        isWorking = true;
        return 10_000_000;
    }

    /*
    остановить реактор
     */
    public void stop() {
        if (!isWorking) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        securityDepartment.addAccident();
        isWorking = false;
    }
}
