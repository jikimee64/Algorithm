package com.soap.woowacourse.jyami_precourse.oneweek.io;

import com.soap.woowacourse.jyami_precourse.oneweek.domain.baseBalls.QuestionBaseBalls;

/**
 * 게임시 인자로 받은 값의 출력을 해야할 때의 함수들을 저장한다.
 */
public class OutputView {
    public static void getBaseBallsResult(QuestionBaseBalls.Result result) {

        StringBuilder stringBuilder = new StringBuilder();
        if (result.hasStrike())
            stringBuilder.append(String.format("%d 스트라이크 ", result.getStrike()));
        if (result.hasBall())
            stringBuilder.append(String.format("%d 볼 ", result.getBall()));
        if (!result.hasStrike() && !result.hasBall())
            stringBuilder.append("낫싱");

        System.out.println(stringBuilder);
    }

    public static void endOfOneBaseBallGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
