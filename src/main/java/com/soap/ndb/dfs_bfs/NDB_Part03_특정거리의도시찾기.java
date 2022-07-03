package main.java.com.soap.ndb.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/18352
public class NDB_Part03_특정거리의도시찾기 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); //그래프 정보
    public static int[] distance; //출발지 기준 각 도시간의 거리를 담을 배열
    static int N; //도시의 개수
    static int M; //도로의 개수
    static int K; //거리 정보
    static int X; //출발 도시의 번호

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (distance[y] == -1) {
                    distance[y] = distance[x] + 1;
                    q.offer(y);
                }
            } //for
        } //while
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //도시의 개수
        M = Integer.parseInt(st.nextToken()); //도로의 개수
        K = Integer.parseInt(st.nextToken()); //거리 정보
        X = Integer.parseInt(st.nextToken()); //출발 도시의 번호

        distance = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        // 도로값 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st2.nextToken())).add(Integer.parseInt(st2.nextToken()));
        }

        bfs(X);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == K) {
                list.add(i);
            }
        }

        Collections.sort(list);

        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            list.stream().forEach(x -> System.out.println(x));
        }

    }
}
