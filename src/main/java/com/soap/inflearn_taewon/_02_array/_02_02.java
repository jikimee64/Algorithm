package com.soap.inflearn_taewon._02_array;

import java.io.*;
import java.util.Scanner;

public class _02_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        solution(sc.nextLine(), sc.nextLine());
    }

    public static void solution(String number, String sentence) {
        int size = Integer.parseInt(number);
        String[] split = sentence.split(" ");
        int min = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < size; i++){
            int i1 = Integer.parseInt(split[i]);
            if(i1 > min){
                count++;
                min = i1;
            }
        }
        System.out.println(count);
    }

}