package com.soap.baekjoon.star;

import java.util.Scanner;

public class BJ_9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 2 * n - 1;

        int index = 0;
        for (; index < n; index++) {
            for (int i = 0; i < index; i++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * (n - index) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int temp = max - index;
        for (int i = 0; i < temp; i++) {
            //4,3,2,1
            for (int j = 0; j < temp - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * (i + 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
