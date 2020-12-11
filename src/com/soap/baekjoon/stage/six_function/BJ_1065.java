package com.soap.baekjoon.stage.six_function;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BJ_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0; //1~99까지는 한수
        List<Integer> list = new ArrayList<>();

        if (num < 100) {
            count = num;
        } else {
            count = 99;
            if (num == 1000) {
                num = 999;
            }

            for (int i = 100; i <= num; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
