package com.soap.baekjoon.Greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_13458 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int n = Integer.parseInt(in.nextLine());
        long[] arr = new long[n]; //각가의 시험장의 응시자수
        int index = 0;

        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[index++] = Integer.parseInt(st1.nextToken());
        }

        int b = in.nextInt(); //총감독관 최대 응시자수
        int c = in.nextInt(); //부감독관 최대 응시자수

        int first = 0;
        int second = 0;

        for (int i = 0; i < n; i++) {

            arr[i] -= b;
            first++;
            if(arr[i] > 0){
                if(arr[i] <= c){
                    if(arr[i]/c > 0){
                        second += arr[i]/c + 1;
                    }else{
                        second += arr[i]/c;s
                    }
                }else{
                    second++;
                }
            }

        }
        System.out.println(first + second);

    }
}
