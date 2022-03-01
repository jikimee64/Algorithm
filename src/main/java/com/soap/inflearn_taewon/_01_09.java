package com.soap.inflearn_taewon;

import java.io.*;
import java.util.StringTokenizer;

public class _01_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        String replace = sb.toString();
        int i = Integer.parseInt(replace);
        System.out.println(i);
    }

    public static void solution2(String sentence) {
        int answer = 0;
        for (char c : sentence.toCharArray()) {
            if(c >= 48 && c <= 57){
                answer = answer * 10 + (c - 48);
            }
        }
        System.out.println(answer);
    }

}