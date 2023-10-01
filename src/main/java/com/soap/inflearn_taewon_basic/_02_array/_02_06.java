package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.Scanner;

public class _02_06 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        solution(sc.nextLine());
    }

    public static void solution(String sentence) throws IOException {
        int size = Integer.parseInt(sentence);
        for (int i = 0; i < size; i++) {
            int i1 = Integer.parseInt(sc.next());
            int reverse = reverse(i1);
            if (reverse > 1 && isPrime(reverse) == 1) {
                System.out.print(reverse + " ");
            }
        }
    }

    /**
     * 숫자를 뒤집으려면 숫자를 10으로 나눈 나머지를 계속 더해준다.
     * 더할때 기존 숫자에 곱하기 10을 해줘야 자릿수를 하나씩 넘길 수 있다.
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

    public static int isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

}