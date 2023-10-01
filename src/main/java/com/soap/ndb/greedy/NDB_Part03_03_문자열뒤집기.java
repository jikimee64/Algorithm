package com.soap.ndb.greedy;

import java.util.Scanner;

/**
 * 0과 1로만 이루어진 문자열 => 최소 1번은 뒤집는다.
 */
public class NDB_Part03_03_문자열뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int count0 = 0; //전부 0으로 바꾸는 경우
        int count1 = 0; //전부 1로 바꾸는 경우

        // 첫 번째 원소에 대해서 처리
        if (str.charAt(0) == '1') {
            count0 += 1;
        } else {
            count1 += 1;
        }
        /**
         * 첫번째 원소 처리시
         * Ex2) 100011
         * 1) 첫번째 원소 처리시
         * 1->0 : 2번
         * 0->1 : 1번
         * 1) 첫번째 원소 미처리시
         * 1->0 : 1번(첫번째 원소 미체크)
         * 0->1 : 1번
         *
         * Ex2) 0001100
         * 1) 첫번째 원소 처리시
         * 1->0 : 1번
         * 0->1 : 2번
         * 1) 첫번째 원소 미처리시
         * 1->0 : 1번
         * 0->1 : 1번(첫번째~세번째 '000' 미체크)
         */

        //두번째 원소부터 모든 원소를 확인
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') { // 0으로 가다가 다음 수에서 1로 바뀌는 경우
                    count0 += 1;
                } else { // 1로 가다가 다음 수에서 0으로 바뀌는 경우
                    count1 += 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
