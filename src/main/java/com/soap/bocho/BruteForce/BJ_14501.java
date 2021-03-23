package main.java.com.soap.bocho.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14501 {

    private static int[][] arr;
    private static int N;
    private static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        arr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //-------------입력부

        go(1, 0);

        System.out.println(max);

    } // end main

    private static void go(int index, int sum) {

        if(max < sum)
            max = sum;

        if(index > N)
            return;

        // 내가 오늘(index) 상담을 할 수 있는지 검사
        int tmp = index + arr[index][0];
        if(tmp <= N + 1){ //index 당일날부터 상담을 하기 때문에 N + 1
            go(tmp, sum + arr[index][1]); // 오늘(index) 상담 해보기
        }
        /**
         * 오늘 상담을 안할 경우 얻는 수익이 더 클 경우를 위해서
         * 오늘 상담을 할 수 있든지 없든지 상관없이 상담을 안해보는 경우 추가
         */
        go(index + 1, sum);

    } // end go

} // end class