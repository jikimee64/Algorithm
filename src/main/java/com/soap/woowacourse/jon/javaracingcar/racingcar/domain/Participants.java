package com.soap.woowacourse.jon.javaracingcar.racingcar.domain;

import com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Car> cars;

    public Participants(final List<Car> cars){
        /**
         * this.cars = cars X
         * 방어적 복사를 위해서 new ArrayList<>()로 감싸서 외부와의 관계를 끊음
         */
        this.cars = new ArrayList<>(cars);
    }

    public  Participants(final String... names){
        cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars(){
        // 외부에서 값을 변경할 수 없음(add, remove X)
        return Collections.unmodifiableList(cars);
    }

    public String decideWinner(){
        Collections.sort(cars);
        Car winnerCar = cars.get(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .collect(Collectors.toList());
        return new Winner(winners).getWinnerName();
    }
}
