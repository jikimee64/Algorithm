package main.java.com.soap.ndb.greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class NDB_Part02_1이될때까지 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int count = 0;

        while (true) {
            if (n == 1) {
                break;
            } else if (n % k == 0) {
                n /= k;
                count++;
                continue;
            }
            n -= 1;
            count++;
        }
        System.out.println(count);
/*
        Scanner in = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int count = 0;

        while (true) {
            if (n == 1) {
                break;
            } else if (n % k == 0) {
                n /= k;
                count++;
                continue;
            }
            n -= 1;
            count++;

            System.out.println("ㅎㅇ");
        }


        System.out.println(count);*/

        //N이 100억 이상일 때 방법
        /*
            while (true) {
                // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
                int target = (n / k) * k;
                result += (n - target);
                n = target;
                System.out.println("초기 n : " + n);
                // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
                if (n < k){
                    break;
                }
                // K로 나누기
                result += 1;
                n /= k;
                System.out.println("n : " + n);
                System.out.println("result : " + result);
            }

            // 마지막으로 남은 수에 대하여 1씩 빼기
            ex) 만약 k가 6이면 n이 6미만일때 탈출, 만약 n이 4이면
            1이 될때까지 3을 빼야 되므로 (4 - 1) = 3을 result에 더해준다.
            result += (n - 1);
            System.out.println(result);
        */

    }

}
