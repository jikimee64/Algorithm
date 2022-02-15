package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

//차량기지 알고리즘
//https://iamheesoo.github.io/blog/algo-boj1918
public class BJ_1918 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String input = st.nextToken();
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> orders = new HashMap<>();
        orders.put('(', 0);
        orders.put('+', 1);
        orders.put('-', 1);
        orders.put('*', 2);
        orders.put('/', 2);

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                switch (c) {
                    case ')':
                        while ('(' != stack.peek()) {
                            Character pop = stack.pop();
                            if (pop != '(') {
                                sb.append(pop);
                            }
                        }
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                        }
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    default:

                        while(!stack.isEmpty() && orders.get(stack.peek()) >= orders.get(c)){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                        break;
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }
}
