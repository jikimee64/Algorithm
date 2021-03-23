package main.java.com.soap.baekjoon.stage.five_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = -9999;
        float avg = 0;
        float sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            sum += ((float)arr[i]/max)*100;
        }
        avg = sum/arr.length;

        System.out.println(avg);

    }
}
