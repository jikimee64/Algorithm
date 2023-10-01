package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _07_13 {

    static boolean[] check = new boolean[6 + 1];
    static int[] answer = new int[6 + 1];
    static List<List<Integer>> graph = new ArrayList();

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(1);
        graph.get(2).add(5);

        graph.get(3).add(4);

        graph.get(4).add(5);
        graph.get(4).add(6);

        graph.get(6).add(2);
        graph.get(6).add(5);

        check[1] = true;

        BFS(1);
        for (int i : answer) {
            System.out.print(i);
            System.out.println();
        }

    }

    //그래프 경로는 한번 방문한 노드는 다시 방문하지 못한다(규칙)
    static public void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        check[node] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                System.out.println("v : " + v);
                System.out.println("level : " + level);
                answer[v] = level;
                for (int x : graph.get(v)) {
                    if (!check[x]) {
                        System.out.println("offer : x : " + x);
                        queue.offer(x);
                        check[x] = true;
                    }
                } //for
            } //for
            level++;
        }

    }

    //배열 방식
    static public void BFS_arr(int node) {

    }


}


