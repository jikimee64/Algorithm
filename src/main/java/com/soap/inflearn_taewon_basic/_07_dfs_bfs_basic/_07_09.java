package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

public class _07_09 {

    static Node root;

    public static void main(String[] args) {
        _07_09 tree = new _07_09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(DFS(0, tree.root));
    }

    /**
     * 말단 노드면 l 리턴
     *
     * @param l
     * @param root
     * @return
     */
    public static int DFS(int l, Node root) {
        if (root.lt == null && root.rt == null) {
            return l;
        } else {
            return Math.min(DFS(l + 1, root.lt), DFS(l + 1, root.rt));
        }
    }

}
