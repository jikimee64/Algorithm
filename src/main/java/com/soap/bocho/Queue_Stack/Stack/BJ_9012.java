package main.java.com.soap.bocho.Queue_Stack.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/9012
public class BJ_9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String sen = solve(String.valueOf(br.readLine()));
            System.out.println(sen);
        } //for

    }

    private static String solve(String value) {
        Stack<String> s = new Stack();

        for (int i = 0; i < value.length(); i++) {
            String sen = String.valueOf(value.charAt(i));
            if (sen.equals("(")) {
                s.add(sen);
            } else if (s.isEmpty()) {
                return "NO";
            } else {
                s.pop();
            }
        }

        if (s.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
