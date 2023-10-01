package com.soap.inflearn_taewon._07_dfs_bfs_basic;

public class _07_11 {

    static boolean[] check = new boolean[5 + 1];
    static int[] path = new int[5 + 1];
    static int count = 0;
    static int[][] graph = {
            //0  1  2  3  4  5
            {0, 0, 0, 0, 0, 0,},
            {0, 0, 1, 1, 1, 0,},
            {0, 1, 0, 1, 0, 1,},
            {0, 0, 0, 0, 1, 0,},
            {0, 0, 1, 0, 0, 1,},
            {0, 0, 0, 0, 0, 0,}
    };

    public static void main(String[] args) {
        check[1] = true;
        path[1] = 1;
        DFS2(2, 1);
        //System.out.println(count);
    }

    //그래프 경로는 한번 방문한 노드는 다시 방문하지 못한다(규칙)
    public static void DFS(int x) {
        if (x == 5) {
            count++;
        } else {
            for (int i = 1; i <= 5; i++) {
                if (!check[i] && graph[x][i] == 1) {
                    check[x] = true;
                    DFS(i);
                    check[i] = false;
                }
            }
        }
    }

    //경우의 수 모두 출력 추가
    public static void DFS2(int L, int x) {
        if (x == 5) {
            count++;
            for (int i = 1; i < path.length; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= 5; i++) {
                if (!check[i] && graph[x][i] == 1) {
                    check[x] = true;
                    path[L] = i;
                    DFS2(L + 1, i);
                    path[L] = 0;
                    check[i] = false;
                }
            }
        }

    }

}
