package com.soap;

import java.io.*;
import java.util.StringTokenizer;

public class TemplateSource {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution(st.nextToken());
    }

    public static void solution(String sentence) {

    }

}