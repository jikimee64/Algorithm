package com.soap.ndb.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NDB_Part02_위에서아래로 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList();

        for(int i = 0; i < n; i++){
            list.add(in.nextInt());
        }

        Collections.sort(list,(o1, o2) -> o2.compareTo(o1));

        // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행(배열 사용시)
        //Arrays.sort(arr, Collections.reverseOrder());


        for(int i = 0; i < n; i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
