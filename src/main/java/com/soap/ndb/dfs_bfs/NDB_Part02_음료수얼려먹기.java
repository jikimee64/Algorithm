package main.java.com.soap.ndb.dfs_bfs;

import java.util.Scanner;

public class NDB_Part02_음료수얼려먹기 {

    static int n, m;
    static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y){
        //주어진 범위를 벗어나는 경우에는 즉시 종료
        if(x <= -1 || x > n || y <= -1 || y >= m){
            return false;
        }

        //현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0){
            //해당 노드 방문 처리
            graph[x][y] = 1;
            //상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        in.nextLine(); //버퍼 지우기

        for(int i = 0; i < n; i++){
            String str = in.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //현재 위치에서 DFS 수행
                if(dfs(i,j)){
                    result += 1;
                }
            }
        }
        System.out.println(result); //정답 출력
    }
}
