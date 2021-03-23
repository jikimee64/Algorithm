package main.java.com.soap.baekjoon.stage.two_if;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_2884 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");

        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());

        //내코드
        /*y -= 45;
        if (x != 0) { //x가 0이 아닐때
            if (y < 0) { //입력받은 y에서 45분 뺀값이 음수면 x에서 -1,분 수정
                x -= 1;
                y += 60;
            }
        } else { //x == 0일때
            if (y == 0) { //0 45
                x = 0;
                y = 0;
            } else if(y < 0){ //0 20
                x = 23;
                y += 60;
            }
            //0 50
        }*/

        //인터넷 찾은 코드
        y -= 45;
        if(y<0){ //첫번째 if문 기준을 분으로 잡음
            if(x!=0){
                x -= 1;
                y += 60;
            }else{
                x = 23;
                y += 60;
            }
        }

        System.out.println(x + " " + y);



    }
}
