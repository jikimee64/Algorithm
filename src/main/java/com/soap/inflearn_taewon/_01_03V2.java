package com.soap.inflearn_taewon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_03V2 {

    public static String BLANK = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(BLANK);

        String maxLengthWord = "";
        int maxLength = 0;
        for (String word : words) {
            int wordSize = word.length();

            if(maxLength == wordSize){
                continue;
            }

            if (maxLength < wordSize) {
                maxLength = wordSize;
                maxLengthWord = word;
            }
        }

        System.out.println(maxLengthWord);

    }

}