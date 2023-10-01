package com.soap.ndb.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NDB_Part03_금광 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];
            int[][] d = new int[n][m];

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = Integer.parseInt(st2.nextToken());
                }
            }

            //첫번째 열 초기화
            for (int z = 0; z < n; z++) {
                d[z][0] = arr[z][0];
            }

            for (int w = 1; w < m; w++) { //열
                for (int a = 0; a < n; a++) { //행

                    if (a == 0) { //1번째 줄
                        d[a][w] += arr[a][w] + Math.max(d[a][w - 1], d[a + 1][w - 1]); //왼쪽, 왼쪽 아래
                    } else if (a == n - 1) { //마지막줄
                        d[a][w] += arr[a][w] + Math.max(d[a][w - 1], d[a - 1][w - 1]); //왼쪽, 왼쪽 위
                    } else { //중간 줄
                        d[a][w] += arr[a][w] + Math.max(d[a - 1][w - 1], Math.max(d[a][w - 1], d[a + 1][w - 1])); //왼쪽 위, 왼쪽, 왼쪽 아래
                    }
                }
            }

            int answer = 0;
            for (int y = 0; y < n; y++) {
                answer = Math.max(answer, d[y][m - 1]);
            }
            System.out.println(answer);

        } //T

    }
}
