package com.soap.inflearn_taewon._02_array;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _02_06V1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), "\n");
        String[] s = st2.nextToken().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            int reverse = reverse(arr[i]);
            if (reverse > 1 && isPrime(reverse)) {
                answer += reverse + " ";
            }
        }
        System.out.println(answer);
    }

    /**
     * 123
     */
    public static int reverse(int n) {
        int answer = 0;
        while (n != 0) {
            answer = answer * 10 + n % 10;
            n /= 10;
        }
        return answer;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}