package com.soap.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1920 {

    public static List<Integer> nlist = new ArrayList<>();
    public static List<Integer> mlist = new ArrayList<>();
    public static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nlist.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(nlist);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mlist.add(Integer.valueOf(st2.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            answer.add(bs(mlist.get(i), 0, nlist.size() - 1));
        }

        answer.forEach(System.out::println);

    }

    public static int bs(int target, int start, int end) {
        if (start > end) return 0;
        int mid = (start + end) / 2;
        if (nlist.get(mid) == target) return 1;
        else if (nlist.get(mid) > target) return bs(target, start, mid - 1);
        else return bs(target, mid + 1, end);
    }
}
