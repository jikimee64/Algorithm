package com.soap.inflearn_taewon_basic._07_dfs_bfs_basic;

public class _07_04 {

    public static long[] d = new long[100];

    public static long fibo(int x) {
        //종료 조건(1 혹은 2일 때 1을 반환)
        if (x == 1 || x == 2) {
            return 1;
        }

        //이미 계산한 적 있는 문제라면 그대로 반환
        if (d[x] != 0) {
            return d[x];
        }

        //아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 보관
        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

    public static void main(String[] args) {
        fibo(10);
        for (long l : d) {
            if (l > 0) {
                System.out.println(l);
            }
        }

//        for (int i = 1; i <= 100; i++) {
//            System.out.println(recurFibo(i));
//        }
    }

//    public static int recurFibo(int size) {
//        if (size <= 1) return size;
//        else {
//            return recurFibo(size - 1) + recurFibo(size - 2);
//        }
//    }

}
