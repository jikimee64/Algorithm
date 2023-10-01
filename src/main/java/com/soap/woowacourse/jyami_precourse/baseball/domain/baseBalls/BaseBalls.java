package com.soap.woowacourse.jyami_precourse.baseball.domain.baseBalls;

import com.soap.woowacourse.jyami_precourse.baseball.domain.OneBaseBall;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 하나의 숫자 야구 그룹(BaseBalls)은 여러 개의 야구볼(OneBaseBalls)로 이루어져 있다.
 * [{"number":3, "position": 1},
 *  {"number":7, "position": 2},
 *  {"number":2, "position": 3}]
 */
@Getter
public class BaseBalls {
    private List<OneBaseBall> baseBalls = new ArrayList<>();

    BaseBalls(List<Integer> numbers) {
        for (int position = 0; position < numbers.size(); position++) {
            Integer number = numbers.get(position);
            this.baseBalls.add(OneBaseBall.ofInteger(number, position));
        }
    }

    int getSize() {
        return baseBalls.size();
    }

    OneBaseBall findBaseBallByPosition(Integer position) {
        return this.baseBalls.stream()
                .filter(ball -> ball.getBaseBallPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 position 입니다."));
    }

}
