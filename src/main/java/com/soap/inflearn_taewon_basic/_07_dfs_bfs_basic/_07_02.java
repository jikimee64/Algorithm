package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

public class _07_02 {

    public static void main(String[] args) {
        dfs(11); //1011
    }

    public static void dfs(int number) {
        if (number == 0) return;
        else {
            dfs(number / 2);
            System.out.print(number % 2);
        }
    }

}
