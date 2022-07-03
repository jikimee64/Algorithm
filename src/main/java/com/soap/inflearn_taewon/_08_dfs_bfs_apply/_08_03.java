package com.soap.inflearn_taewon._08_dfs_bfs_apply;

import java.util.Scanner;

public class _08_03 {

    static int answer = Integer.MIN_VALUE, n, m;

    public static void main(String[] args) {
        _08_03 T = new _08_03();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }

    /**
     * ps[]: 문제풀었을때 점수
     * pt[]: 걸리는 시간
     *
     * @param L
     * @param sum
     * @param time
     * @param ps
     * @param pt
     */
    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > m) return;
        if (n == L) {
            answer = Math.max(sum, answer);
        } else {
            DFS(L + 1, ps[L] + sum, pt[L] + time, ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }

}
