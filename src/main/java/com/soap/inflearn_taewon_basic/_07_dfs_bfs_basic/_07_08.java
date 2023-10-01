package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;

public class _07_08 {

    static int s = 0; //현수위치
    static int e = 0; //송아지위치
    static int dis[] = {1, -1, 5};
    static int ch[]; //메모제이션(방문여부 체크)
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        s = 5;
        e = 14;

        System.out.println(BFS(s, e));
    }

    public static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        q.add(s);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    //큐에 넣기 전에 검사하는게 더 효과적
                    //level 증가 전이므로 출력시 + 1
                    if (nx == e) {
                        return level + 1;
                    }
                    /**
                     * 문제에 범위가 있으므로 숫자범위 체크
                     * ch[nx] == 0: 계산된 값은 방문 x
                     */
                    if (nx >= 1 && nx <= 10_000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.add(nx);
                    }
                }
            }
            level++;
        }
        return level;
    }

}















