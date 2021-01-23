package com.soap.bocho.Queue_Stack.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17952
public class BJ_17952 {
    public static void main(String[] args) throws IOException {

        Stack<Task> stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            if (Integer.parseInt(st.nextToken()) == 1) {
                Task task = new Task(count += 1, Integer.parseInt(st.nextToken()));
                int time = Integer.parseInt(st.nextToken());

                if (time == 1) {
                    result += task.getScore();
                } else {
                    task.setTime(time - 1);
                    stack.add(task);
                }

            } else if (!stack.isEmpty()) {
                Task pop = stack.pop();
                int time = pop.getTime() - 1;

                if (time == 0) {
                    result += pop.getScore();
                } else {
                    pop.time -= 1;
                    stack.add(pop);
                }
            }
        }
        System.out.println(result);

    }
}

class Task {
    int key;
    int score;
    int time;

    public Task(int key, int score) {
        this.key = key;
        this.score = score;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}