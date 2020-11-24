package com.soap.baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NaDongBin_큰수의법칙 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        int arrCount = 0;
        int[] num = null;
        int numCount = 0;
        int answer = 0;

        while(st.hasMoreTokens()){
            arr[arrCount] = Integer.parseInt(st.nextToken());
            arrCount++;
        }
        int n = arr[0];
        int m = arr[1];
        int k = arr[2];

        num = new int[n];
        while(st2.hasMoreTokens()) {
            num[numCount] = Integer.parseInt(st2.nextToken());
            numCount++;
        }

        Arrays.sort(num);

        int first = num[num.length-1];
        int second = num[num.length-2];

        outer : while(true){
            for(int i=0; i<k; i++){
                if(m == 0){
                    break outer;
                }
                answer += first;
                m -= 1;
            }
            if(m == 0){
                break;
            }
            answer += second;
            m -= 1;
        }

        System.out.println(answer);

    }
}
