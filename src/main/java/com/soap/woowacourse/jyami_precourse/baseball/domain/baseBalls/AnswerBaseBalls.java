package com.soap.woowacourse.jyami_precourse.baseball.domain.baseBalls;

import com.soap.woowacourse.jyami_precourse.baseball.generator.GameNumbersGenerator;

import java.util.List;

/**
 * 하나의 숫자 야구 그룹이라는 속성을 가지므로 BaseBalls를 상속받는다.
 * 이 숫자 야구 그룹은 숫자 생성기 (GameNumberGenerator)로 생성된다.
 */
public class AnswerBaseBalls extends BaseBalls {

    private AnswerBaseBalls(List<Integer> numbers) {
        super(numbers);
    }

    public static AnswerBaseBalls ofGenerator(GameNumbersGenerator generator) {
        return new AnswerBaseBalls(generator.getGeneratedNumbers());
    }
}
