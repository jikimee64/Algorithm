package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12926

public class Caesar_Password_12926 {
    public static void main(String[] args) {
        Caesar_Password_Process process = new Caesar_Password_Process();
        process.play();
    }
}

class Caesar_Password_Process {
    public void play() {
        String s = "a B z";
        int n = 4;
        String result = solution(s, n);
        System.out.println("정답 : " + result);
    }

    //내방법
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(ch+n > 'z'){
                    answer += (char)(ch+n-26);
                }else{
                    answer += (char)(ch+n);
                }
            }else if(ch >= 'A' && ch <= 'Z'){
                if(ch+n > 'Z'){
                    answer += (char)(ch+n-26);
                }else{
                    answer += (char)(ch+n);
                }
            }else{
                answer += " ";
            }
            System.out.println("i answer : " + answer);
        }
        return answer;
    }

    //인터넷 방법
    public String solution2(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char start;
            if(ch != ' '){
                start = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char)(start + (ch+n-start)%26); //이 알고리즘이 잘 생각이 안날듯
            }
            answer += ch;
        }
        return answer;
    }

}

