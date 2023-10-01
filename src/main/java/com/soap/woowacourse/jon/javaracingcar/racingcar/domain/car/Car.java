package com.soap.woowacourse.jon.javaracingcar.racingcar.domain.car;


public class Car implements Comparable<Car>{

    public static final int MIN_RUNNABLE_FUEL = 4;
    private final Name name; //일급 객체 사용
    private Position position;

    public Car(final String name){
        this.name = new Name(name);
        position = new Position(0);
    }

    public void fillInFulAndRun(final int fuel){
        if(isRunnable(fuel)){
            position = position.run();
        }
    }

    // 4이상일 때 자동차 전진
    private boolean isRunnable(final int fuel){
        return fuel >= MIN_RUNNABLE_FUEL;
    }

    public int getPosition(){
        return position.get();
    }

    public boolean isSamePosition(final Car car){
        return position.equals(car.position);
    }

    public String getName(){
        return name.get();
    }

    @Override
    public int compareTo(final Car car) {
        return car.position.get() - position.get();
    }
}
