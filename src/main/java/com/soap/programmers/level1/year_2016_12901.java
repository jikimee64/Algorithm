package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12901

public class year_2016_12901 {
    public static void main(String[] args) {
        year_2016_Process process = new year_2016_Process();
        process.play();
    }
}

class year_2016_Process {
    public void play() {
        String result = solution(5, 24);
        System.out.println("정답 : " + result);
    }

    public String solution(int a, int b) {
        int total = 0;
        String arr[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int mon[] = {31, 29, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
        String answer = "";

        for(int i = 0; i < a-1; i++){
            total += mon[i];
        }
        total += b-1; //arr의 인덱스는 0으로 시작하기 때문에 1을 빼줘야 함
        answer = arr[total%7];
        return answer;
    }

}
