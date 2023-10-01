package com.soap.inflearn_taewon._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;

public class _07_07 {

    Node root;

    public static void main(String[] args) {
        _07_07 tree = new _07_07();
        tree.root = new Node(1);
        tree.root.lt = new Node(3);
        tree.root.rt = new Node(7);
        tree.root.lt.lt = new Node(2);
        tree.root.lt.rt = new Node(9);
        tree.root.rt.lt = new Node(4);
        tree.root.rt.rt = new Node(5);
        //tree.BFS(tree.root);
        tree.BFS2(tree.root);
    }

    public void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.data + " ");
            if (poll.lt != null) queue.add(poll.lt);
            if (poll.rt != null) queue.add(poll.rt);
        }
    }

    public void BFS2(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) queue.add(cur.lt);
                if (cur.rt != null) queue.add(cur.rt);
            }
            level++;
            System.out.println();
        }
    }


}


