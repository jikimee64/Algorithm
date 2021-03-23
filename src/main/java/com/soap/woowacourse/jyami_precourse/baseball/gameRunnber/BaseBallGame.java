package com.soap.woowacourse.jyami_precourse.oneweek.gameRunnber;

import com.soap.woowacourse.jyami_precourse.oneweek.domain.baseBalls.AnswerBaseBalls;
import com.soap.woowacourse.jyami_precourse.oneweek.domain.baseBalls.QuestionBaseBalls;
import com.soap.woowacourse.jyami_precourse.oneweek.generator.GameNumbersGenerator;
import com.soap.woowacourse.jyami_precourse.oneweek.io.InputView;
import com.soap.woowacourse.jyami_precourse.oneweek.io.OutputView;
import com.soap.woowacourse.jyami_precourse.oneweek.parsing.NumberParsing;

import java.util.List;

/**
 * 하나의 숫자야구게임을 실행 할 수 있다.
 * 하나의 숫자야구게임에는 하나의 숫자 야구 그룹 정답(AnswerBaseBalls)을 가지고 있다.
 */
public class BaseBallGame {
    public static final int GAME_NUMBERS_SIZE = 3;

    private AnswerBaseBalls collectBaseBalls;

    BaseBallGame(GameNumbersGenerator gameNumbersGenerator) {
        this.collectBaseBalls = AnswerBaseBalls.ofGenerator(gameNumbersGenerator);
    }

    void executeUserInput(InputView inputView) {
        QuestionBaseBalls.Result result;
        do {
            result = getQuestionBaseBall(inputView).getCalculateResult(this.collectBaseBalls);
            OutputView.getBaseBallsResult(result);
        } while (wrongAnswer(result));
        OutputView.endOfOneBaseBallGame();

    }

    private boolean wrongAnswer(QuestionBaseBalls.Result result) {
        return result.getStrike() != GAME_NUMBERS_SIZE;
    }

    private QuestionBaseBalls getQuestionBaseBall(InputView inputView) {
        List<Integer> integers = NumberParsing.makeNumbersFromString(inputView.getNumbers());
        return QuestionBaseBalls.ofManual(integers);
    }

}

