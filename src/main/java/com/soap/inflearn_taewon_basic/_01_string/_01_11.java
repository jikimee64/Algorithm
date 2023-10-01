package com.soap.inflearn_taewon_basic._01_string;

import java.io.*;
import java.util.StringTokenizer;

public class _01_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        sentence += " ";
        int count = 1;
        String answer = "";
        for (int i = 0; i < sentence.length() - 1; i++) {
            char temp = sentence.charAt(i);
            if(sentence.charAt(i) == sentence.charAt(i+1)){
                count++;
            }else{
                answer += temp;
                if(count > 1){
                    answer += String.valueOf(count);
                }
                count = 1;
            }
        }

        System.out.println(answer);
    }

}