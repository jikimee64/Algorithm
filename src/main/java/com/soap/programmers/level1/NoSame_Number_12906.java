package main.java.com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class NoSame_Number_12906 {
    public static void main(String[] args) {
        NoSame_Number_Process process = new NoSame_Number_Process();
        process.play();
    }
}

class NoSame_Number_Process {
    public void play() {
        //int[] array = {4, 4, 4, 3, 3};
        int[] array = {1, 1, 3, 3, 0, 1, 1};
        int[] answer = solution(array);
        System.out.println("정답 : " + answer);
    }

    //일반 풀이
   /* public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                if (i == arr.length - 2) {
                    //마지막 중복값은 다음행이 없기 때문에 비교 불가 -> 따로 추가
                    list.add(arr[i + 1]);
                }
                continue;
            } else {
                list.add(arr[i]);
                if (i == arr.length - 2) {
                    //마지막 중복값은 다음행이 없기 때문에 비교 불가 -> 따로 추가
                    list.add(arr[i + 1]);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int k = 0; k < answer.length; k++) {
            answer[k] = list.get(k);
        }
        return answer;
    }*/

    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int preNum = 10;
        for(int num : arr){
            if(preNum != num){
                list.add(num);
            }
            preNum = num;
        }

        int[] answer = new int[list.size()];
        for (int k = 0; k < answer.length; k++) {
            answer[k] = list.get(k).intValue();
        }
        return answer;
    }

    //좋은 코드
}
