package com.soap.baekjoon.Stage.six_function;

public class BJ_4673 {
    public static void main(String[] args) {

        boolean[] check = new boolean[10001]; //1부터 10000

        for (int i = 1; i < 10001; i++) {
            //int result = i;
        /*    int temp = i;
            while(temp != 0){
                //★각 자리수합 구하기!!
                //나는 일일이 10의자리 100의자리 등으로 함..
                result = result + (temp % 10); //첫 째 자리수
                temp = temp/10; //10을 나누어 첫 째 자리를 없앤다.
            }*/

            //함수 이용
            int result = d(i);
            if (result < 10001) {
                check[result] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) { //false인 인덱스만 출력
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }
}
