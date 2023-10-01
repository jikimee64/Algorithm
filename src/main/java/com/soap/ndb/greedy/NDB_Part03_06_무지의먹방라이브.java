package com.soap.ndb.greedy;

import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42891
public class NDB_Part03_06_무지의먹방라이브 {

    public static void main(String[] args) {
        long answer = solution(new int[]{4, 2, 3, 6, 7, 1, 5, 8}, 16);
        System.out.println(answer);
    }

    public static long solution(int[] food_times, long k) {

        PriorityQueue<Food> pq = new PriorityQueue<>();
        int[] empty = new int[food_times.length];
        long answer = 0;

        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i, food_times[i]));
        }

        long K = 0; //먹방이 진행된 시간
        long T = 0; //(현 단계의 음식의 양 - 이전단계까지 줄어든 음식의 양) 의 누저값
        while (!pq.isEmpty()) {
            Food food = pq.peek();
            int stage = food.getStage(); //음식의 단계
            long count = food.getCount(); //음식의 양
            long size = pq.size(); //남은 음식의 종류 수
            count -= T;
            if (K + (count * size) > k) {
                break;
            }
            pq.poll();
            empty[stage] = 1; //다 먹은 음식의 단계에 1을 넣어준다.
            if (count == 0) {
                continue;
            }
            //(현 단계의 음식의 양 - 이전단계까지 줄어든 음식의 양) * 남은 음식의 종류 수(자기 포함)
            K += count * size;
            T += count;
        }

        if (pq.isEmpty()) {
            answer = -1;
            return answer;
        }
        int i = 0;
        /**
         * (k 초가 되기 까지의 남은 시간) % 다먹지 않은 음식의 종류 수(큐의 사이즈)
         * (3,1,2) / 5일 때는 K = 5가되어 k - K = 0이 된다.
         * (2,2,2) / 4일 때는 K = 0이되어 k - K = 4가된다.
         * (4,2,3,6,7,1,5,8) / 16일 때는 K = 15가되어 k - K = 1이된다.
         */
        long time = (k - K) % pq.size() + 1;
        while (time != 0) {
            if (empty[i] == 0) { //1단계부터 조사해서 다먹은 음식을 찾으면(=0) time--;
                time--;
            }
            i++;
        }
        answer = i;
        return answer;
    }
}

class Food implements Comparable<Food> {

    int stage;
    int count;

    public Food(int stage, int count) {
        this.stage = stage;
        this.count = count;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Food o) { //음식의 양으로 오름차순 정렬
        return this.getCount() - o.getCount();
    }
}