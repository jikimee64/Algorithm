package main.java.com.soap.baekjoon.stage.eight_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken()); //낮에 올라가는 높이
        int b = Integer.parseInt(st.nextToken()); //밤에 미끄러지는 높이
        int v = Integer.parseInt(st.nextToken()); //나무 높이
        int day = 0;


        if ((v - a) % (a - b) == 0) { //V에서 마지막 A가는 거리를 뺀 것이 하룻동안 이동한 거리로 딱 맞게 떨어진다면
            day = (v - a) / (a - b); //V - A를 A - B로 나누어 이동한 총 일수를 계산
        }else { //V에서 마지막 A가는 거리를 뺀 것이 하룻동안 이동한 거리로 딱 맞게 떨어진다면
            day = (v - a) / (a - b) + 1; //하루를 더 추가, 나머지가 남으니까 하루를 더 가야 한다.
        }

        day++; //마지막 A이동 횟수를 증가

        System.out.println(day);

    }
}
