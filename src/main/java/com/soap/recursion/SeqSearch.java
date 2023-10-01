package com.soap.recursion;

/**
 * 순차탐색을 재귀적으로 하시오.
 */
public class SeqSearch {

    public static void main(String[] args) {

    }

    //검색 구간의 지점을 명시적으로 정의, 앞에서부터 순차적으로 찾음
    int search(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else {
            if (data[begin] == target) {
                return begin;
            }
            return search(data, begin + 1, end, target);
        }
    }
}
