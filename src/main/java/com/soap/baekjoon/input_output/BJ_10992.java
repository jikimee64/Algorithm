package com.soap.baekjoon.input_output;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10992
public class BJ_10992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        solution(size);
    }

    //https://imnkj.tistory.com/151
    public static void solution(int size) {

        for(int i = 1; i <= size; i++){
            //공백
            //0 ,1, 2
            //2, 1, 0
            for(int z = size - i; z > 0; z--){
                System.out.printf("%s", " ");
            }

            //별


            System.out.println();
        }

    }

}
