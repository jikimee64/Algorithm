package com.soap.ndb.dp;

import java.util.Scanner;

//https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787315353&proxyReferer=https:%2F%2Fwww.google.com%2F : 원리 설명
public class NDB_Part02_1로만들기 {

    //d에 n을 1로 만들기 위한 최소 개수를 저장
   static int d[] = new int[30001];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        /**
         * 여기까지 했으면 최솟값으로 d[i]가 되어있을 것이다. 그런데 여기서 포인트는 더해주는 숫자가 +1이란 것이다.
         * 이는 즉 연산의 횟수를 더해주는 것으로 -1, /2, /3중 무엇을 하던 연산은 1번을 수행했기에 +1을 해주는 것이라고 보면 된다.
         */
        for (int i = 2; i <= x; i++) {
            //현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            //현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            //현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            //현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }
        System.out.println(d[x]);
    }
}

