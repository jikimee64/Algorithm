package com.soap.ndb.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//LIS 문제
//https://www.acmicpc.net/problem/18353
//https://freedeveloper.tistory.com/276
public class NDB_Part03_병사배치하기 {

    public static int[] arr;

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        d   = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            d[i] = 7;
        }

        for (int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++){
                if(arr[i] < arr[j]){ //내림차순 위한것?
                    d[i] = Math.min(d[i], d[j] - 1);
                }
            }
        }


        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < d.length; i++){
            set.add(d[i]);
        }

        System.out.println(arr.length-set.size());



    }
}
