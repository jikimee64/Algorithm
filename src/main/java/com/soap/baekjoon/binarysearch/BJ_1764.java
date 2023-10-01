package com.soap.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1764 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            String name = br.readLine();
            set.add(name);
        }
        while (m-- > 0) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);

        StringBuilder ans = new StringBuilder();
        ans.append(list.size()).append('\n');
        for (String str : list) {
            ans.append(str).append('\n');
        }

        System.out.print(ans);

        br.close();
    }
}