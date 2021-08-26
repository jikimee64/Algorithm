package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/1935
public class BJ_1935 {

    private static List<String> operators = Arrays.asList("+", "-", "*", "/");
    private static List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<String> inputs = Arrays.asList(st2.nextToken().split(""));

        List<Integer> inputNumbers = new ArrayList<>();
        for(int i = 0; i < size; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            inputNumbers.add(Integer.parseInt(st3.nextToken()));
        }


        List<String> alphabet = inputs.stream()
                .filter(input -> !operators.contains(input))
                .sorted()
                .collect(Collectors.toList());

        Stack<Double> joined = new Stack<>();

        boolean flag = false;

        int index = 0;
        for (String input : inputs) {
            if(alphabet.contains(input)){
                Integer integer = inputNumbers.get(index);
                if(index < size - 1){
                    index++;
                }
                joined.push(Double.valueOf(integer));
            }else{
                Double next = joined.pop();
                Double prev = joined.pop();
                switch (input) {
                    case "+":
                        joined.push(prev + next);
                        break;
                    case "-":
                        joined.push(prev - next);
                        break;
                    case "*":
                        joined.push(prev * next);
                        break;
                    case "/":
                        joined.push(prev / next);
                        break;
                }
            }
        }
        Double answer = joined.pop();
        System.out.println(answer);
        System.out.println(Math.round((answer) * 100) / 100.0);
    }
}
