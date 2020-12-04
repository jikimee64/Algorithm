package com.soap.baekjoon.Stage.seven_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10809 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        String a = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(i);
            int d = (temp - 97);
            if(arr[d] == -1){
                arr[d] = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }

    }
}
