package com.soap;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Person p = new Person();
        List<Integer> list = List.of(1,2);

        p.setTest(list);
    }

}

class Person{
    Object test;

    public Object getTest() {
        return test;
    }

    public void setTest(Object test) {
        this.test = test;
    }
}
