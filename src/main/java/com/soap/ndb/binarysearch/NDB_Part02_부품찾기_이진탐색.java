package com.soap.ndb.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NDB_Part02_부품찾기_이진탐색 {

    public static List<Integer> exist = new ArrayList<>();
    public static List<Integer> request = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static int index = 0;

    public static int binarySearchRecursive(int data, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (exist.get(mid) == data) return mid;
        else if (data < exist.get(mid)) {
            return binarySearchRecursive(data, 0, mid - 1);
        } else {
            return binarySearchRecursive(data, mid + 1, end);
        }
    }

    public static int binarySearchFor(int data, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (exist.get(mid) == data) return mid;
            else if (data < exist.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exist.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(exist);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            request.add(Integer.valueOf(st2.nextToken()));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < request.size(); i++) {
            result.add(binarySearchRecursive(request.get(i), 0, exist.size() - 1));
        }

        for (Integer integer : result) {
            if (integer == -1) {
                sb.append("no ");
            } else {
                sb.append("yes ");
            }
        }

        System.out.println(sb.toString());

    }
}
