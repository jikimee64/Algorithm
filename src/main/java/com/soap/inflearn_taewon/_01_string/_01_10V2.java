package com.soap.inflearn_taewon._01_string;

import java.io.*;
import java.util.StringTokenizer;

public class _01_10V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String t = st.nextToken();
        solution(s, t);
    }

    public static void solution(String s, String t) {
        int length = s.length();
        int[] answer  = new int[length];
        int p = 1000;

        //1001 0 1 2 3 0 1 2 3 4 0
        //왼쪽 탐색
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)){
                p = 0;
                answer[i] = p;
            }else{
                p++;
                answer[i] = p;
            }
        }

        //1 0 3 2 1 0 4 3 2 1 0
        //오른쪽 탐색
        p = 1000;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == t.charAt(0)){
                p = 0;
            }else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

}
