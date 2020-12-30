package com.soap.ndb.dp;

import java.util.Scanner;
import java.util.StringTokenizer;

public class NDB_Part02_개미전사 {

    public static int[] d = new int[100];
    public static int[] arr;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.next());

        // 모든 식량 정보 입력받기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            /**
             * d[i-2] + arr[i]를 해준 이유는 (i-2)번째 식량창고를 털기로 결정한 경우\
             * 현재의 싱략 창고를 털수 있어서이다.
             */
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println();
    }
}
