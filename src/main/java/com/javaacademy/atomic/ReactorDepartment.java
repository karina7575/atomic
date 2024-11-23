package com.javaacademy.atomic;

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

    /*
    запустить реактор
     */
    public long run() {
        try {
            doubleWorkingCheck();
        }
        catch (ReactorWorkException e) {
            System.out.println(e.getMessage());
        }

        try {
            runsCheck();
        }
        catch (NuclearFuelIsEmptyException e){
            runs++;
        }
        isWorking = true;
        runs++;
        return 10_000_000;
    }

    private void doubleWorkingCheck() throws ReactorWorkException {
        if (isWorking == true) {
            throw new ReactorWorkException("Реактор уже работает");
        }
    }

    private void runsCheck() throws ReactorWorkException {
        if(runs % finalRundelimeter == 0) {
            throw new NuclearFuelIsEmptyException();
        }
    }

    /*
    остановить реактор
     */
    public void stop() {
        try {
            doubleStopCheck();
        }
        catch (ReactorWorkException e) {
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
