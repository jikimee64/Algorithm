package com.soap.baekjoon.Greedy;

import java.util.Scanner;

//정답봄
//이해안됨
public class NDB_Part03_03_문자열뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int count0 = 0; //전부 0으로 바꾸는 경우
        int count1 = 0; //전부 1로 바꾸는 경우

        // 첫 번째 원소에 대해서 처리
        if (str.charAt(0) == '1') {
            count0 += 1;
        }
        else {
            count1 += 1;
        }

        //연속된 숫자 체크
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(i+1)){
                if(str.charAt(i+1) == '1'){ // 0으로 가다가 다음 수에서 1로 바뀌는 경우
                    count0 += 1;
                }else{ // 1로 가다가 다음 수에서 0으로 바뀌는 경우
                    count1 += 1;
                }
            }
        }

        System.out.println(Math.min(count0, count1));

    }
}
