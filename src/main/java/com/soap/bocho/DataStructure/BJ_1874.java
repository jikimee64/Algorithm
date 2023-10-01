package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1874
public class BJ_1874 {

    private static final Integer[] constants = {
            //4,3,6,8,7,5,2,1
            //1,2,5,3,4
            4,2,3,1,5
        };

    public static void main(String[] args) throws IOException {


        List<Integer> inputs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        for(int i = 0; i < size; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st2.nextToken());
            inputs.add(num);
        }

//        for(int j = 0; j < constants.length; j++){
//            inputs.add(constants[j]);
//        }

        int count = 1;
        int index = 0;
        int number = 1;
        stack.push(number);
        sb.append("+" + "\n");
        while(true){

            if(count >= inputs.size() * 2){
                break;
            }

            Integer num = inputs.get(index);

            if(stack.isEmpty()){
                number++;
                stack.push(number);
                sb.append("+" + "\n");
                count++;
            }
            else if(!Objects.equals(stack.peek(), num)){
                number++;
                stack.push(number);
                sb.append("+" + "\n");
                count++;
            }else{
                stack.pop();
                index++;
                sb.append("-" + "\n");
                count++;
            }
        }

        if(stack.isEmpty()){
            bw.write(sb.toString());
        }else{
            bw.write("NO");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}