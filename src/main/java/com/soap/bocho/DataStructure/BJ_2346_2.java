package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//LinkedList 쓰면 메모리초과 발생
//https://www.acmicpc.net/problem/2346
public class BJ_2346_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        Deque<Map<Integer, Integer>> map = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> map2 = new HashMap<>();
            map2.put(i + 1, Integer.parseInt(st2.nextToken()));
            map.add(map2);
        }

        while (!map.isEmpty()) {
            Map<Integer, Integer> map3 = map.pollFirst();
            if (Objects.nonNull(map3)) {
                for (Integer key : map3.keySet()) {
                    sb.append(key).append(" ");
                    if(map.isEmpty()) break; //★★★★★★★★★★★★★★
                    Integer value = map3.get(key);
                    if (value > 0) {
                        for (int j = 0; j < value - 1; j++) {
                            map.addLast(map.pollFirst());
                        }
                    } else {
                        for (int j = 0; j < Math.abs(value); j++) {
                            map.addFirst(map.pollLast());
                        }
                    }
                }
            }
        }
        System.out.print(sb.toString().trim());

    }
}
