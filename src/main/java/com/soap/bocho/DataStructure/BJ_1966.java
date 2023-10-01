package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1966
public class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        for (int i = 0; i < size; i++) {
            Queue<Integer> importance = new LinkedList<>(); //중요도 저장
            Queue<Integer> orders = new LinkedList<>(); //순서(인덱스) 저장

            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st2.nextToken());
            int m = Integer.parseInt(st2.nextToken());
            int count = 0;
            List<Integer> numbersOrderMax = new ArrayList<>();

            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st3.nextToken());
                numbersOrderMax.add(num);
                importance.add(num);
                orders.add(j);
            }

            while (true) {
                Integer max = Collections.max(numbersOrderMax);

                Integer important = importance.poll(); //중요도
                Integer order = orders.poll(); //순서

                if (important == max && order == m) {
                    count += 1;
                    break;
                } else if (important == max && order != m) {
                    count += 1;
                    numbersOrderMax.remove(important);
                } else {
                    importance.add(important);
                    orders.add(order);
                }
            }
            System.out.println(count);

        } //end for
    }
}