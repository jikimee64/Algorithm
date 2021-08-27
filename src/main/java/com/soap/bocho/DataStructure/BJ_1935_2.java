package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://blog.junu.dev/29
public class BJ_1935_2 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        String input = br.readLine();
        char key = 'A';
        for(int i = 0; i < N; i++){
            map.put(key, Integer.parseInt(br.readLine()));
            key++;
        }

        Stack<Double> stack = new Stack<>();

        for(char c : input.toCharArray()){
            if(Character.isAlphabetic(c)){
                stack.push(Double.valueOf(map.get(c)));
            }else{
                double temp = calculate(stack.pop(), stack.pop(), c);
                stack.push(temp);
            }
        }
        System.out.format("%.2f", stack.pop());
    }

    private static double calculate(Double num1, Double num2, char c){
        switch (c){
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return -1;
        }
    }
}
