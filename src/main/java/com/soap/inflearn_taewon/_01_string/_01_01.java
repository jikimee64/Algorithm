package com.soap.inflearn_taewon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class _01_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken().toUpperCase(Locale.ROOT);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        char one = st2.nextToken().toUpperCase(Locale.ROOT).charAt(0);
        int count = 0;

        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == one) {
                count += 1;
            }
        }

        //for-each
//        for (char c : word.toCharArray()) {
//            if(c == one) count+= 1;
//        }
        System.out.println(count);
    }

}
