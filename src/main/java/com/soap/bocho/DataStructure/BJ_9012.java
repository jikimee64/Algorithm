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
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            List<String> pars = Arrays.asList(st2.nextToken().split(""));

            if (pars.size() % 2 != 0) {
                sb.append(FAIL + "\n");
            } else {
                int size = pars.size() / 2;
                while (size-- > 0) {
                    boolean remove = pars.remove("()");
                    System.out.println(remove);
                }

                if(pars.size() == 0){
                    sb.append(SUCCESS + "\n");
                }else{
                    sb.append(FAIL + "\n");
                }
            }

//            int left = 0;
//            int right = 0;
//
//            stack.addAll(pars);
//
//            for (String str : stack) {
//                if ("(".equals(str)) {
//                    left++;
//                } else {
//                    right++;
//                }
//            }
//
//            if (left == right) {
//                for (int k = 0; k < stack.size(); k++) {
//                    String pop = stack.pop();
//                    if(pop.equals(")")){
//
//                    }
//
//                }
//                sb.append(SUCCESS + "\n");
//            } else {
//                sb.append(FAIL + "\n");
//            }

            bw.write(sb.toString());
            bw.flush();
            sb.delete(0, sb.length());
//            left = 0;
//            right = 0;
            stack.clear();
        }

        br.close();
        bw.close();
    }
}