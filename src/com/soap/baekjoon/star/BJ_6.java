package com.soap.baekjoon.star;

import java.util.Scanner;

public class BJ_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = n-1; i >= 0; i--) {

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
