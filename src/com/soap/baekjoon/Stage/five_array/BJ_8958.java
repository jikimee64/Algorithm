package com.soap.baekjoon.Stage.five_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        //String[][] arr = new String[test][];


        for (int i = 0; i < test; i++) {
            String a = br.readLine();
            int sum = 0;
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j) == 'O'){
                    count++;
                    sum += count;
                }else{
                    count = 0;
                }
            }
            System.out.println(sum);
        }

    }
}
