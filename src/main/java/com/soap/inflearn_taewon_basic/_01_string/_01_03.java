package com.soap.inflearn_taewon_basic._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine());
    }

    public static void solution(String sentense){
        int max = Integer.MIN_VALUE;
        String maxSen = "";

        for (String sen : sentense.split(" ")) {
            int length = sen.length();

            if(length == max){
                continue;
            }

            if(length > max){
                max = length;
                maxSen = sen;
            }

        }

        System.out.println(maxSen);
    }

    //pos : 띄어쓰기의 위치를 반환
    //indexOf와 substirng 사용, 함정 조심
    public static void solution2(String sentense){

    }

}
