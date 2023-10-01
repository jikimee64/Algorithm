package com.soap.inflearn_taewon._01_string;

import java.io.*;
import java.util.StringTokenizer;

public class _01_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String t = st.nextToken();
        solution(s, t);
    }

    public static void solution(String s, String t) {
        int[] lengths = new int[s.length()];
        int p = 1000;

        //왼쪽부터 탐색
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!String.valueOf(s.charAt(i)).equals(t)) {
                p += 1;
                lengths[i] = p;
            }else{
                p = 0;
                lengths[i] = p;
            }
        }
        p = 1000;
        //오른쪽부터 탐색
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!String.valueOf(s.charAt(i)).equals(t)) {
                p += 1;
//                if(lengths[i] > p){
//                    lengths[i] = p;
//                }
                lengths[i] = Math.min(lengths[i], p);
            }else{
                p = 0;
            }
        }

        for (int length : lengths) {
            System.out.print(length + " ");
        }

    }

}