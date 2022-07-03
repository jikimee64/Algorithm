package com.soap.inflearn_taewon._01_string;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class _01_07 {

    private static String YES = "YES";
    private static String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(solution(st.nextToken()));
    }

    public static String solution(String sentence) {
        sentence = sentence.toUpperCase(Locale.ROOT);
        int lt = 0;
        int rt = sentence.length() - 1;

        while (lt < rt) {
            char ltChar = sentence.charAt(lt);
            char rtChar = sentence.charAt(rt);

            if(ltChar == rtChar){
                lt++;
                rt--;
            }else{
                return NO;
            }
        }

        return YES;
    }

    public static String solution2(String sentence) {
        int length = sentence.toCharArray().length;
        sentence = sentence.toUpperCase(Locale.ROOT);
        for (int i = 0; i < length / 2; i++) {
            if(sentence.charAt(i) != sentence.charAt(length -i -1)){
                return NO;
            }
        }
        return YES;
    }

    public static String solution3(String sentence) {
        String s = new StringBuffer(sentence).reverse().toString();
        if(sentence.equalsIgnoreCase(s)){
            return YES;
        }
        return NO;
    }

}