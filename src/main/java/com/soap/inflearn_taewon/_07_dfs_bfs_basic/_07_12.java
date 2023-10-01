package com.soap.inflearn_taewon._07_dfs_bfs_basic;

import java.util.ArrayList;
import java.util.List;

public class _07_12 {

    static boolean[] check = new boolean[5 + 1];
    static int count = 0;
    static List<List<Integer>> graph = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(4);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(2);
        graph.get(4).add(5);

        check[1] = true;

        DFS(1);
        System.out.println(count);
    }

    //그래프 경로는 한번 방문한 노드는 다시 방문하지 못한다(규칙)
    public static void DFS(int x) {
        if (x == 5) {
            count++;
        } else {
            for (Integer num : graph.get(x)) {
                if (!check[num]) {
                    check[num] = true;
                    DFS(num);
                    check[num] = false;
                }
            }
        }
    }

}
