package com.soap.woowacourse.jon.javaracingcar.racingcar.view;

import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.Participants;
import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.Turn;
import com.soap.woowacourse.jon.javaracingcar.racingcar.exception.RacingCarErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TURN_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String NAME_DELIMITER = ",";

    public static Participants getNames(){
        try{
            OutputView.printMessage(GET_CAR_NAME_MESSAGE);
            String names = scanner.nextLine().trim();
            return new Participants(names.split(NAME_DELIMITER));
        }catch(IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return getNames(); // 재입력 받기
        }
    }

    public static Turn getTurn() {
        try {
            OutputView.printMessage(GET_TURN_MESSAGE);
            int turn = Integer.parseInt(scanner.nextLine().trim());
            return new Turn(turn);
        } catch (NumberFormatException | IllegalStateException e) {
            OutputView.printMessage(RacingCarErrorMessage.TURN.getMessage());
            return getTurn(); // 재입력 받기
        }
    }

}
