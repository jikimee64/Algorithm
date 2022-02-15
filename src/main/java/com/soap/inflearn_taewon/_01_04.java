package com.soap.inflearn_taewon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _01_04 {

    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        String[] arr = new String[size];
        for(int i = 0; i < size; i++){
            arr[i] = br.readLine();

        }
        //String[] arr = {"good", "Time", "Big"};
        solution(arr);
    }

    public static void solution(String[] str){
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            for(int i = s.length()-1; i >= 0; i--){
                sb.append(s.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    //StringBulder 이용
    public static void solution2(String[] str){
        List<String> answer = new ArrayList<>();
        for (String s : str) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }
        answer.forEach(System.out::println);
    }

    //직접 구현
    //끝에 있는 문자랑 앞에 있는 문자의 시작점부터 변경
    public static void solution3(String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
    }

}
