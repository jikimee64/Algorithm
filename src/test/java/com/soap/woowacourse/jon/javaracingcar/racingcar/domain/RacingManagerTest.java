package com.soap.woowacourse.jon.javaracingcar.racingcar.domain;


import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {

    private Participants participants;
    private RacingManager racingManager;

    @BeforeEach
    void init(){
        participants = new Participants("pobi", "sp", "on");
        racingManager = new RacingManager(participants, new Turn(3), () -> Car.MIN_RUNNABLE_FUEL);
    }

    @Test
    void start_one_winner(){
        String expectedLog = "pobi";

        List<Car> cars = participants.getCars();
        cars.get(0).fillInFulAndRun(Car.MIN_RUNNABLE_FUEL);

        RacingResult racingResult = racingManager.start();
        assertThat(racingResult.decideWinner(participants)).isEqualTo(expectedLog);
    }

    @Test
    void start_several_winner() {
        String expectedLog = "pobi, sp, on";
        RacingResult racingResult = racingManager.start();
        assertThat(racingResult.decideWinner(participants)).isEqualTo(expectedLog);
    }


}