package com.soap.inflearn_taewon_basic._09_greedy_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int startTime;
    public int endTime;

    public Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Time param){
        if(this.endTime == param.endTime){
            return this.startTime - param.startTime;
        }
        return this.endTime - param.endTime;
    }
}

public class _09_02 {

    public int solution(List<Time> arr){
        int answer = 0;
        arr.sort(Time::compareTo);
        int endTime = 0;
        for(Time time : arr){
            if(time.startTime >= endTime){
                answer++;
                endTime = time.endTime;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _09_02 a0902 = new _09_02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(a0902.solution(arr));
    }

}
