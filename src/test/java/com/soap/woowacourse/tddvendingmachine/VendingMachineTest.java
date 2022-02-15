package com.soap.woowacourse.tddvendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Red(질문) -> Green(응답) -> Refactor(정제)
 */
class VendingMachineTest {

    @Test
    void 자판기_생성() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThat(vendingMachine).isNotNull();
    }

    @ParameterizedTest(name = "자판기에 {0}원을 넣으면{0}원이 들어있음을 알수있다")
    @ValueSource(ints = {500, 1000})
    void 자판기에_N원을_넣으면_N원이_들어있음을_알수있다(int changes) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.put(changes);
        assertThat(vendingMachine.getChanges()).isEqualTo(changes);
    }

    @Test
    @Disabled
    void _1000원이_들어있는_자판기에_500원을_넣으면_1500원이_들어있음을_알수있다() {
        VendingMachine vendingMachine = new VendingMachine(1000);
        vendingMachine.put(500);
        assertThat(vendingMachine.getChanges()).isEqualTo(1500);
    }

    @Test
    void _500원이_들어있는_자판기에_500원을_차감하면_자판기의_남은금액은_0원이다(){
        VendingMachine vendingMachine = new VendingMachine(500);
        vendingMachine.withdraw(500);
        assertThat(vendingMachine.getChanges()).isEqualTo(0);
    }

    @Test
    void _500원이_들어있는_자판기에_1000원을_차감할수없다(){
        VendingMachine vendingMachine = new VendingMachine(500);
        vendingMachine.withdraw(1000);

        assertThat(vendingMachine.getChanges()).isEqualTo(0);

        //1
        assertThatThrownBy(() -> { throw new Exception("boom!"); })
                .isInstanceOf(Exception.class) .hasMessageContaining("boom");

        //2

    }

}