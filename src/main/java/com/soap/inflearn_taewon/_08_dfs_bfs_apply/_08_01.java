package com.soap.inflearn_taewon._08_dfs_bfs_apply;

import java.util.Scanner;

public class _08_01 {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public static void main(String[] args) {
        _08_01 T = new _08_01();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

    public void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n) {
            if (sum == total - sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

}
