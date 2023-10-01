package com.soap.inflearn_taewon_basic._02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _02_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        solution(sc.nextLine(), sc.nextLine());
    }

    public static void solution(String number, String sentence) {
        String[] arr = sentence.split(" ");
        String answer = "";
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                answer += arr[i] + " ";
            }else if(Integer.parseInt(String.valueOf(arr[i]))
                    > Integer.parseInt(String.valueOf(arr[i - 1]))) {
                int i1 = Integer.parseInt(String.valueOf(arr[i]));
                int i2 = Integer.parseInt(String.valueOf(arr[i - 1]));
                answer += i1 + " ";
            }
        }
        System.out.println(answer);
    }

}