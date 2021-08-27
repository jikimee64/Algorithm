package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


//https://steady-coding.tistory.com/10 : 풀이

//https://www.acmicpc.net/problem/10799
public class BJ_10799_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> inputs = Arrays.asList(st.nextToken().split(""));

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < inputs.size(); i++) {
            String parentheses = inputs.get(i);
            if (")".equals(parentheses)) {
                stack.pop();
                /**
                 * 이렇게 하면 안됨
                 * String s = stack.peek();
                 * if("(".equals(s)){
                 *  stack.pop();
                 *  ...
                 * }
                 */
                if ("(".equals(inputs.get(i - 1))) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            } else {
                stack.push(parentheses);
            }
        }

        System.out.println(answer);

    }
}
