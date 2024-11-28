package com.javaacademy.atomic.unit_tests;

import com.javaacademy.atomic.exceptions.NuclearFuelIsEmptyException;
import com.javaacademy.atomic.exceptions.ReactorWorkException;
import com.javaacademy.atomic.station_components.ReactorDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("morocco")
public class ReactorDepartmentMoroccoTest {
    @Autowired
    private ReactorDepartment reactorDepartment;


    /*
    проверка метода run, что выбрасывает исключение ReactorWorkException
     */
    @Test
    public void runFailure() {
        reactorDepartment.setWorking(true);
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.run());
    }

    /*
    успешая проверка метода run, меняет состояние реактора и возвращает 10 миллионов киловатт/часов
     */
    @Test
    public void runSuccess() {
        long expected = 10_000_000;
        Assertions.assertEquals(expected, reactorDepartment.run());
    }


    /*
    проверка метода run, что каждый 100 запуск - выдает ошибку NuclearFuelIsEmptyException
     */
    @Test
    public void run100Failure() {
        reactorDepartment.setRuns(100);
        Assertions.assertThrows(NuclearFuelIsEmptyException.class, () -> reactorDepartment.run());
    }

     /*
    проверка метода stop, что выбрасывает ошибку ReactorWorkException если реактор уже включен
     */
     @Test
     public void stopFailure() {
         reactorDepartment.setWorking(false);
         Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.stop());
     }

    /*
    проверка метода stop, что меняет состояние реактора
     */
    @Test
    public void stopSuccess() {
        reactorDepartment.setWorking(true);
        reactorDepartment.stop();
        Assertions.assertFalse(reactorDepartment.isWorking());
    }
}
