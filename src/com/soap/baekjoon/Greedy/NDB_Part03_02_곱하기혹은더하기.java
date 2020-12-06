package com.soap.baekjoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

//답봄
public class NDB_Part03_02_곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        long result = str.charAt(0) - '0';

        for (int i = 0; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}
