package com.soap.linkedlist;

/**
 * 첫번재 노드는 삭제를 못하는 버전
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve(); // 1 -> 2 -> 3 -> 4
        head.delete(2);
        head.delete(3);
        head.retrieve(); // 1 -> 4
    }

}

class Node {
    int data;
    Node next = null;

    public Node(int d) {
        this.data = d;
    }

    public void append(int d) {
        Node end =  new Node(d);
        Node n = this;
        while( n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = this;
        while(n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }

    }

    /**
     * 돌면서 출력
     */
    public void retrieve() {
        Node n = this;
        while(n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }

    // 스스로 한거 비추
//    public void retrieve() {
//        Node node = this;
//        System.out.print(node.data + " -> "); // 첫번째
//        while (node.next != null) {
//            node = node.next;
//            if (node.next == null) {
//                System.out.print(node.data);
//            } else {
//                System.out.print(node.data + " -> ");
//            }
//        }
//    }

}
