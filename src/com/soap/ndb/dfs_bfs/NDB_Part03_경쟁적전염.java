package com.soap.ndb.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class NDB_Part03_경쟁적전염 {

    /**
     * n, k : 배열 행과 열 크기
     * s : 초
     * x, y : (x,y)에 존재하는 바이러스 종류
     */
    public static int n, k, s, x, y;
    public static int[][] map;
    public static List<Node> list = new ArrayList<>(); //Node 클래스를 담을 리스트

    //이동할 네가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken()); //배열 x크기
        k = Integer.parseInt(st.nextToken()); //배열 y크기

        map = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) { //x줄
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) { //한줄당 들어갈 y개수만큼 데이터 삽입
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) { //넣은 데이터가 0이 아니라면 리스트에 추가
                    list.add(new Node(i, j, map[i][j], 0));
                }
            }
        }

        Collections.sort(list); //넣은 데이터기준 오름차순 정렬

        st = new StringTokenizer(in.readLine());
        s = Integer.parseInt(st.nextToken()); //시간
        x = Integer.parseInt(st.nextToken()); //찾는 x값
        y = Integer.parseInt(st.nextToken()); //찾는 y값

        bfs();

        System.out.println(map[x - 1][y - 1]);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        /**
         * 처음 리스트에 넣은 Node 클래스를 차례로 Queue에 넣어준다.
         * 문제 조건인 번호가 낮은 종류 부터 증식한다 (O)
         */
        for (int i = 0; i < list.size(); i++) {
            q.offer(new Node(list.get(i).getIndex(), list.get(i).getDistance(), list.get(i).getData(), 0));
        }

        while (!q.isEmpty()) {
            Node node = q.poll(); //큐에서 하나를 꺼낸다.
            int x = node.getIndex();
            int y = node.getDistance();
            int data = node.getData();
            int count = node.getSecond();

            //지정한 시간이 지나면 while문 탈출
            if (count >= s) break;

            //현재 위치에서 4가지 방향(상,하,좌,우)으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; //현재 위치의 다음위치 x값
                int ny = y + dy[i]; //현재 위치의 다음위치 y값
                //시험관 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= k) continue;
                //해당 노드가 0인 경우
                if (map[nx][ny] == 0) {
                    map[nx][ny] = data; //해당 바이러스의 번호를 넣어준다
                    q.offer(new Node(nx, ny, map[nx][ny], count + 1)); //퍼진 위치에서의 정보를 큐에 넣어주고 count를 1증가시킨다.
                }
            } //for문
        }//while문
    } //bfs()
}

class Node implements Comparable<Node> {
    private int index; //x값
    private int distance; //y값
    private int data; //배열 안 데이터
    private int second; //초

    public Node(int index, int distance, int data, int second) {
        this.index = index;
        this.distance = distance;
        this.data = data;
        this.second = second;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public int getData() {
        return data;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Node node) { //배열안 데이터 기준 오름차순
        return getData() - node.getData();
    }
}