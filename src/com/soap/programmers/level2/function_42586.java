package com.soap.programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

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

        int result[] = solution2(progresses, speeds);
        for(Integer temp : result){
            System.out.print(temp + " / ");
        }
    }

    //풀다 포기기
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


    //해답1 배열이용
    //https://kyeahen.github.io/algorithm/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-42586-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EB%B0%9C/
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] resultArr = new int[100];

        int day = 0;
        for(int i=0; i<progresses.length; i++){
            while(100 > progresses[i] + (day * speeds[i])) {
                day++;
            }

            resultArr[day]++;
        }
        return Arrays.stream(resultArr).filter(i -> i != 0).toArray();
    }

    //해답2 큐이용
    //https://taesan94.tistory.com/36
    public int[] solution3(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> periods = new LinkedList<>();

        //평균 소요기간
        for(int i=0; i< speeds.length; i++){
            int value = (100-progresses[i] / speeds[i]);
            if( (100-progresses[i]) % speeds[i] != 0)
                value++;
            periods.add(value);
        }

        List<Integer> result = new ArrayList<>();

        while( !periods.isEmpty()){
            int cnt = 1;
            int period = periods.poll();
            while( !periods.isEmpty() && period >= periods.peek()){
               periods.poll();
               cnt++;
            }
            result.add(cnt);
        }

        answer = new int[result.size()];

        for ( int i = 0 ; i < answer.length; i++ ) {
            answer[i] = result.get(i);
        }

        return answer;
    }

}

