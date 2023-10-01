package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.Scanner;

public class _02_08 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        solution(sc.nextInt());
    }

    public static void solution(int size) {
        int[] arr = new int[size];
        int[] answer = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < size; i++){
            int rank = 1;

            for(int j = 0; j < size; j++){
                if(arr[j] > arr[i]){
                    rank++;
                }
            }
            answer[i] = rank;
        }

        for(int x : answer){
            System.out.print(x+" ");
        }

    }
}
