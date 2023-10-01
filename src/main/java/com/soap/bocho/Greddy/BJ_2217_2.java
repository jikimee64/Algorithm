package com.soap.bocho.Greddy;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/board/view/40089
//★임의로 몇 개의 로프를 골라서 사용해도 된다.
/**
 * 반례
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 */
public class BJ_2217_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] loap = new int[N];
        int max = 0;

        for(int i = 0; i < N; i++) {
            loap[i] = sc.nextInt();
        }

        int size = loap.length;

        //오름 차순
        Arrays.sort(loap);

        for(int i = 0; i < loap.length; i++) {
            int num = (size-i)*loap[i];

            if(num > max){
                max = num;
            }
        }

        System.out.println(max);

    }

}