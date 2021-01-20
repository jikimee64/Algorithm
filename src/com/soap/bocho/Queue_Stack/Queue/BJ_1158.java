package com.soap.bocho.Queue_Stack.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1158
public class BJ_1158 {
    public static void main(String[] args) throws IOException {

        //1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있다.
        //순서대로 K번째 사람을 제거한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList();


        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty()) {

            if (count == K - 1) {
                list.add(q.poll());
                count = 0;
            } else {
                q.add(q.poll());
                count++;
            }

        }

        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i) + ", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());

    }
}
