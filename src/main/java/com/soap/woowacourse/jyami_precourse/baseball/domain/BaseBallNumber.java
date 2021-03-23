package com.soap.woowacourse.jyami_precourse.oneweek.domain;

import lombok.Getter;

import java.util.Objects;

/**
 * 야구볼의 숫자는 무조껀 1~9 사이의 수이어야 하기 때문에,
 * 유저로부터 들어온 Input에 대한 validation을 진행한다.
 */
@Getter
public class BaseBallNumber {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    private Integer value;

    private BaseBallNumber(Integer value) {
        this.value = value;
    }

    public static BaseBallNumber of(Integer value) {
        validate(value);
        return new BaseBallNumber(value);
    }

    private static void validate(Integer number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        BaseBallNumber otherBaseBallNumber = (BaseBallNumber)object;
        return this.value.equals(otherBaseBallNumber.value);
    }

}
