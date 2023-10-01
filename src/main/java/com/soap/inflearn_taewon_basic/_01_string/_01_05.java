package com.soap.inflearn_taewon_basic._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        solution(sentence);
    }

    public static void solution(String sentence) {
        char[] chars = sentence.toCharArray();
        int left = 0;
        int right = sentence.length() - 1;
        while (left < right) {
            if (!Character.isAlphabetic(chars[left])) {
                left++;
            }else if (!Character.isAlphabetic(chars[right])) {
                right--;
            }else{
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(String.valueOf(chars));
    }

}