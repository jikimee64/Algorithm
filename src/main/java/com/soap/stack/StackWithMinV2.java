package com.soap.stack;

import java.util.Objects;
import java.util.Stack;

public class StackWithMinV2 extends Stack<Integer> {

    private Stack<Integer> stack;

    public StackWithMinV2() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        StackWithMinV2 stack = new StackWithMinV2();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        System.out.println("min: " + stack.min()); // 1
        System.out.println("pop: " + stack.pop()); // 2
        System.out.println("min: " + stack.min()); // 1
        System.out.println("pop: " + stack.pop()); // 1
        System.out.println("min: " + stack.min()); // 3
        System.out.println("pop: " + stack.pop()); // 5
        System.out.println("min: " + stack.min()); // 3
    }

    public Integer push(Integer value) {
        if (value < min()) {
            stack.push(value);
        }
        return super.push(value);
    }

    public Integer pop() {
        Integer pop = super.pop();
        if (Objects.equals(pop, stack.peek())) {
            stack.pop();
        }
        return pop;
    }

    Integer min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stack.peek();
    }

}
