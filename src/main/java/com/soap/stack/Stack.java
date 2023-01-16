package com.soap.stack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Stack<T> {



    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.pop()); //4
        System.out.println(s.pop()); //3
        System.out.println(s.peek()); //2
        System.out.println(s.pop()); //2
        System.out.println(s.isEmpty()); // false
        System.out.println(s.pop()); // 1
        System.out.println(s.isEmpty()); //true
    }
}
