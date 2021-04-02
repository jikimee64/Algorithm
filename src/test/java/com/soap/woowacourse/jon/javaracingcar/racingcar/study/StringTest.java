package com.soap.woowacourse.jon.javaracingcar.racingcar.study;

import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    public void split(){
        String[] values = "1,2".split(",");
        //containsExactly : 순서까지 고려해서 실제 그룹이 주어진 값들을 포함하고 있는지를 테스트
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("String - substring 테스트")
    void substring(){
        //given
        String values ="(1,2)";

        //when
        String substring = values.substring(1, values.length() - 1);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String - charAt 테스트")
    void charAt(){
        //given
        String value = "abc";

        //when
        char charAt = value.charAt(0);

        //then
        assertThat(charAt).isEqualTo('a');

        assertThatThrownBy(() -> value.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
