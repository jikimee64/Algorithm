package com.soap.ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDB_Part03_07_럭키스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        String[] arr = N.split("");

        int a = arr.length;
        int mid = a/2;

        int first = 0;
        int second = 0;

        int index = 0;
        while(index < arr.length){
            if(index >= mid){
                second += Integer.parseInt(arr[index]);
                index++;
            }else{
                first += Integer.parseInt(arr[index]);
                index++;
            }
        }

        String result = first == second ? "LUCKY" : "READY";

        System.out.println(result);


        /*나동빈 코드

        public static String str;
        public static int summary = 0;

        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 왼쪽 부분의 자릿수의 합 더하기
        for (int i = 0; i < str.length() / 2; i++) {
            summary += str.charAt(i) - '0';
        }

        // 오른쪽 부분의 자릿수의 합 빼기
        for (int i = str.length() / 2; i < str.length(); i++) {
            summary -= str.charAt(i) - '0';
        }

        // 왼쪽 부분과 오른쪽 부분의 자릿수 합이 동일한지 검사
        if (summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");*/

    }
}

