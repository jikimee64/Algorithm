package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;

public class Player_42576 {
    public static void main(String[] args) {
        Player_Process process = new Player_Process();
        process.play();
    }
}

class Player_Process {
    public void play() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = solution(participant, completion);
        System.out.println("정답 : " + answer);
    }

    //해시 사용
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap();

        for(String arg : participant){
            map.put(arg, map.getOrDefault(arg, 0) + 1);
        }

        for(String arg : completion) {
            map.put(arg, map.get(arg) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) != 0){
                return key;
            }
        }
    return null;
    }

    //해시사용X
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        int i = 0;
//        for(i = 0; i < completion.length; i++){
//            if(!(participant[i].equals(completion[i]))){
//                return participant[i];
//            }
//        }
//        return participant[i];
//    }

}
