package com.soap.inflearn_taewon_basic._02_array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _02_03 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    //1:가위, 2:바위, 3:보
    public static void solution(String sentence) throws IOException {
        int count = Integer.parseInt(sentence);

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < count; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < count; i++){
            b.add(Integer.parseInt(st2.nextToken()));
        }

        for(int i = 0; i < count; i++){
            Integer integer = a.get(i);
            Integer integer1 = b.get(i);

            int i1 = integer - integer1;
            if(i1 == 0){
                System.out.println("D");
            }else if(i1 == 1 || i1 == -2){
                System.out.println("A");
            }else if(i1 < 0 || i1 == 2){
                System.out.println("B");
            }
        }

    }

}