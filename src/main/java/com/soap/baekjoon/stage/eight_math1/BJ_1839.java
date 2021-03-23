package main.java.com.soap.baekjoon.stage.eight_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N kg을 배달해야 하는데, 3kg와 5kg 봉지가 있다. 봉지의 최소 개수를 배달하는 로직을 구현해라.
 */
public class BJ_1839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int init = Integer.parseInt(br.readLine());
        int three = 0;
        int five = 0;

        int N = init;
        while (true) { //주어진 N kg에서 가능한 5kg
            if (N < 5) {
                break;
            }
            N -= 5;
            five++;
        }

        boolean flag = false;
        int rest = N; //나머지
        while (true) {
            if (rest % 3 == 0) {
                three = rest / 3;
                break;
            } else if (rest >= init) { //rest가 처음 주어진 init보다 커지면 5kg와 3kg로 나눌 수 없음
                flag = true;
                break;
            }
            rest += 5;
            five--;
        }

        int result = 0;
        if (flag) {
            result = -1;
        } else {
            result = three + five;
        }

        System.out.println(result);

    }
}
