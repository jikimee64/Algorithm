package com.soap.stack;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks2 {

    public static void main(String[] args) {

    }

}

class InnerSetOfStacks2 {
    int capacity;
    List<Stack<Integer>> stacks = new ArrayList<>();

    public InnerSetOfStacks2(int capacity) {
        this.capacity = capacity;
    }

    public void addStack() {
        stacks.add(new Stack<>(capacity));
    }

    public void removeLastStack() {
        stacks.remove(stacks.size() - 1);
    }

    public Stack<Integer> getLastSack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int data) {
        Stack<Integer> last = getLastSack();
        if (last == null || last.isFull()) {
            addStack();
            last = getLastSack();
        }
        try {
            last.push(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int pop() {
        Stack<Integer> last = getLastSack();
        if (last == null || last.isEmpty()) {
            throw new EmptyStackException();
        }
        int data = last.pop();
        if (last.isEmpty()) {
            removeLastStack();
        }
        return data;
    }

    // 핵심
    //예외처리 if문 3개 추가
    // for문 X
//    public int popAt(int index) {
//
//    }
//
//    // 핵심2
//    // 재귀, try catch 하나
//    public void shiftLeft(int index) {
//
//    }
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

    public void push(Node n) {
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

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.below;
        if (top == null) {
            bottom = null;
        } else {
            top.above = null;
        }
        size--;
        return data;
    }

    public Node popBottom() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node originBottom = bottom;
        bottom = bottom.above;
        if (bottom == null) {
            top = null;
        } else {
            bottom.below = null;
        }
        size--;
        return originBottom;
    }

    class Node {
        E data;
        Node below;
        Node above;

        public Node(E data) {
            this.data = data;
        }
    }

}
