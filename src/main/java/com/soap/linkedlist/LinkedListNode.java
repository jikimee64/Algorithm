package com.soap.linkedlist;

public class LinkedListNode {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }
}

/**
 * 첫번째 데이터 삭제 가능
 * header는 데이터로 사용되지 않고 관리로만 쓰임
 */
class LinkedList {
    Node header;

    public LinkedList() {
        header = new Node();
    }

    public void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

    }

    /**
     * 돌면서 출력
     */
    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }

    static class Node {
        int data;
        Node next = null;
    }


}

