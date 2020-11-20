package com.soap.programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class function_42586 {
    public static void main(String[] args) {
        function_42586_Process process = new function_42586_Process();
        process.play();
    }
}

class function_42586_Process {
    public void play() {
        int progresses[] = {93, 30, 55};
        int speeds[] = {1,30,5};

        int result[] = solution(progresses, speeds);
        for(Integer temp : result){
            System.out.print(temp + " / ");
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        List<Integer> progressesArr = new ArrayList<>();
        List<Integer> speedsArr = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for(int i=0; i<progresses.length; i++){
            map.put(i, false);
        }

        for(Integer progres : progresses){
            progressesArr.add(progres);
        }

        for(Integer speed : speeds){
            speedsArr.add(speed);
        }

      /*  System.out.println(speedsArr.get(0));
        progressesArr.set(0, progressesArr.get(0) + speedsArr.get(0));
        System.out.println(progressesArr.get(0));*/

        int sum = 0;
        while(true){
           System.out.println(sum);

            if(sum >= progresses.length){
                break;
            }

            //조건값에 따른 순회 count
            for(int i=0; i<progressesArr.size(); i++){
                if(progressesArr.get(i) <= 100){
                    progressesArr.set(i, progressesArr.get(i) + speedsArr.get(i));
                }
            }

            int count=0;
            //배포체크
            for(int i=0; i<progressesArr.size(); i++){
                if(progressesArr.get(i)>=100){
                    map.put(i, true);
                }
            }
            if(count > 0){
                list.add(count);
                sum += count;
            }
            count = 0;
        }

        answer = new int[list.size()];
        for(int k=0; k<list.size(); k++){
            answer[k] = list.get(k);
        }

        return answer;
    }

}

