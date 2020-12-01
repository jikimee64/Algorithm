package com.soap.baekjoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_12845 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int sum = 0;
        int index = 0;
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");

        for (int i = 0; i < n; i++){
            arr[index++] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        int max = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; i--){
            sum += (max + arr[i]);
        }

        System.out.println(sum);
    }
}
