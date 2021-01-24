package com.soap.bocho.Queue_Stack.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/42584
public class PRO_42584 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 2, 3, 1});
        //int[] solution = solution(new int[]{1, 2, 3, 2, 3});

        for (int a : solution) {
            System.out.print(a + " ");
        }

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            stack.add(prices[i]);
        }

        int size = prices.length;

        int index = size - 1;
        list.add(stack.pop());
        while (!stack.isEmpty()) {
            int count = 0;
            int num = stack.pop();

            for (int i = list.size()-1; i >= 0; i--) {
                if (list.get(i) < num) {
                    count = list.size()-i;
                    break;
                }else {
                    count = list.size()-i;
                }
            }
            list.add(num);
            answer[size - index] = count;
            index -= 1;
        }
        int[] answer2 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer2[i] = answer[prices.length - 1 - i];
        }
        return answer2;
    }

    //올바른 Stack 사용방법
    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < prices.length; i++){
            while(!stack.empty() && prices[stack.peek()] > prices[i]){
                int tmp = stack.pop();
                answer[tmp] = i - tmp;
            }
            stack.push(i);
        }

        while(!stack.empty()){
            int tmp = stack.pop();
            answer[tmp] = (prices.length - 1) - tmp;
        }
        return answer;
    }


}


