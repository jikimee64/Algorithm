package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2504
public class BJ_2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] split = st.nextToken().split("");
        int answer = 0;

        stack.push(split[0]);
        int i = 1;
        for(;i < split.length; i++){
            String text = split[i];


            //시작 괄호가 나오면 push
            if(text.equals("(") || text.equals("[")){
                stack.push(text);
                continue;
            }else{ //닫힌 괄호가 나올경우
                String pop = stack.pop();

//                if(stack.isEmpty()){
//                    answer = Integer.parseInt(pop);
//                    break;
//                }

                if(!pop.chars().allMatch( Character::isDigit )){
                    if(pop.equals("(") && text.equals("]")){
                        answer = 0;
                        break;
                    }

                    if(pop.equals("[") && text.equals(")")){
                        answer = 0;
                        break;
                    }

                    if(pop.equals("(") && text.equals(")")){
                        stack.push("2");
                    }

                    if(pop.equals("[") && text.equals("]")){
                        stack.push("3");
                    }
                }else{
                    stack.push(text);
                    int num = Integer.parseInt(pop);
                    String pop2 = stack.pop();

                    if(pop2.chars().allMatch( Character::isDigit )){
                        int i1 = (num + Integer.parseInt(pop2));
                        stack.push( String.valueOf(i1) );
                    }else{
                        if(pop2.equals("[")){
                            int i1 = 3 * num;
                            stack.push(String.valueOf(i1));
                        }else{
                            int i1 = 2 * num;
                            stack.push(String.valueOf(i1));
                        }
                    }
                }
            }

        }

        System.out.println(answer);

    }
}
