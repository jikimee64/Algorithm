package com.soap.inflearn_taewon;

import java.io.*;
import java.util.StringTokenizer;

public class _01_06V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    /**
     * ksekkset
     * k 0 0
     * s 1 1
     * e 2 2
     * k 3 0
     * k 4 0
     * s 5 1
     * e 6 2
     * t 7 7
     */
    public static void solution(String sentence) {
        String answer="";

        for(int i = 0; i < sentence.length(); i++){
            System.out.println(sentence.charAt(i) + " " + i + " " + sentence.indexOf(sentence.charAt(i)));
        }
    }

}