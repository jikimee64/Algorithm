package com.soap.baekjoon.Greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_4796 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int result = 0;
        int a = 0;

        while (true) {
            int l = in.nextInt(); //l일만큼 사용
            int p = in.nextInt(); //연속하는 p일중
            int v = in.nextInt(); //휴가일수
            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            result += (v/p)*l;
            if(v%p > l){
                result += l;
            }else{
                result += (v%p);
            }

            System.out.println("Case "+ (++a) + ": " + result);

            result = 0;
        }

    }
}
