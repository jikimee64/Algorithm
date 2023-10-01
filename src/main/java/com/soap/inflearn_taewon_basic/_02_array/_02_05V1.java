package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _02_05V1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(Integer.parseInt(st.nextToken()));
    }

    public static void solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        for(int i = 2; i <= n; i++){
            if(arr[i] == 0){
                answer++;
                for(int j = i; j <= n; j += i){
                    arr[j] = 1;
                }
            }
        }

        System.out.println(answer);
    }

}
