package com.soap.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NDB_Part02_큰수의법칙_2 {

    public static int[] data;
    public static int n;
    public static int m;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputNumArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = inputNumArr[0];
        m = inputNumArr[0];
        k = inputNumArr[0];
        solution();
    }

    //M이 100억 이상이라면 시간초과
    public static void solution(){
        int sum = 0;

        Arrays.sort(data);
        int firstMax = data[data.length - 1];
        int twoMax = data[data.length - 2];

        for(int i = 1; i <= m; i++){
            if(i % k == 0){
                sum += twoMax;
            }else{
                sum += firstMax;
            }
        }
        System.out.println(sum);
    }

    public static void solution2(int m, int k){
        int sum = 0;

        Arrays.sort(data);
        int firstMax = data[data.length - 1];
        int twoMax = data[data.length - 2];

        // 가장 큰 수가 더해지는 횟수 계산
        int count = m / (k + 1) * k;
        count += m % (k + 1);

        int result = 0;
        result += (count) * firstMax;      //가장 큰 수 더하기
        result += (m - count) * twoMax; // 두 번째로 큰 수 더하기

        System.out.println(result);
        
    }
}
