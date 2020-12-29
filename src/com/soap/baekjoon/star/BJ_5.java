package com.soap.baekjoon.star;

import java.util.Scanner;

public class BJ_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }

            for (int z = 0; z < (2 * i) + 1; z++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
