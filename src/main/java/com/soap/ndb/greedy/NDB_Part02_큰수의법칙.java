package com.soap.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NDB_Part02_큰수의법칙 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        int arrCount = 0;
        int[] num = null;
        int numCount = 0;
        int answer = 0;

        while (st.hasMoreTokens()) {
            arr[arrCount] = Integer.parseInt(st.nextToken());
            arrCount++;
        }
        int n = arr[0];
        int m = arr[1];
        int k = arr[2];

        num = new int[n];
        while (st2.hasMoreTokens()) {
            num[numCount] = Integer.parseInt(st2.nextToken());
            numCount++;
        }

        Arrays.sort(num);

        int first = num[num.length - 1];
        int second = num[num.length - 2];

        outer:
        while (true) {
            for (int i = 0; i < k; i++) {
                if (m == 0) {
                    break outer;
                }
                answer += first;
                m -= 1;
            }
            if (m == 0) {
                break;
            }
            answer += second;
            m -= 1;
        }


        /*
        * for (int i = 1; i <= m; i++) {
            if(i%k != 0){
                sum += first;
            }else{
                sum += second;
            }
        }
         이방법은 안되나?
         * */

        /* 수열 이용
        //가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); //나누어 떨어지지 않을 때 나머지 큰수, Ex) 4 4 4 3 4 4

        int result = 0;
        result += cnt * first; //가장 큰 수 더하기
        result += (m - cnt) * second; //두 번째로 큰수 더하기
         */

        System.out.println(answer);

    }
}
