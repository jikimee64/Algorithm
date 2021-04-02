package com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        this.car = new Car("Pobi");
    }

    @ParameterizedTest
    @CsvSource(value = {Car.MIN_RUNNABLE_FUEL + ":1", Car.MIN_RUNNABLE_FUEL - 1 + ":0"}, delimiter = ':')
    @DisplayName("최소 달릴 수 있는 연료를 차에 주입했을 때 1만큼 전진을 하였는 지 확인")
    void run(int fuel, int expected){
        car.fillInFulAndRun(fuel);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    void is_same_position(){
        Car expected = new Car("jason");
        assertThat(car.getPosition()).isEqualTo(expected.getPosition());
        assertThat(car.isSamePosition(expected)).isTrue();
    }




}