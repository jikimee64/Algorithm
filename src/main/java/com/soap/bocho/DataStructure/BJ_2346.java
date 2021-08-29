package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//LinkedList 쓰면 메모리초과 발생
//https://www.acmicpc.net/problem/2346
public class BJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Integer> orders = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st2.nextToken()));
            orders.add(i + 1);
        }

        for (int i = 0; i < N; i++) {
            if (Objects.nonNull(numbers.peekFirst()) && Objects.nonNull(orders.peekFirst())) {
                Integer number = numbers.pollFirst();
                Integer order = orders.pollFirst();
                sb.append(order).append(" ");
                if (Objects.nonNull(number)) {
                    if(numbers.isEmpty()) break; //★★★★★★★★★★★★★★
                    if (number > 0) {
                        for (int j = 0; j < number - 1; j++) {
                            numbers.addLast(numbers.pollFirst());
                            orders.addLast(orders.pollFirst());
                        }
                    } else
                        for (int j = 0; j < Math.abs(number); j++) {
                            numbers.addFirst(numbers.pollLast());
                            orders.addFirst(orders.pollLast());
                        }
                }
            }
        }

        System.out.println(sb.toString().trim());

    }
}