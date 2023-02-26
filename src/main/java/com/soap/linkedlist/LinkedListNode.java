package com.soap.linkedlist;

import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

        //KthToLastV1
        LinkedList ll5 = new LinkedList();
        ll5.append(1);
        ll5.append(2);
        ll5.append(3);
        ll5.append(4);

        System.out.println(ll5.KthToLastV1(ll5.header, 1).data); // 4
        System.out.println(ll5.KthToLastV1(ll5.header, 2).data); // 3
        System.out.println(ll5.KthToLastV1(ll5.header, 3).data); // 2
        System.out.println(ll5.KthToLastV1(ll5.header, 4).data); // 1

        //KthToLastV2
        LinkedList ll6 = new LinkedList<>();
        ll6.append(1);
        ll6.append(2);
        ll6.append(3);
        ll6.append(4);
        int k = 2;
        Reference r = new Reference();
        Node found = ll6.KthToLastV2(ll6.getFirst(), k, r);
        System.out.println(found.data);
    }
}

// KthToLastV2
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
class Reference {
    public int count = 0;
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
    public void removeDups() {

    }

    /**
     * 단방향 Linked List 중간노드 삭제 in Java
     * 처음과 마지막 노드는 지우지 못함
     */
    public boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        n.data = n.next.data;
        n.next = n.next.next;

        return true;
    }

    /**
     * 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘
     * '앞에서 n번째면 뒤에서 k번째다' 원리 이용
     * 단방향 Linked List 뒤부터 세기 첫번째 방법 (쉽게 풀라고 만든 문제가 아님)
     */
    public Node KthToLastV1(Node first, int k) {
        return null;
    }

    /**
     * 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘
     * 단방향 Linked List 뒤부터 세기 두번째 방법 (재귀호출)
     * 몇번째 노드인지만 반환하는 함수
     */
    public int KthToLastV2(Node n, int k) {
        return 0;
    }

    /**
     * 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘
     * 단방향 Linked List 뒤부터 세기 두번째 방법 (재귀호출)
     */
    public Node KthToLastV2(Node n, int k, Reference r) {
        return null;
    }

    /**
     * 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘
     * 단방향 Linked List 뒤부터 세기 세번째 방법 (포인터 이용)
     */
    public Node KthToLastV3(Node first, int k) {
        return null;
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

