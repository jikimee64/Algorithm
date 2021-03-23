package main.java.com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12930

public class Strange_Char_12930 {
    public static void main(String[] args) {
        Strange_Char_Process process = new Strange_Char_Process();
        process.play();
    }
}

class Strange_Char_Process {
    public void play() {
        String s = "try hello world";
        String result = solution(s);
        System.out.println("정답 : " + result);
    }

    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                answer += " ";
                cnt = 0;
            } else {
                if (cnt % 2 == 0) { //짝수 -> 대문자
                    cnt++;
                    answer += arr[i].toUpperCase();
                } else { //홀수 -> 소문자
                    cnt++;
                    answer += arr[i].toLowerCase();
                }
            }
        }
        return answer;
    }

}


