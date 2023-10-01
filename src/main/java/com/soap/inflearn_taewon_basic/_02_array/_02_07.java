package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.Scanner;

public class _02_07 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        solution(sc.nextInt());
    }

    public static void solution(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        int score = 0;
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                score++;
                answer += score;
            }else{
                score = 0;
            }
        }
        System.out.println(answer);
    }

}
