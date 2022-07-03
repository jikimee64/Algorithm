package com.soap;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(recur(5));
        System.out.println(iter(5));
    }

    public static int recur(int n){
        if(n <= 1) return 1;
        return n * recur(n - 1);
    }

    public static int iter(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

}
