package com.soap.baekjoon.greedy;

import java.util.Scanner;

public class BJ_5585 {
    public static void main(String[] args) {

        int[] arr = {500,100,50,10,5,1};
        int count = 0;

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        a = 1000 - a;

        for(int i=0; i<arr.length; i++){
            count += a/arr[i];
            a = a%arr[i];
        }
        System.out.println(count);

    }
}