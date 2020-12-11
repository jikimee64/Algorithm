package com.soap.ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NDB_Part02_게임개발 {

    public static int n, m, x, y, direction;
    //방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    //전체 맵 정보
    public static int[][] arr = new int[50][50];

    // 북, 동, 남, 서 방향 정의
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st2.nextToken());
        y = Integer.parseInt(st2.nextToken());
        direction = Integer.parseInt(st2.nextToken());
        d[x][y] = 1; //현재 좌표 방문 처리

        //전체 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        int cnt = 1;
        int turn_time = 0; //회전 수
        while (true) {
            //왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction]; //회전 후 미리 탐색
            int ny = y + dy[direction];

            if (d[nx][ny] == 0 && arr[nx][ny] == 0) { //이동한 곳이 육지면
                d[nx][ny] = 1; //1로 변경
                x = nx; //이동한 육지좌표로 변경
                y = ny;
                cnt += 1; //이동한 땅 증가
                turn_time = 0; //새로운 육지로 이동했으니 육지 초기화
                continue;
            } else turn_time += 1; //탐색한 곳이 바다면  한바퀴 더돔

            //이부분 생각하기 어려울듯
            if (turn_time == 4) { //현재바라보는 방향 제외 나머지 3군데 다 돌았는데 이동할 곳이 없으면
                nx = x - dx[direction]; //첫번째 if-else문을 타지 않았으면 nx와 ny값은 기존위치임
                ny = y - dy[direction];
                if (arr[nx][ny] == 0) { //뒤로 갈 수 있다면 이동
                    x = nx;
                    y = ny;
                } else break; //뒤가 바다로 막혀있는 경우
                turn_time = 0;
            }
        }


        System.out.println(cnt);
    }
}
