package com.soap.inflearn_taewon._07_dfs_bfs_basic;

public class _07_01 {

    public static int size = 10;

    public static void main(String[] args) {
        //recur(1);
        dfs(3);
    }

    public static void recur(int start) {
        System.out.print(start + " ");
        if (start == size) return;
        recur(start + 1);
    }

    public static void dfs(int n) {
        if (n == 0) return;
        else {
            dfs(n - 1);
            System.out.println(n + " ");
        }
    }

}
