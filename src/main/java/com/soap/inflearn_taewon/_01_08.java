package com.soap.inflearn_taewon;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class _01_08 {

    private static String YES = "YES";
    private static String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }

    public static String solution(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(Character.isAlphabetic(c)){
                sb.append(c);
            }
        }

        String reverseStr = new StringBuffer(sb.toString()).reverse().toString();
        if(sb.toString().equalsIgnoreCase(reverseStr)){
            return YES;
        }
        return NO;
    }

    public static String solution2(String sentence) {
        sentence = sentence.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStr = new StringBuffer(sentence).reverse().toString();
        if(sentence.equals(reverseStr)){
            return YES;
        }
        return NO;
    }

}