package com.soap.ndb.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDB_Part03_편집거리 {

    public static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = "0";
        A += br.readLine();

        String B = "0";
        B += br.readLine();

        d = new int[A.length()][B.length()];

        d[0][0] = 0;

        //초기화
        for (int i = 1; i < d.length; i++) {
            d[i][0] = i;
        }

        for (int i = 1; i < d[0].length; i++) {
            d[0][i] = i;
        }

        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[i].length; j++) {

                if (A.charAt(i) == B.charAt(j)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.min(d[i][j - 1], Math.min(d[i - 1][j], d[i - 1][j - 1])) + 1;
                }

            }
        }

        System.out.println(d[A.length() - 1][B.length() - 1]);

    }
}
