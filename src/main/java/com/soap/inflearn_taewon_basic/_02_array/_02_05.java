package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.StringTokenizer;

public class _02_05 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        int size = Integer.parseInt(sentence);
        int[] arr = new int[size+1];
        int answer = 0;

        for(int i = 2; i < size; i++){
            if(arr[i] == 0){
                arr[i] = 1;
                answer++;
                for(int j = i*2; j <= size; j += i){
                    arr[j] = 1;
                }
            }
        }
        System.out.println(answer);

    }

}