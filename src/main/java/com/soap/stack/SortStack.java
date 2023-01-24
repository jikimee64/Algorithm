package com.soap.stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);
        sort(s1);
        System.out.println(s1.pop()); // 1
        System.out.println(s1.pop()); // 3
        System.out.println(s1.pop()); // 5
        System.out.println(s1.pop()); // 6
    }

    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Integer pop = s1.pop();
            while (!s2.isEmpty() && s2.peek() > pop) {
                s1.push(s2.pop());
            }
            s2.push(pop);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

}
