package com.soap.inflearn_taewon_basic._01_string;

import java.io.*;
import java.util.StringTokenizer;

public class _01_05V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        char[] answers = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = sentence.length();
        int lt = 0;
        int rt = length - 1;

        while(lt < rt){
            if (!Character.isAlphabetic(sentence.charAt(lt))) {
                lt++;
            } else if (!Character.isAlphabetic(sentence.charAt(rt))) {
                rt--;
            } else {
                char temp = sentence.charAt(lt);
                answers[lt] = sentence.charAt(rt);
                answers[rt] = temp;
                lt++;
                rt--;
            }
        }

        for (char answer : answers) {
            sb.append(answer);
        }
        System.out.print(sb.toString());
    }

}