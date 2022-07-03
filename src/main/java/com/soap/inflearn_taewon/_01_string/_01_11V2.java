package com.soap.inflearn_taewon._01_string;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _01_11V2 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {
        String answer = "";
        sentence = sentence + " ";
        int cnt = 1;

        for(int i = 0; i < sentence.length() - 1; i++){
            if(sentence.charAt(i) == sentence.charAt(i+1)){
                cnt++;
            }else{
                answer += sentence.charAt(i);
                if(cnt > 1){
                    answer += cnt;
                }
                cnt = 1;
            }
        }

        System.out.println(answer);

    }
}
