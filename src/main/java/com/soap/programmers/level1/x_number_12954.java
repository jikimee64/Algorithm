package main.java.com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12954

public class x_number_12954 {
    public static void main(String[] args) {
        x_number_Process process = new x_number_Process();
        process.play();
    }
}

class x_number_Process {
    public void play() {
        long[] result = solution(0, 3);
        System.out.println("정답 : " + result);
    }

    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        long temp = x;
        for(int i = 0; i < n; i++){
            answer[i] = x += temp;
            x += temp;
        }
        return answer;
    }

}


