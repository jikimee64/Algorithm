package com.soap.woowacourse.jyami_precourse.oneweek.domain.baseBalls;

import com.soap.woowacourse.jyami_precourse.oneweek.domain.OneBaseBall;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

/**
 * 하나의 숫자 야구 그룹이라는 속성을 가지므로 BaseBalls를 상속받는다.
 * 입력받은 List<Integer> 값을 이용하여 숫자 야구 그룹을 생성한다.
 * AnswerBaseBalls를 인자로 넣었을 경우, 매칭 결과를 알려주는 함수를 가지고 있다.
 * 이 때 결과를 알려주는 로직이, QuestionBaseBalls의 멤버변수를 변경하기 때문에
 * 매칭 결과를 알려주는 함수가 Answer가 아니라 Question에 존재한다.
 */
public class QuestionBaseBalls extends BaseBalls {

    private QuestionBaseBalls(List<Integer> numbers) {
        super(numbers);
    }

    public static QuestionBaseBalls ofManual(List<Integer> numbers) {
        return new QuestionBaseBalls(numbers);
    }

    public Result getCalculateResult(AnswerBaseBalls answerBaseBalls) {
        return new Result(answerBaseBalls);
    }

    private boolean strike(OneBaseBall answerOneBaseBall) {
        Optional<OneBaseBall> baseBall = getBaseBalls().stream()
                .filter(question -> question.equalStrike(answerOneBaseBall))
                .findFirst();
        baseBall.ifPresent(qu -> this.getBaseBalls().remove(qu));
//        for (OneBaseBall ball : this.getBaseBalls()) {
//            System.out.println(ball.getBaseBallNumber());
//        }
        return baseBall.isPresent();
    }

    private boolean ball(OneBaseBall answerOneBaseBall) {
        Optional<OneBaseBall> baseBall = getBaseBalls().stream()
                .filter(question -> question.equalBall(answerOneBaseBall))
                .findFirst();
        baseBall.ifPresent(qu -> this.getBaseBalls().remove(qu));
//        for (OneBaseBall ball : this.getBaseBalls()) {
//            System.out.println(ball.getBaseBallNumber());
//        }
        return baseBall.isPresent();
    }

    private Integer calculateStrikeNumber(AnswerBaseBalls answerBaseBalls) {
        long count = answerBaseBalls.getBaseBalls().stream()
                .filter(this::strike)
                .count();
        return (int)count;
    }

    private Integer calculateBallNumber(AnswerBaseBalls answerBaseBalls) {
        long count = answerBaseBalls.getBaseBalls().stream()
                .filter(this::ball)
                .count();
        return (int)count;
    }

    @Getter
    public class Result {
        private Integer strike;
        private Integer ball;

        Result(AnswerBaseBalls answerBaseBalls) {
            this.strike = calculateStrikeNumber(answerBaseBalls);
            this.ball = calculateBallNumber(answerBaseBalls);
        }

        public boolean hasStrike() {
            return this.strike != 0;
        }

        public boolean hasBall() {
            return this.ball != 0;
        }
    }

}
