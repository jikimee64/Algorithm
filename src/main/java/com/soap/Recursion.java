package com.soap;

public class Recursion {
    public static void main(String[] args) {
        recur(1);
    }

    public static void recur(int i){
        if(i == 100) return;
        System.out.println("나는 재귀 " + i + "번째 재귀");
        recur(i+1);
    }

}
