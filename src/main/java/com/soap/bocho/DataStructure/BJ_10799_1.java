package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//시간초과
//문제를 1차원적으로 접근함
//BJ_10799_2에서 다른방법으로 풀이
//https://www.acmicpc.net/problem/10799
public class BJ_10799_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> inputs = Arrays.asList(st.nextToken().split(""));

        for (String input : inputs) {
            String prev = "";
            if(!stack.isEmpty()){
                prev = stack.peek();
            }

            String now = stack.push(input);

            if("(".equals(prev) && ")".equals(now)){
                stack.pop();
                stack.pop();
                stack.push("0");
            }else if("0".equals(prev) && ")".equals(now)){
                int count = 0;
                while(!"(".equals(stack.peek())){
                    String pop = stack.pop();
                    if("0".equals(pop)){
                        count++;
                    }
                }
                answer += count + 1;
                stack.pop();

                for(int i = 0; i < count; i++){
                    stack.push("0");
                }
            }
        }

        System.out.println(answer);

    }
}
