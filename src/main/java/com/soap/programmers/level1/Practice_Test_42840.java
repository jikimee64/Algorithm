package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.ArrayList;
import java.util.List;

public class Practice_Test_42840 {
    public static void main(String[] args) {
        Practice_Test_Process process = new Practice_Test_Process();
        process.play();
    }
}

class Practice_Test_Process {
    public void play() {
        int[] array = {1, 3, 2, 4, 2};
        //int[] array = {1, 2, 3, 4, 5};
        int[] answer = solution(array);
    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5}; //이만큼씩 반복
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                score[0]++;
            }
            if (answers[i] == person2[i % person2.length]) {
                score[1]++;
            }
            if (answers[i] == person3[i % person3.length]) {
                score[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int maxScore = Math.max(Math.max(score[0], score[1]), score[2]);

        if (maxScore == score[0]) {
            list.add(1);
        }
        if (maxScore == score[1]) {
            list.add(2);
        }
        if (maxScore == score[2]) {
            list.add(3);
        }

        answer = new int[list.size()];

        for(int j = 0; j < answer.length; j++){
            answer[j] =  list.get(j);
        }
        return answer;
    }
}
