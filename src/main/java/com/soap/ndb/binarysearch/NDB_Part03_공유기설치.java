package com.soap.ndb.binarysearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2110
public class NDB_Part03_공유기설치 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken()); //집 개수
        int C = Integer.parseInt(st.nextToken()); //공유기 개수

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(list);

        int start = 1; //가능한 최소거리
        int end = list.get(list.size() - 1) - list.get(0); //가능한 최대거리

        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int val = list.get(0);
            int count = 1;

            //주어진 mid 값 기준, 설치할 수 있는 공유기 개수 카운팅
            for (int i = 0; i < N; i++) {
                if (list.get(i) >= val + mid) {
                    val = list.get(i);
                    count++;
                }
            }

            if (count >= C) { //공유기 C이상 설치 가능
                result = Math.max(mid, result);
                start = mid + 1;
            } else { //공유기 C이상 설치 불가
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}


