//package com.soap.stack;
//
//class FullStackException extends RuntimeException {
//
//}
//
//class EmptyStackException extends RuntimeException {
//
//}
//
///**
// * 배열로 스택 구현 (고정길이 스택)
// * 배열 하나로 스택 구현
// */
//public class FixedMultiStacks {
//
//    private int numOfStacks = 3;
//    private int stackSize = 3;
//    private int[] values;
//    private int[] sizes;
//
//    public FixedMultiStacks(int stackSize) {
//
//    }
//
//    public static void main(String[] args) {
//        FixedMultiStacks ms = new FixedMultiStacks(5);
//        try {
//            ms.push(0, 1);
//            ms.push(0, 2);
//            ms.push(0, 3);
//            ms.push(0, 4);
//            ms.push(0, 5);
//
//            ms.push(1, 11);
//            ms.push(1, 12);
//            ms.push(1, 13);
//            ms.push(1, 14);
//            ms.push(1, 15);
//
//        } catch (FullStackException e) {
//            System.out.println("It's full");
//        }
//
//        try {
//            System.out.println("Stack #0: " + ms.pop(0)); // 5
//            System.out.println("Stack #0: " + ms.pop(0)); // 4
//            System.out.println("Stack #0: " + ms.peek(0)); // 3
//            System.out.println("Stack #0: " + ms.pop(0)); // 3
//            System.out.println("Stack #0: " + ms.isEmpty(0)); // false
//            System.out.println("Stack #0: " + ms.pop(0)); // 2
//            System.out.println("Stack #0: " + ms.pop(0)); // 1
//            System.out.println("Stack #0: " + ms.isEmpty(0)); // true
//            System.out.println("==========================");
//            System.out.println("Stack #1: " + ms.pop(1)); // 15
//            System.out.println("Stack #1: " + ms.pop(1)); // 14
//            System.out.println("Stack #1: " + ms.peek(1)); // 13
//            System.out.println("Stack #1: " + ms.pop(1)); // 13
//            System.out.println("Stack #1: " + ms.isEmpty(1)); // false
//            System.out.println("Stack #1: " + ms.pop(1)); // 12
//            System.out.println("Stack #1: " + ms.pop(1)); // 11
//            System.out.println("Stack #1: " + ms.isEmpty(1)); // true
//
//        } catch (EmptyStackException e) {
//            System.out.println("It's empty");
//        }
//
//    }
//
//    void push(int stackNum, int data) throws FullStackException {
//
//    }
//
//    int pop(int stackNum) throws FullStackException {
//
//    }
//
//    int peek(int stackNum) {
//    }
//
//    boolean isEmpty(int stackNum) {
//    }
//
//    boolean isFull(int stackNum) {
//    }
//
//    public int getTopIndex(int stackNum) {
//    }
//
//}
