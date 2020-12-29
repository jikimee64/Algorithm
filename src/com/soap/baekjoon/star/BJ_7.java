package com.soap.baekjoon.star;
import java.util.Scanner;

public class BJ_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int max = (2 * n) - 1;
        int index = 0;
        for (index = 0; index < n; index++) {
            for (int j = n - 1; j > index; j--) {
                System.out.print(" ");
            }

            for (int z = 0; z < (2 * index) + 1; z++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //n = 5, max - temp - 1= 3
        int temp = max - index;
        for (int i = temp - 1; i >= 0 ; i--) {
            for (int j = temp; j > i; j--) {
                System.out.print(" ");
            }

            for (int z = 0; z < (2 * i) + 1; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
