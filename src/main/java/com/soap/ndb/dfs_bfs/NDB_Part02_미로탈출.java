package main.java.com.soap.ndb.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NDB_Part02_미로탈출 {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static int bfs(int x, int y){
        //큐 구현을 위해 queue 라이브러리 사용
        Queue<NodeBfs> q = new LinkedList<>();
        q.offer(new NodeBfs(x, y));
        //큐가 빌 때까지 반복하기
        while(!q.isEmpty()){
            NodeBfs nodeBfs = q.poll();
            x = nodeBfs.getIndex();
            y = nodeBfs.getDistance();
            //현재 위치에서 4가지 방향으로의 위치 확인
            for(int i = 0; i < 4; i++){
                int nx =  x + dx[i];
                int ny = y + dy[i];
                //미로 찾기 공간을 벗어난 경우 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //벽인 경우 무시
                if(graph[nx][ny] == 0) continue;
                //해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new NodeBfs(nx, ny));
                }
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
            }
        }
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }
}

class NodeBfs {

    private int index;
    private int distance;

    public NodeBfs(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}