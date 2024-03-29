package com.soap.stack;

import lombok.Getter;

public class CustomStack<T> {

    private Node<T> top;

    public static void main(String[] args) {
        CustomStack<Integer> s = new CustomStack<Integer>();
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
        System.out.println(s.pop()); // StackEmptyException
    }

    void push(T item) {
        Node<T> node = new Node<>(item);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.getItem();
        top = top.next;
        return item;
    }

    boolean isEmpty() {
        return top == null;
    }

    T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getItem();
    }

    @Getter
    class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }
}
