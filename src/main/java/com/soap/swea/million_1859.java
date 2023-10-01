package com.soap.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class million_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();
            long sum = 0; //문제 조건에 따른 long 타입 사용

            //첫 번째 경우의 수 데이터 삽입
            for (int d = 0; d < n; d++) {
                list.add(Integer.valueOf(st.nextToken()));
            }

            //이익 계산(i : 파는 날, j = 사는 날)
            for (int i = n - 1; i >= 0; i--) {
                int j = i - 1;
                long temp = 0;
                while (j >= 0 && list.get(i) >= list.get(j)) { //현재 파는 날의 매매가가 크면
                    if (j < 0 || list.get(i) < list.get(j)) { //파는 날의 매매가보다 큰 매매가가 있으면 while문 탈출
                        break;
                    }
                    temp += list.get(i); //파는날의 매매가를 더해주고
                    temp -= list.get(j); //사는날의 매매가를 빼준다.
                    j--; //이전 날짜로 이동
                }
                sum += temp;
                i = j + 1; //파는 날 이동
            }
            //최종 이익 계산
            System.out.println("#" + (c + 1) + " " + sum);
        }

    }
}
