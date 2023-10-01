package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

public class _07_05 {

    Node root;

    public static void main(String[] args) {
        _07_05 tree = new _07_05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }

    public void DFS(Node root) {
        if (root == null) return;
        else { //sysout 위치에 따른 전위,중위,후위 순회
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

}
