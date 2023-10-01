package com.soap.stack;

import lombok.Getter;

import java.util.Stack;

public class StackWithMin extends Stack<StackWithMin.StackWithNode> {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        System.out.println("min: " + stack.min()); // 1
        System.out.println(stack.pop().value); // 2
        System.out.println(stack.pop().value); // 1
        System.out.println("min: " + stack.min()); // 3
    }

    void push(Integer value) {
        int newMin = Math.min(value, min());
        super.push(new StackWithNode(value, newMin));
    }

    Integer min() {
        if (super.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return super.peek().min;
    }

    @Getter
    class StackWithNode {
        private Integer value;
        private Integer min;

        public StackWithNode(Integer value, Integer min) {
            this.value = value;
            this.min = min;
        }
    }

}

