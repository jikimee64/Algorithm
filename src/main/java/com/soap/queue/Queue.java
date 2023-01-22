//package com.soap.queue;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//public class Queue<T> {
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    class Node<T> {
//        private T item;
//        private Node<T> next;
//
//        public Node(T item) {
//            this.item = item;
//        }
//    }
//
//    public static void main(String[] args) {
//        Queue<Integer> q = new Queue<Integer>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        System.out.println(q.remove()); //1
//        System.out.println(q.remove()); //2
//        System.out.println(q.peek()); //3
//        System.out.println(q.remove()); //3
//        System.out.println(q.isEmpty()); //false
//        System.out.println(q.remove()); //4
//        System.out.println(q.isEmpty()); //true
//        System.out.println(q.peek()); //NoSuchElementException
//    }
//
//}
