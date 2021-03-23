package main.java.com.soap.baekjoon.stage.eight_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2292 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0; //결과값

        // 1: 1 (1)
        // 2 ~ 7 : 2 (6개)
        // 8 ~ 19 : 3 (12개)
        // 20 ~ 37 : 4 (18개)
        // 38 ~ 61 : 5 (24개)
        // ...생략.. // a(n) = a(n-1) + 6(n-1) | a(n): 첫 항

        /* 내풀이
        int num = 1; //a(1) 값
        int prev = 0; //a(n-1)값
        int index = 1; //방정식의 인덱스

        while(num<N){
            prev = num;
            num = prev + 6*(index-1);

            index++;
            result++;
        }

        if(N==1){
            result = 1;
        }
         System.out.println(result);
        */

        //모법답안
        int count = 1; // 겹 수(최소 루트)
        int range = 2;    // 범위 (최솟값 기준)

        if (N == 1) {
            System.out.print(1);
        } else {
            while (range <= N) {    // 범위가 N보다 커지기 직전까지 반복
                range = range + (6 * count);    // 다음 범위의 최솟값으로 초기화
                count++;    // count 1 증가
            }
            System.out.print(count);
        }



    }
}
