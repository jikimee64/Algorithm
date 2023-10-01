package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/42862

public class Greedy_42862 {
    public static void main(String[] args) {
        Greedy_Process process = new Greedy_Process();
        process.play();
    }
}

class Greedy_Process {
    public void play() {
        int n = 3; //전체 학생 수
        int[] lost = {3}; //체육복을 도난당한 학생들의 번호
        int[] reserve = {1}; //여벌의 체육복을 가져온 학생들의 번호
        int result = solution(n, lost, reserve); //체육 수업을 들을 수 있는 학생의 최댓값
        System.out.println("result : " + result);
    }

    //포기
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        //여벌 옷을 가지고 있는 학생이 도난 당하면 빌려줄 수 없도록 만든다.
        //-1은 임의의 수
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i]==reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //옷을 빌려주고 -1로 만들어 뒤의 학생에게 빌려주지 않게 한다.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}


