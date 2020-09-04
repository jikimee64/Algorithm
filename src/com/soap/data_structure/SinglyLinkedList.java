package com.soap.data_structure;

public class SinglyLinkedList {
    public static void main(String[] args){
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2);
        head.delete(3);
        head.retrieve();
    }
}

class Node{
    int data; //데이터
    Node next = null; //다음 노드의 주소

    Node(int d){
        this.data = d;
    }

    //노드 삽입
    public void append(int data){
        //노드 생성
        Node end = new Node(data);
        //this가 뭐지? => 헤드 노드인가?
        //this : main메서드에서 생성한 Node 객체 자신의 참조값

        Node point = this;
        while(point.next != null){
            point = point.next;
        }
        //새로운 노드추가
        point.next = end;
    }

    //노드 삭제
    //첫 번째 head는 삭제 불가능
    public void delete(int data){
        Node point = this;

        //현재 노드에서 다음 노드 비교 : 맨 마지막 노드 값까지 반복
        while(point.next != null){
            //현재 노드에서 다음 노드 데이터가 삭제할 노드인지 판단(head 삭제 불가능)
            if(point.next.data == data){
                //현재 노드에서 가리키던 다음 노드를 그 다음 다음 노드로...
                //마지막 노드 삭제시 마지막 노드의 이전노드는 null
                point.next = point.next.next;
            }else{
                //값을 찾기 위해서 다음 노드로 이동
                point = point.next;
            }

        }

    }

    //모든 노드 출력
    public void retrieve(){
        Node point = this;

        //마지막 노드 전 단계까지 반복
        while(point.next != null){
            System.out.print(point.data + " -> ");
            point = point.next;;
        }
        //맨 마지막 노드 출력
        System.out.println(point.data);


    }
}