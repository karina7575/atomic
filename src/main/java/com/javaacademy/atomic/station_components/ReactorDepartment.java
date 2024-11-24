package com.javaacademy.atomic.station_components;

import com.javaacademy.atomic.exceptions.NuclearFuelIsEmptyException;
import com.javaacademy.atomic.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;
/*
реакторный цех
 */
@Component
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

//    private void doubleWorkingCheck() throws ReactorWorkException {
//        if (isWorking == true) {
//            throw new ReactorWorkException("Реактор уже работает");
//        }
//    }

//    private void runsCheck() throws ReactorWorkException {
//        if(runs % finalRundelimeter == 0) {
//            throw new NuclearFuelIsEmptyException();
//        }
//    }

    /*
    остановить реактор
     */
    public void stop() {
        try {
            doubleStopCheck();
        }
        catch (ReactorWorkException e) {
            securityDepartment.addAccident();
            System.out.println(e.getMessage());
        }
        isWorking = false;
    }

    private void doubleStopCheck() {
        if (isWorking == false) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
    }
}
