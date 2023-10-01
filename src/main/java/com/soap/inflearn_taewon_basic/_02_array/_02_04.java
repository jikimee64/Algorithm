package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.StringTokenizer;

public class _02_04 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        int size = Integer.parseInt(sentence);
        int[] arr = new int[size];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < size; i++){
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}