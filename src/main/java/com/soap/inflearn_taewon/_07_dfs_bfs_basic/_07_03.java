package com.soap.inflearn_taewon._07_dfs_bfs_basic;

public class _07_03 {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static int fact(int number) {
        if (number <= 1) return 1;
        else {
            return number * fact(number - 1);
        }
    }

}
