package com.soap.baekjoon.input_output;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10991
public class BJ_10991 {

    public static void main(String[] args) {
        //int[] input = {1,2,3,4};
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        solution(i);
    }

    public static void solution(int size) {
        for(int i = 0; i < size; i++){

            //공백
            //0 ,1, 2
            //2, 1, 0
            for(int z = size - i - 1; z > 0; z--){
                System.out.printf("%s", " ");
            }

            //별
            for(int j = 0; j <= i; j++){
                System.out.printf("%s", "* ");
            }
            System.out.println();
        }
    }
}
