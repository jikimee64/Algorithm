package main.java.com.soap.ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDB_Part02_시각 {

    /* 특정한 시각 안에 '3'이 포함되어 있는지의 여부(나동빈)
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int z = 0; z < 60; z++) {
                    if (String.valueOf(z).contains("3") || String.valueOf(j).contains("3") || String.valueOf(i).contains("3")) {
                        result++;
                    }
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가(나동빈_
                    //if (check(i, j, k)) cnt++;
                }
            }
        }

        System.out.println(result);

    }
}
