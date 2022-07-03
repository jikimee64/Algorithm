package com.soap.inflearn_taewon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_05V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        solution(sentence);
    }

    public static void solution(String sentence){
        char[] chars = sentence.toCharArray();

        int lt = 0;
        int rt = sentence.length() - 1;

        while(lt < rt){
            if(!Character.isAlphabetic(chars[lt])){
                lt++;
            }else if(!Character.isAlphabetic(chars[rt])){
                rt--;
            }else{
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(chars));
    }

}
