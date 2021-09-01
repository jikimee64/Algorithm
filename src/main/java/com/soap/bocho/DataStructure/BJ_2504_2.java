package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2504
//틀림
public class BJ_2504_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] split = st.nextToken().split("");
        int answer = 0;

        int temp = 1; //중간값
        name : for (int i = 0; i < split.length; i++) {
            String text = split[i];

            switch (text){
                case "(" :
                    stack.push(text);
                    temp *= 2;
                    break;
                case "[" :
                    stack.push(text);
                    temp *= 3;
                    break;
                case ")" :
                    if(stack.isEmpty() || !stack.peek().equals("(")){
                        answer = 0;
                        break name;
                    }
                    if(split[i - 1].equals("(")){
                        answer += temp;
                    }
                    temp /= 2;
                    stack.pop();
                    break;
                case "]" :
                    if(stack.isEmpty() || !stack.peek().equals("[")){
                        answer = 0;
                        break name;
                    }
                    if(split[i - 1].equals("[")){
                        answer += temp;
                    }
                    temp /= 3;
                    stack.pop();
                    break;
            }
        }
        System.out.println(answer);
    }
}