package com.soap.inflearn_taewon._08_dfs_bfs_apply;

import java.util.Scanner;

public class _08_02 {
    static int answer = Integer.MIN_VALUE, c, n;

    public static void main(String[] args) {
        _08_02 T = new _08_02();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

    public void DFS(int L, int sum, int[] arr) {
        if (sum > c) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, arr[L] + sum, arr);
            DFS(L + 1, sum, arr);
        }
    }

}
