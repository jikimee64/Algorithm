package com.soap.recursion;

public class MaxSearch {
    public static void main(String[] args) {

    }

    //base 케이스를 1개 이상이라 가정
    int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        }
        return Math.max(data[begin], findMax(data, begin + 1, end));
    }
}
