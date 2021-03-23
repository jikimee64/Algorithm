package main.java.com.soap.bocho.Queue_Stack.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2164
public class BJ_2164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Queue q = new LinkedList();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        while(true){
            if(q.size() <= 1){
                break;
            }
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.poll());

    }
}
