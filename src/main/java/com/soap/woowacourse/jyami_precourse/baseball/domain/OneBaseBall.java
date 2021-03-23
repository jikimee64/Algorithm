package com.soap.woowacourse.jyami_precourse.oneweek.domain;

import com.soap.woowacourse.jyami_precourse.oneweek.domain.baseBalls.BaseBalls;
import lombok.Getter;

/**
 * 하나의 야구볼은 number와 position으로 이루어져 있다.
 * 이때 position을 멤버변수로 설정한 이유는, OneBaseBall이 모여서 List화 되었는데 한 개의 값이 사라지게 되면,
 * 인덱스로 position을 판단하는게 불명확하다고 판단했기 때문이다.
 */
@Getter
public class OneBaseBall {
    private BaseBallNumber baseBallNumber;
    private Integer baseBallPosition;

    private OneBaseBall(BaseBallNumber baseBallNumber, Integer baseBallPosition) {
        this.baseBallNumber = baseBallNumber;
        this.baseBallPosition = baseBallPosition;
    }

    public static OneBaseBall ofInteger(Integer baseBallNumber, Integer baseBallPosition) {
        return new OneBaseBall(BaseBallNumber.of(baseBallNumber), baseBallPosition);
    }

    public boolean equalStrike(OneBaseBall otherBaseBall) {
        return this.baseBallNumber.equals(otherBaseBall.baseBallNumber)
                && this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
    }

    public boolean equalBall(OneBaseBall otherBaseBall) {
        return this.baseBallNumber.equals(otherBaseBall.baseBallNumber)
                && !this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
    }
}
