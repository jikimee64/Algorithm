package com.soap.programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

import java.util.HashMap;

public class phoneBook_42577 {
    public static void main(String[] args) {
        phoneBook_42577_Process process = new phoneBook_42577_Process();
        process.play();
    }
}

class phoneBook_42577_Process {
    public void play() {
        boolean result = solution(new String[]{"12", "123", "1235", "567"});
        System.out.println("정답 : " + result);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<Integer, String> map = new HashMap();
        int count = 0;
        for(String arg : phone_book){
            map.put(count, arg);
            count++;
        }
        outer : for(Integer key : map.keySet()) {
            String first = map.get(key);
            for(int i=0; i<phone_book.length; i++){
                if(key == i){
                    continue;
                }else if(first.startsWith(phone_book[i])){
                    answer = false;
                    break outer;
                }
            }
        }
        return answer;
    }

}
