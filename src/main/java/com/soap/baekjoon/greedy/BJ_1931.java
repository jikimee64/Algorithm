package main.java.com.soap.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1931 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i <n ; i++) {
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }

        //2차원 배열 정렬
        //o1, o2 : 0번째 인덱스만 비교시 앞뒤 순서
        Arrays.sort(arr, (int[] o1, int[] o2) -> {
            if(o1[1] == o2[1]){
                //종료 시간이 같을경우엔 시작시간으로 정렬
                //compare : 좌변이 크면 1, 우변이 크면 -1, 같으면 0
                //보통 매개변수 순서가 o1, o2일시
                //o1을 좌변에 놓고 o2를 우변에 놓으면 오름차순
                //반대면 내림차순
                return Integer.compare(o1[0], o2[0]);
            }else{
                //종료시간으러 정렬
                return Integer.compare(o1[1], o2[1]);
            }
        });


        Arrays.sort(arr, (int[] start, int[] end) -> {
            if(start[1] == end[1]){
                return Integer.compare(start[0], end[0]);
            }else{
                return Integer.compare(start[1], end[1]);
            }
        });

        int end = -1;
        for(int i = 0; i < n; i++){
            if(arr[i][0] >= end) {
                end = arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}

/*참조
https://ramees.tistory.com/53 : 2차원 배열 Comparator
https://kim6394.tistory.com/67 : 문제설명 굿
*/