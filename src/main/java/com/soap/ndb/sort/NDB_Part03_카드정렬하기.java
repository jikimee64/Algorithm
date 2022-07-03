package main.java.com.soap.ndb.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1715
public class NDB_Part03_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //(우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            q.add(Integer.valueOf(br.readLine()));
        }

        while (!q.isEmpty() && q.size() != 1) {
            int temp = q.poll() + q.poll();
            q.add(temp);
            sum += temp;
        }
        System.out.println(sum);
    }
}
