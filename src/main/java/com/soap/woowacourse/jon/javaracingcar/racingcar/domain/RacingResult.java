package com.soap.woowacourse.jon.javaracingcar.racingcar.domain;

public class RacingResult {

    // OS마다 행 구분자가 다르므로 자바에서 제공하는 메소드 사용
    private static final String ENTER = System.lineSeparator();

    private static final String LOG_FORM = "%s : %s" + ENTER;
    private static final String DISTANCE_SIGN = "-";
    private final StringBuilder log = new StringBuilder();

    public void appendLog(final Participants participants) {
        participants.getCars()
                .forEach(car -> log.append(
                        String.format(LOG_FORM, car.getName(), convertToDistanceSign(car.getPosition()))
                ));
        log.append(ENTER);
    }

    private String convertToDistanceSign(final int position) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sign.append(DISTANCE_SIGN);
        }
        return sign.toString();
    }

    public String getLog() {
        return log.toString();
    }

    public String decideWinner(Participants participants){
        return participants.decideWinner();
    }
}
