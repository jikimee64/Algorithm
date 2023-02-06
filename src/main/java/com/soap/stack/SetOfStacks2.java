package com.soap.stack;

public class SetOfStacks2 {

    public static void main(String[] args) {

    }

}

class Stack<E> {

    int capacity; //스택에 쌓을 수 있는 한계점
    int size; // 현재 스택의 사이즈
    Node top;
    Node bottom;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void push(E d) {
        if (isFull()) {
            throw new FullStackException();
        }

        Node n = new Node(d);
        push(n);
    }

    private void push(Node n) {
        if (isEmpty()) {
            top = n;
            bottom = n;
        } else {
            n.above = null;
            n.below = top;
            top = n;
        }
        size++;
    }

//    public E pop() {
//
//    }
//
//    public Node popBottom() {
//
//    }

    class Node {
        E data;
        Node below;
        Node above;

        public Node(E data) {
            this.data = data;
        }
    }

}
