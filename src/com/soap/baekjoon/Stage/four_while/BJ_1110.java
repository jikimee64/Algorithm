package com.soap.baekjoon.Stage.four_while;

import java.io.*;

public class BJ_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int temp = num;
        int result = 0;

      /*  int a = 0;
        int b = 0;
s
        while (true) {
            //내방법
          /*  if (temp < 10) {
                a = 0;
                b = temp % 10;
            } else {
                a = temp / 10;
                b = temp % 10;
            }

            if (a + b >= 10) {
                temp = b * 10 + ((a + b) % 10);
            } else {
                temp = b * 10 + (a + b);
            }

            result++;
            */

            //효율적인 방법
            //마지막에 %10을 해준건 두수의 합이 10이상일때를 고려한것
        while(true){
            num = ( (num%10)*10 + (num/10 + num%10)%10 );

            if (temp == num) {
                break;
            }


        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}

//https://st-lab.tistory.com/42