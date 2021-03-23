package main.java.com.soap.ndb.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NDB_Part03_정렬된배열에서특정수의개수구하기 {

    public static List<Integer> list = new ArrayList<>();

    //x(target)이 나오는 첫번째 위치
    public static int lowerIndex(int target) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    //x(target)이 나오는 마지막 위치
    public static int upperIndex(int target) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st2.nextToken()));
        }

        Collections.sort(list);

        int start = lowerIndex(x);
        int end = upperIndex(x);

        int answer = end - start;

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}