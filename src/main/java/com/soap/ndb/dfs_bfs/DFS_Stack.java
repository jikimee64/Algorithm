package main.java.com.soap.ndb.dfs_bfs;

import java.util.Scanner;
import java.util.Stack;

//https://adrian0220.tistory.com/73
public class DFS_Stack {
    public static int size;
    public static int map[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Size를 입력하시오:");
        size = in.nextInt();

        map = new int[size][size];

        int a, b;
        /**
         * Size를 입력하시오:
         * 8
         * 간선을 입력하시오(종료 -1, -1):
         * 0 1 0 2 0 3 1 4 2 5 2 6 4 7
         * -1 -1
         */
        System.out.println("간선을 입력하시오(종료 -1, -1):");
        
        while (true) {
            a = in.nextInt();
            b = in.nextInt();
            if (a == -1 && b == -1) break;
            map[a][b] = 1;
        }
        Dfs dfs = new Dfs(0, size, map);
        dfs.DfsAction();
    }
}

class Dfs {
    int start;
    int size;
    public static int[] visited;
    public static int[][] map;

    Dfs(int a, int b, int[][] map) {
        start = a;
        size = b;
        Dfs.map = map;
    }

    public void DfsAction() {
        //방문 여부 저장
        visited = new int[size];
        //start 정점 방문 표시
        visited[start] = 1;
        //스택 생성
        Stack<Integer> stack = new Stack<Integer>();
        //시작 점 스택 입력
        stack.add(start);

        //DFS 탐색
        while (!stack.isEmpty()) {
            //큐에서 값 빼오기
            int temp = stack.pop();
            System.out.println(temp);
            //0~size 탐색, 전체를 탐색해서 약간 비효율적
            for (int i = size - 1; i > 0; i--) {
                //길이 존재하고 방문하지 않았다면
                if (map[temp][i] == 1 && visited[i] == 0) {
                    //스택에 추가
                    stack.add(i);
                    //이동
                    visited[temp] = 1;
                }

            }
        }
    }

}
