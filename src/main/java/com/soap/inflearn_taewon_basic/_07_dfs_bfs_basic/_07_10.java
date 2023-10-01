package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;

public class _07_10 {

    static Node root;

    public static void main(String[] args) {
        _07_09 tree = new _07_09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(BFS(0, tree.root));
    }

    /**
     * 레벨 탐색을 하다가 말단 노드를 발견하면 그게 답
     *
     * @param l
     * @param root
     * @return
     */
    public static int BFS(int l, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < queue.size(); i++) {
                if (poll.lt == null && poll.rt == null) return l;
                else {
                    if (poll.lt != null) queue.add(poll.lt);
                    if (poll.rt != null) queue.add(poll.rt);
                }
            }
            level++;
        } //while
        return level;
    }

}
