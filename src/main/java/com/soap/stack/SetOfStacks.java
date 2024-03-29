package com.soap.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 스택에 데이터를 쌓다가 어느 지점에 이르면 새로운 스택에 저장
 * 내부적으로 여러개 스택으로 나뉘지만
 * push와 pop은 하나의 스택으로 동작
 * 스택의 세트중 하나를 지정해서 데이터를 꺼내올 수 있는 popAt() 함수를 만드시오.
 */
public class SetOfStacks {

    private int capacity; // 하나의 스택에 들어가는 용량
    private List<Stack<Integer>> stacks = new ArrayList<>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        SetOfStacks sos = new SetOfStacks(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);

        sos.push(4);
        sos.push(5);
        sos.push(6);

        sos.push(7);
        sos.push(8);

        System.out.println(sos.pop()); // 8
        System.out.println(sos.pop()); // 7
        System.out.println(sos.pop()); // 6
        System.out.println(sos.pop()); // 5
    }

    Stack<Integer> getLastStack() {
        if(stacks.isEmpty()){
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    void addStack() {
        stacks.add(new Stack<>());
    }

    void removeLastStack() {
        if(!stacks.isEmpty()){
            stacks.remove(getLastStack());
        }
    }

    void push(int value) {
        Stack<Integer> last = getLastStack();
        if(last == null){
            addStack();
            last = getLastStack();
        }
        last.push(value);
        if(last.size() == capacity){
            addStack();
        }
    }

    Integer pop() {
        Stack<Integer> last = getLastStack();
        if(last == null || last.isEmpty()){
            throw new EmptyStackException();
        }
        Integer pop = last.pop();

        if(last.isEmpty()){
            removeLastStack();
        }

        return pop;
    }

}
