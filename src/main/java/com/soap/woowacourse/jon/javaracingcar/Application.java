package com.soap.woowacourse.jon.javaracingcar;

import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.*;
import com.soap.woowacourse.jon.javaracingcar.racingcar.view.InputView;
import com.soap.woowacourse.jon.javaracingcar.racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Participants participants = InputView.getNames();
        Turn turn = InputView.getTurn();

        RacingManager racingManager = new RacingManager(participants, turn, new RandomSupplier());

        RacingResult racingResult = racingManager.start();
        OutputView.printProgressResult(racingResult.getLog());
        OutputView.printWinner(racingResult.decideWinner(participants));

    }
}
