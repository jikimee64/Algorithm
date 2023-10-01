package com.soap.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NDB_Part02_1이될때까지_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = row[0];
        int k = row[1];
        solution2(n, k);

    }

    //N이 100억 이상일때 시간초과
    public static void solution(int n, int k) {
        int count = 0;

        while (n != 1) {
            if (n % k == 0) {
                n = n / k;
            } else {
                n = n - 1;
            }
            count++;
        }
        System.out.println(count);

    }

    /**
     * 1. n이 k로 나누어질떄까지 먼저 1뺴기
     * 2. 계속 나누기
     * 3. 마지막으로 남은 수에 대하여 1씩 빼기
     */
    public static void solution2(int n, int k) {
        int result = 0;
        while (true) {
            int target = (n / k) * k;
            result += n - target;
            n = target;

            if (n < k) {
                break;
            }
            //k로 나누기
            result += 1;
            n = n / k;
        }
        result += (n - 1);
        System.out.println(result);

    }

}