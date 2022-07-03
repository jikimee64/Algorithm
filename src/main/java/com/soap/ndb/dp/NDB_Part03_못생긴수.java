package main.java.com.soap.ndb.dp;

import java.util.Scanner;

public class NDB_Part03_못생긴수 {

    static int n;
    static int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1;
        for (int l = 1; l < n; l++) {
            ugly[l] = Math.min(next2, Math.min(next3, next5));
            if (ugly[l] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[l] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[l] == next3) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }
    }
}
