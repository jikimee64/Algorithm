package com.soap.linkedlist;

public class LinkedListNode {

    public static void main(String[] args) {
//        LinkedList ll = new LinkedList();
//        ll.append(1);
//        ll.append(2);
//        ll.append(3);
//        ll.append(4);
//        ll.retrieve();
//        ll.delete(1);
//        ll.retrieve();

        //removeDups
        LinkedList ll2 = new LinkedList();
        ll2.append(2);
        ll2.append(1);
        ll2.append(2);
        ll2.append(3);
        ll2.append(4);
        ll2.append(4);
        ll2.append(2);
        ll2.removeDups();
        ll2.retrieve(); // 2 -> 1 -> 3 -> 4

        LinkedList ll3 = new LinkedList();
        ll3.append(2);
        ll3.append(2);
        ll3.removeDups();
        ll3.retrieve(); // 2

        //deleteNode
        LinkedList ll4 = new LinkedList();
        ll4.append(1);
        ll4.append(2);
        ll4.append(3);
        ll4.append(4);

        //deleteNode();

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
     * Linked List 중복값 삭제 in Java
     * 버퍼 사용 X
     */
    void removeDups() {

    }

    /**
     * 단방향 Linked List 중간노드 삭제 in Java
     * 처음과 마지막 노드는 지우지 못함
     */
    boolean deleteNode(Node n) {
        return true;
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

