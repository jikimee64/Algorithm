package com.soap.ndb.sort;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/42889
public class NDB_Part03_실패율 {
    public static void main(String[] args) {

//        int n = 5;
//        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};

        int n = 4;
        int[] arr = {4, 4, 4, 4, 4};

        int[] answer = solution(n, arr);

        for (int ans : answer) {
            System.out.println(ans + " ");
        }


    }

    public static int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        List<Stage> list = new ArrayList<>();
        int num = stages.length;
        for (int i = 1; i < N + 1; i++) {

            int now = 0;
            for (int stage : stages) {
                if (i == stage) {
                    now++;
                }
            }

            if (now == 0) {
                list.add(new Stage(i, 0));
            } else {
                list.add(new Stage(i, (double) now / num));
                num = num - now;
            }
        }

        Collections.sort(list);

        int[] answer = list.stream()
                .mapToInt(Stage::getNum)
                .toArray();

        return answer;

    }
}

class Stage implements Comparable<Stage> {

    private int num; // 고유번호
    private double failure; // 실패율

    public int getNum() {
        return num;
    }

    public Stage(int num, double failure) {
        this.num = num;
        this.failure = failure;
    }


    @Override
    public int compareTo(Stage o) {
        if (this.failure == o.failure) { //실패율이 같으면 스테이지 오름차순
            return this.num - o.num;
        } else { //실패율이 다르면 실패율 기준 내림차순
            /**
             * 일반적으로 정의되어있는 compareTo는
             *  this.failure > o.failure이면 1을 반환하여 오름차순 정렬이다.
             *  실패율에 대한 내림차순 정렬을 해주기 위해 -1을 반환
             */
            return this.failure > o.failure ? -1 : 1;
        }
    }
}
