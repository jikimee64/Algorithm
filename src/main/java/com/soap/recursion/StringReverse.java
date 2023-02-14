package com.soap.recursion;

/**
 * 재귀를 이용해 문자열을 뒤집어 프린트하시오.
 */
public class StringReverse {

    public static void main(String[] args) {
        String a = "abcde";
        printCharsReverse(a);
    }

    /**
     * 하나빼고 나머지를 뒤집는다
     */
    public static void printCharsReverse(String str) {
        if (str.length() == 0) {
            return;
        } else {
            printCharsReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

}
