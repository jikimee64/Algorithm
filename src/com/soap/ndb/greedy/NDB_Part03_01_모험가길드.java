package com.soap.ndb.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 여행을 떠날 수 있는 그룹 수의 최댓값
 * 생각할 조건 - 모든 모험가를 특정한 그룹에 넣을 필요가 없다.
 */
public class NDB_Part03_01_모험가길드 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int groupCount = 0; //총 그룹의 수

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr); //오름차순 정렬

        //최대한 많은 그룹이 만들어져야 하므로 작은 수부터 그룹 체크
        int count = 0; //현재 그룹에 포함된 모험자 수
        for (int i = 0; i < arr.length; i++) {
            count += 1;
            if(count >= arr[i]){  // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                groupCount += 1; // 총 그룹의 수 증가시키기
                count = 0;  // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }
        /**
         * 1 (그룹) // 2 2 (그룹) // 2 3
         */

        System.out.println(groupCount);

    }
}
