package com.soap.baekjoon.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1924
public class BJ_1924 {

    public static String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        answer();
    }

    //https://bcp0109.tistory.com/35
    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int count = 0;

        //월만큼 다 더하기
        for(int i = 0; i < x; i++){
            count += month[i];
        }

        //일수 더하기
        count += y;

        System.out.println(day[count%7]);
    }

    public static void process() {

        String[] s = sc.nextLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int sumDays = 0;

        //1월 1일 = "MON"
        int i1 = x - 1;
        for (int j = 1; j <= i1; j++) {
            sumDays += checkDays(j);
        }
        sumDays += y - 1;

        int i2 = (sumDays % 7);
        String result = week[i2];
        System.out.print(result);
    }

    public static int checkDays(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 28;
        }
    }

}
