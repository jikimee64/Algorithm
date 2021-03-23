package main.java.com.soap.baekjoon.dfs_bfs;

import java.util.*;

public class BJ_1260 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //정점의 개수
        int m = in.nextInt(); //간선의 개수
        int v = in.nextInt(); //탐색을 시작할 정점의 번호

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        //정렬
        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        //bfs 방문기록 초기화
        visited = new boolean[n + 1];
        System.out.println();
        bfs(v);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        //현재 노드를 방문 처리
        visited[start] = true;
        //큐가 빌때 까지 반복
        while (!q.isEmpty()) {
            //큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            //해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void dfs(int x) {
        //현재 노드를 방문
        visited[x] = true;
        System.out.print(x + " ");
        //현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }


}
