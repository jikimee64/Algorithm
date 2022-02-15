package com.soap.bocho.Greddy;

import java.util.Scanner;

//구현
public class BJ_14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while(n > 0){
            int i = n % 5;
            int i1 = n / 5;
            if(count == 0 && i == 0){
                count += i1;
                break;
            }

            if(count != 0 && i == 0){
                count += i1;
                break;
            }

            n -= 2;
            count++;
        }

        if(n < 0){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }

    }

}