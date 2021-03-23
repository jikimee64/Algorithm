package main.java.com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

import java.util.*;

public class K_Number_42748 {
    public static void main(String[] args) {
        K_Number_Process process = new K_Number_Process();
        process.play();
    }
}

class K_Number_Process {
    public void play() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2,5,3},{4,4,1},{1,7,3}
        };
        int[] answer = solution(array, commands);
        System.out.println("정답 : " + answer.toString());
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] temp = {};
            temp = Arrays.copyOfRange(array,commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}
