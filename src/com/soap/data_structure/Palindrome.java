package com.soap.data_structure;

//자바의 정석 4장 문제 15번
public class Palindrome {
    public static void main(String[] args) {
        int number = 12321;
        int tmp = number;

        int result = 0; //변수 number 거꾸로 변환해서 담을 변수
        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        if (number == result)
            System.out.println(number + "는 회문수 입니다.");
        else
            System.out.println(number + "는 회문수가 압니다");
    } // main
}
