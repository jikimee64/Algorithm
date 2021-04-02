package com.soap.woowacourse.jon.javaracingcar.racingcar.domain;


import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantsTest  {

    @Test
    void create(){
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("pobi"), new Car("sp")));
        // 정상
        Participants participants = new Participants(cars);
        assertThat(participants.getCars()).extracting("name").contains("pobi", "sp");

        // 생성자 단계에서 방어적 복사 필요
        cars.remove(1);
        assertThat(participants.getCars()).extracting("name").contains("pobi", "sp");

        // get 단계에서 uinmodifiableList 처리 필요
        List<Car> getCars = participants.getCars();
        assertThrows(UnsupportedOperationException.class, () -> {
           getCars.remove(1);
        });

        // 또는 new ArrayList()를 통한 방어적 복사해야 함.
        assertThat(participants.getCars()).extracting("name").contains("pobi", "sp");


    }

}