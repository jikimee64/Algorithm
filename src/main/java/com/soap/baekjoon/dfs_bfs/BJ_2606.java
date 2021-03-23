package main.java.com.soap.baekjoon.dfs_bfs;

import java.util.*;

public class BJ_2606 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //정점
        int m = in.nextInt(); //간선

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            list.get(x).add(y);
            list.get(y).add(x);
        }
        list.stream().sorted();

        int result = bfs(1);
        System.out.println(result);
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < list.get(x).size(); i++) {
                int y = list.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    count++;
                }
            }
        }
        return count - 1; //1번 컴퓨터 제외
    }
}
