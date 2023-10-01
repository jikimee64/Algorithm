package com.soap.inflearn_taewon_basic._01_string;

import java.util.Scanner;

public class _01_02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        solution2(sc.nextLine());
    }

    public static void solution(String word){
        String result = "";

        for (char c : word.toCharArray()) {
            if(Character.isUpperCase(c)){
                result += Character.toLowerCase(c);
            }else{
                result += Character.toUpperCase(c);
            }
        }
        System.out.println(result);
    }

    //65 ~ 90
    public static void solution2(String word){
        String result = "";

        for (char c : word.toCharArray()) {
            if(c >= 65 && c <= 90){ //대문자
                result += (char)(c+32);
            }else{
                result += (char)(c-32);
            }
        }
        System.out.println(result);
    }

}