package com.soap.woowacourse.jyami_precourse.baseball.generator;

import static com.soap.woowacourse.jyami_precourse.baseball.domain.BaseBallNumber.*;
import static com.soap.woowacourse.jyami_precourse.baseball.gameRunnber.BaseBallGame.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 숫자 생성기의 구현체이며, BaseBallGame이 갖고있는 GAME_NUMBERS_SIZE만큼의 List<Integer>를 반환한다.
 */
public class RandomGameNumbersGenerator implements GameNumbersGenerator {
    private List<Integer> numberList = new ArrayList();

    public RandomGameNumbersGenerator() {
        this.numberList = IntStream.range(MIN_NUM, MAX_NUM)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getGeneratedNumbers() {
        Collections.shuffle(this.numberList);
        return this.numberList.subList(0, GAME_NUMBERS_SIZE);
    }

}

