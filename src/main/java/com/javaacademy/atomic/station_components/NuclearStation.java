package com.javaacademy.atomic.station_components;

import com.javaacademy.atomic.economic_departments.EconomicDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
Атомная станция
 */
@Component
@Slf4j
public class NuclearStation {
    private ReactorDepartment reactorDepartment;
    private SecurityDepartment securityDepartment;
    private long amountGeneratedEnergy = 0;
    private int accidentCountAllTime = 0;
    private EconomicDepartment economicDepartment;

    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment, EconomicDepartment economicDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
        this.economicDepartment = economicDepartment;
    }

    /*
        Запуск годового цикла производства электричества
         */
    public void startYear() {
        long yearEnergy = 0;
        log.info("Атомная станция начала работу");
        for (int i = 0; i < 365; i++) {
            try {
                yearEnergy += reactorDepartment.run();
                reactorDepartment.stop();
            }
            catch (RuntimeException e) {
                log.info("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов", yearEnergy);
        amountGeneratedEnergy += yearEnergy;
        log.info("Количество инцидентов за год: {}" + securityDepartment.getCountAccidents());
        securityDepartment.reset();
        log.info("Доход за год составил {}", economicDepartment.computeYearIncomes(yearEnergy), economicDepartment.getCurrency());
    }

    public void start(int year) {
        log.info("Действие происходит в стране: {}", economicDepartment.getCountry());
        for (int i = 0; i < year; i++) {
            startYear();
        }
        log.info("Количество инцидентов за всю работу станции: {}", accidentCountAllTime);
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }
}
