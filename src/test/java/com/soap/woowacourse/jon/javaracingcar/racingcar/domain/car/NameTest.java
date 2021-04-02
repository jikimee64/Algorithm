package com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "spring"})
    @DisplayName("이름 길이가 0이하 또는 5이상일 때 에러 확인")
    void car_name_exception(String name){
        assertThrows(IllegalStateException.class, () -> {
            new Car(name);
        });
    }

}