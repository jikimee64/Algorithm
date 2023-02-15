package com.soap.recursion;

/**
 * 데이터가 크기순으로 정렬되어 있을때 검색 가능
 * String이라 가정, compareTo 메소드 사용
 */
public class binarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(String[] items, String target, int begin, int end){
        if(begin > end){
            return -1;
        }
        int middle = (begin + end) / 2;
        int result = target.compareTo(items[middle]);
        if(result == 0){
            return middle;
        }else if(result < 0){
            return binarySearch(items, target, begin, middle - 1);
        }else{
            return binarySearch(items, target, middle + 1, end);
        }
    }

}
