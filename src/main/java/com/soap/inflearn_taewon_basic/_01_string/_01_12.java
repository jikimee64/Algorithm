package com.soap.inflearn_taewon_basic._01_string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _01_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer number = Integer.valueOf(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String sentence = st2.nextToken();
        if(number * 7 != sentence.length()){
            throw new IllegalArgumentException("개수맞춰서 입력부탁");
        }
        solution(number, sentence);
    }

    public static void solution(Integer number, String sentence) {

        List<String> list = new ArrayList<>();
        String answer = "";

        for(int i = 0; i < sentence.length(); i += 7){
            list.add(sentence.substring(i, i+7));
        }

        for (String s : list) {
            s = s.replace('#', '1');
            s = s.replace('*', '0');
            int integer = Integer.valueOf(s, 2);
            char temp = (char) integer;
            answer += String.valueOf(temp);
        }
        System.out.println(answer);
    }

    public static void solution2(Integer number, String sentence) {
        String answer = "";
        for(int i = 0; i < number; i++){
            String tmp = sentence.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            sentence = sentence.substring(7);
        }
        System.out.println(answer);
    }

}