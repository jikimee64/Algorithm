package com.soap.woowacourse.jon.javaracingcar.racingcar.domain;

import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingResultTest {

    private static final String ENTER = System.lineSeparator();
    private Participants participants;
    private RacingResult racingResult;

    @BeforeEach
    void init(){
        participants = new Participants("pobi", "sp");
        racingResult = new RacingResult();
    }

    @Test
    void appendLog(){
        String expectedLog = "pobi : -" + ENTER + "sp : -" + ENTER + ENTER;
        participants.getCars().forEach(car -> {
            car.fillInFulAndRun(Car.MIN_RUNNABLE_FUEL);
        });
        racingResult.appendLog(participants);
        assertThat(racingResult.getLog()).isEqualTo(expectedLog);
    }

    @Test
    void getWinner_one_winner(){
        String expectedLog = "pobi";
        List<Car> cars = participants.getCars();
        cars.get(0).fillInFulAndRun(Car.MIN_RUNNABLE_FUEL);
        assertThat(racingResult.decideWinner(participants)).isEqualTo(expectedLog);
    }

    @Test
    void getWinner_several_winner(){
        String expectedLog = "pobi, sp";
        assertThat(racingResult.decideWinner(participants)).isEqualTo(expectedLog);
    }

}