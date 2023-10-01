package com.soap.ndb.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/18310
public class NDB_Part03_안테나 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list); //오름차순 정렬

        if (n % 2 == 1) {
            System.out.println(list.get(n / 2));
        } else {
            System.out.println(list.get(n / 2 - 1));
        }

    }
}
