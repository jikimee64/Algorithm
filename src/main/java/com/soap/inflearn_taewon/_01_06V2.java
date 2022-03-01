package com.soap.inflearn_taewon;

import java.io.*;
import java.util.StringTokenizer;

public class _01_06V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
        //char test = 'a'; //97
        //System.out.println((int)test);
    }

    public static void solution(String sentence) {
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            int a = (int)c - 97;
            if(alpha[a] == 0){
                alpha[a]++;
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

}