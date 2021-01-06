package com.soap.ndb.greedy;

//https://programmers.co.kr/learn/courses/30/lessons/42891
public class NDB_Part03_06_무지의먹방라이브 {
    public static void main(String[] args) {
        int answer = solution(new int[]{3, 1, 2}, 5);
        System.out.println(answer);
    }

    //포기
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        int count = 0;
        int sec = 0;
        boolean flag = true;
        while (true) {
            if (count >= food_times.length) {
                count = 0;
            }

            //멈추기전에 다 먹었으면 -1반환
            for (int i = 0; i < food_times.length; i++) {
                if (food_times[i] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                answer = -1;
                break;
            }


            if (sec == k) { //장애 발생
                //1. 모두 다 먹었다면 -1
                //2. count순서에서부터 0이 아닌 값 순서 찾기
                int temp = 0;
                for (int i = 0; i < food_times.length; i++) {
                    if (food_times[i] != 0) {
                        flag = false;
                        temp = i; //0이 아닌 먹어야될 인덱스
                    }
                }
                if (flag) { //flag가 true면 모두 0인것
                    answer = -1;
                    break;
                } else {
                    answer = temp;
                    break;
                }
                //answer = count+1;
                //break;
            }


            if (food_times[count] == 0) {
                while (true) {
                    if (count >= food_times.length) {
                        count = 0;
                    }
                    count++;
                    if (food_times[count] != 0) {
                        food_times[count]--;
                        break;
                    }
                }
            }

            food_times[count]--;
            sec++;
            count++;
        }
        return answer;
    }
}