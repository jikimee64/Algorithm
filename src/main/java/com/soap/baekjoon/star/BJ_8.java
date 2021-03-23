package main.java.com.soap.baekjoon.star;

import java.util.Scanner;

public class BJ_8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 2 * n - 1;

        int index = 0;
        //1~5
        for (; index < n; index++) {

            for (int j = 0; j <= index; j++) {
                System.out.print("*");
            }

            //8,6,4,2,0
            for (int j = 2 * (n - index) - 2; j > 0; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= index; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        int temp = max - index; //5일 경우 temp = 4
        //6~9
        for (int i = 0; i < temp; i++) { //0,1,2,3...
            for (int j = 0; j < temp-i; j++) {
                System.out.print("*");
            }
            //2,4,6,8 공백 출력
            for (int j = 0; j < 2*(i+1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < temp-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
