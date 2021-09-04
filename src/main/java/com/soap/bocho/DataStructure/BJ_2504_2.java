package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2504
//https://loosie.tistory.com/349?category=982577 : 풀이
//https://soobarkbar.tistory.com/151 : 풀이
public class BJ_2504_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] split = st.nextToken().split("");
        int answer = 0;
        int temp = 1; //중간값
        abc : for (int i = 0; i < split.length; i++) {
            String text = split[i];

            switch (text) {
                case "(":
                    stack.push(text);
                    temp *= 2;
                    break;
                case "[":
                    stack.push(text);
                    temp *= 3;
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        answer = 0;
                        break abc;
                    }
                    if (split[i - 1].equals("(")) {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 2;
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        answer = 0;
                        break abc;
                    }
                    if (split[i - 1].equals("[")) {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 3;
                    break;
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);

    }
}