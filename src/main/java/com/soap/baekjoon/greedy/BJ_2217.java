package main.java.com.soap.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2217 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];

       for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for (int i = n; i > 0; i--) {
            //int temp = in.nextInt();
            for (int j = 0; j < i; j++) {
                sum[n-i] += arr[n-i];
            }
        }

        Arrays.sort(sum);
        System.out.println(sum[n-1]);

    }
}
