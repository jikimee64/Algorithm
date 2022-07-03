package com.soap;

import java.util.*;

// https://minhamina.tistory.com/83
public class TwoTree {

    public static void main(String[] args) {

        TreeOrderClass t = new TreeOrderClass();

        t.createNode(1, 2, 3);
        t.createNode(2, 4, 5);
        t.createNode(3, 6, 7);

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }

    public static class Node {
        int data; //노드값
        Node left; //왼쪽 자식 노드의 참조값
        Node right; //오른쪽 자식 노드의 참조 값

        public Node(int data) {
            this.data = data;
        }
    }

    // 트리 클래스
    public static class TreeOrderClass {

        public Node root; //초기 root는 null

        public void createNode(int data, int leftData, int rightData) {
            if (root == null) {
                root = new Node(data);

                if (leftData != -1) {
                    root.left = new Node(leftData);
                }

                if (rightData != -1) {
                    root.right = new Node(rightData);
                }
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        //매개변수로 들어온 root노드를 시작으로 data와 같은 값을 가진 node를 찾는다
        //찾을때까지 root노드에서부터 왼쪽, 오른쪽으로 내려감
        public void searchNode(Node node, int data, int leftData, int rightData) {
            if (node == null) {
                return;
            } else if (node.data == data) {
                if (leftData != -1) {
                    node.left = new Node(leftData);
                }
                if (rightData != -1) {
                    node.right = new Node(rightData);
                }
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        //전위순회 Preorder : Root -> Left -> Right
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                if (node.left != null) preOrder(node.left);
                if (node.right != null) preOrder(node.right);
            }
        }


        //중위 순회 Inorder : Left -> Root -> Right
        public void inOrder(Node node) {
            if (node != null) {
                if (node.left != null) inOrder(node.left);
                System.out.print(node.data + " ");
                if (node.right != null) inOrder(node.right);
            }
        }

        //후위순회 Postorder : Left -> Right -> Root
        public void postOrder(Node node) {
            if (node != null) {
                if (node.left != null) postOrder(node.left);
                if (node.right != null) postOrder(node.right);
                System.out.print(node.data + " ");
            }
        }

        public void iterativeOrder(Node curr) {
            Stack<Node> stack = new Stack<>(); //반복적 순회를 위해 스택 생성

            //처음엔 루트 노드부터 시작
            while (curr != null || !stack.isEmpty()) {
                //현재 왼쪽 노드들을 null에 도달할 때까지(마지막 왼쪽 자식 노드까지) 스택에 추가
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                //null 노드에 도달하면 스택에서 하나씩 삭제
                curr = stack.pop();
                System.out.println(curr.data + " "); //삭제된 노드 방문 -> 삭제된 노드의 값 출력

                //삭제된 노드르 방문한 후에 이 노드의 오른쪽 노드로 이동
                curr = curr.right;
                //다시 이 노드를 기준으로 왼쪽 노드들을 null에 도달할 때까지 스택에 추가
                // -> 이를 스택이 빌 때까지 반복하면 이진트리들을 중위순회할 수 있다
            }
        }

        //레벨 순회한 결과 출력
        public void levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.println(node.data + " ");

                if (node.left != null) queue.offer(node.left); //왼쪽 자식 노드가 있다면 추가
                if (node.right != null) queue.offer(node.right); //오른쪽 자식 노드가 있다면 추가
            }
        }

        //레벨별 노드들을 배열로 묶어서 출력
        public void levelByLevel(Node root) {
            List<List<Integer>> list = new ArrayList<>(); //전체 레벨을 달기 위한 List

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>(); //레벨 별 값을 달기 위한 List
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.data); //큐에서 꺼낸 노드 level list에 저장

                    if (node.left != null) queue.offer(node.left); //왼쪽 자식 노드가 있다면 추가
                    if (node.right != null) queue.offer(node.right); //오른쪽 자식 노드가 있다면 추가
                }
                list.add(level); //한 레벨이 끝날 때마다 레벨별 저장된 값들을 전체 list에 저장
            }

            for (List<Integer> integers : list) {
                System.out.println(integers);
            }
        }

    }

}