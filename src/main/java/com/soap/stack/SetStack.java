//package com.soap.stack;
//
//class MyQueue<T> {
//    private java.util.Stack<T> newStack;
//    private java.util.Stack<T> oldStack;
//
//    public MyQueue() {
//        this.newStack = new java.util.Stack<>();
//        this.oldStack = new java.util.Stack<>();
//    }
//
//}
//
///**
// * 두개의 스택을 하나의 큐로 구현하시오.
// */
//public class SetStack {
//    public static void main(String[] args) {
//        MyQueue<Integer> q = new MyQueue<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        System.out.println(q.size()); // 3
//        System.out.println(q.remove()); // 1
//        System.out.println(q.size()); // 2
//        System.out.println(q.peek()); // 2
//        System.out.println(q.remove()); // 2
//        System.out.println(q.size()); // 1
//        System.out.println(q.peek()); // 3
//        System.out.println(q.remove()); // 3
//        System.out.println(q.size()); // 0
//    }
//}
