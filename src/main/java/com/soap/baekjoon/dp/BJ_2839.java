package com.soap.baekjoon.dp;

import java.util.Scanner;

//https://outseop.github.io/2020/08/31/%EB%B0%B1%EC%A4%80-2839/ : 풀이과정
public class BJ_2839 {

    public static int max = 21000000;

    //각각의 킬로그램까지 가능한 최소 봉지 갯수
    public static int[] dp = new int[5001];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i  = 0; i <= n; i++){
            dp[i] = max;
        }

        dp[3] = 1;
        dp[5] = 1;

        for(int i = 6; i <= n; i++){
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        if(dp[n] >= max){
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }

    }
}
