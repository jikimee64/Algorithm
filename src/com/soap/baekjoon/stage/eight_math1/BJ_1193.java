package com.soap.baekjoon.stage.eight_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /**
         * 1 : 1단계 (back 1~)
         * 2 ~ 3 : 2단계 (front 1~)
         * 4 ~ 6 : 3단계 (back 1~)
         * 7 ~ 10 : 4단계 (front 1~)
         * 11 ~ 15 : 5단계 (back 1~)
         * a(0) = 1
         * a(n) = a(n-1)+ n-1
         */

        //
        int stage = 2; // 2단계부터 시작
        int startNumber = 2;
        int startPlus = 2;
        int endNumber = 3;
        int endPlus = 3;

        if (N == 1) {
            System.out.printf("%d/%d", 1, 1);
        } else {
            while (true) {
                if (N <= endNumber) {
                    if (stage % 2 == 0) {
                        System.out.printf("%d/%d", N - startNumber + 1, endNumber - N + 1);
                        break;
                    } else {
                        System.out.printf("%d/%d", endNumber - N + 1, N - startNumber + 1);
                        break;
                    }
                }
                stage += 1;
                startNumber += startPlus;
                startPlus++;
                endNumber += endPlus;
                endPlus++;
            }

        }

    }
}

