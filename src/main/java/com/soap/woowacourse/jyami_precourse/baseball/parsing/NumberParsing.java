package com.soap.woowacourse.jyami_precourse.oneweek.parsing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 숫자로 이루어진 String을 Integer타입의 리스트로 파싱한다 InputView에서 받은 String을
 * QuestionBaseBall로 생성해야 했기 때문에 리스트로 변환해주는 작업이 필요했다.
 * Util의 기능을 가지고 있으므로 static 함수로 만들었다.
 */
public class NumberParsing {

    /**
     * 123(input) -> [1, 2, 3](output)
     */
    public static List<Integer> makeNumbersFromString(String numberString) {
        return numberString.chars() // String의 각 문자별 IntStream 타입의 유니코드 반환
                .map(Character::getNumericValue) // 지정된 문자의 int값 반환
                .boxed() // int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 스트림 생성
                .collect(Collectors.toList());
    }

}
