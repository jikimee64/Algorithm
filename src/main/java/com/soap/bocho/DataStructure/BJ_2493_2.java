package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//풀이 : https://www.acmicpc.net/board/view/32686
public class BJ_2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] stack = new int[N]; //위치
        int[] tower = new int[N]; //높이
        int top = -1;

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st2.nextToken());

            while (top >= 0) {
                if (tower[top] > num) {
                    sb.append(stack[top] + " ");
                    break;
                } else { //★★★
                    top--;
                }
            }

            if (top < 0) {
                sb.append("0" + " ");
            }

            stack[++top] = i;
            tower[top] = num;
        }

        System.out.println(sb.toString().trim());
    }
}