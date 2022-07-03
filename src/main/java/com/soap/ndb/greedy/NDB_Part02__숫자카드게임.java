package main.java.com.soap.ndb.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NDB_Part02__숫자카드게임 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");
        List<StringTokenizer> list = new ArrayList<>();

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int answer = 0;

        int[][] arr = new int[n][m];

        //배열 입력
        for (int i = 0; i < arr.length; i++) {
            list.add(new StringTokenizer(in.nextLine(), " "));
        }

        //배열 삽입
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(list.get(i).nextToken());
            }
        }

        //가장 작은 수 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                answer = Math.min(arr[i][j - 1], arr[i][j]);
            }
        }

        //나동빈 : 각 줄마다 입력을 받아서 가장 작은 값 get,
        int result = 0;
        for (int i = 0; i < n; i++) {
            int minvalue = 100000;
            //현재 줄에서 '가장 작은 수 찾기'
            for (int j = 0; j < m; j++) {
                int min = in.nextInt();
                minvalue = Math.min(minvalue, min);
            }
            //'가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, minvalue);
        }

        System.out.println(answer);


    }
}
