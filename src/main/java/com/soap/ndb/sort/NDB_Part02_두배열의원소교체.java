package main.java.com.soap.ndb.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NDB_Part02_두배열의원소교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.valueOf(st2.nextToken()));
        }

        //a 배열 오름차순
        Collections.sort(a);

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.add(Integer.valueOf(st3.nextToken()));
        }

        //b 배열 내림차순
        Collections.sort(b, (o1, o2) -> o2.compareTo(o1));

        //a의 배열중 최솟갑 <-> b의 배열 중 최댓값
        for (int i = 0; i < k; i++) {
            if (a.get(i) < b.get(i)) {//a의 최솟값이 b의 최댓값보다 작을때만
                a.set(i, b.get(i));
            }
            //A의 원소가 B의 원소보다 크거나 같을 때, 반복문 탈출출            else break;
        }

        int sum = a.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

    }
}
