package com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int get() {
        return position;
    }

    /**
     * position++ X / position이 final이기 때문에 새로운 객체 할당
     * 아래와 같이 함으로서, 불변 객체 성립
     * 해당 객체의 신뢰성이 상승하고, 방어 복사라는 것을 사용할 필요가 없고,
     * 멀티스레드 환경에서 동기화 작업이 필요없다.
     * 또한, 컴퓨터의 성능이 좋아져서 불변 객체로 인한 메모리 낭비는 크게 단점이 되지 않는다
     */
    public Position run(){
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
