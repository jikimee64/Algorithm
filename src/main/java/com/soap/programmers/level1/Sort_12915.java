package main.java.com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;

public class Sort_12915 {
    public static void main(String[] args) {
        Sort_12915_Process process = new Sort_12915_Process();
        process.play();
    }
}

class Sort_12915_Process {
    public void play() {
        String[] array = {"sun", "bed", "car"};
        //int[] array = {1, 2, 3, 4, 5};
        String[] answer = solution(array, 1);
    }

    public String[] solution(String[] strings, int n) {
        //String[] answer = {};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) == s2.charAt(n)){
                    return s1.compareTo(s2);
                }else{
                    return s1.charAt(n) - s2.charAt(n);
                }
            }
        });

        return strings;
    }
}
