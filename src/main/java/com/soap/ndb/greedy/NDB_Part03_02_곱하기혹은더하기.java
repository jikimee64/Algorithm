package main.java.com.soap.ndb.greedy;

import java.util.Scanner;

/**
 * 만들어질 수 있는 가장 큰수
 * 생각할 조건 - 모든 연산은 왼쪽에서부터 순서대로 이루어짐(연산 우선순위 X)
 */
public class NDB_Part03_02_곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        long result = str.charAt(0) - '0';

        /**
         * 두 수중에서 하나라도 0 혹은 1인 경우 곱하기보다는 더하기가 더 효율적
         * 1 + 2 = 3
         * 1 * 2 = 2
         */
        for (int i = 1; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            // result에 값이 누적되면서 다음값을 순서대로 연산
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
