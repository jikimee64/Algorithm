package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/9012
public class BJ_9012 {

    private static String SUCCESS = "YES";
    private static String FAIL = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            List<String> pars = Arrays.asList(st2.nextToken().split(""));

            for (String par : pars) {
                if ("(".equals(par)) {
                    stack.add(par);
                } else if (stack.isEmpty()) {
                    sb.append(FAIL);
                    break;
                } else {
                    stack.pop();
                }
            }

            if (sb.length() == 0) {
                if (stack.isEmpty()) {
                    sb.append(SUCCESS);
                } else {
                    sb.append(FAIL);
                }
            }

            bw.write(sb.toString() + "\n");
            bw.flush();
            sb.delete(0, sb.length());
            stack.clear();
        }
        br.close();
        bw.close();
    }
}