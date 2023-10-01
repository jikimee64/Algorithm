package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/18258
public class BJ_18258 {
    public static void main(String[] args) throws IOException {
        Queues queue = new Queues();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            String action = st2.nextToken();
            int num2 = 0;
            if ("push".equals(action)) {
                num2 = Integer.parseInt(st2.nextToken());
            }

            switch (action) {
                case "push":
                    queue.push(num2);
                    break;
                case "pop":
                    sb.append(queue.pop() + "\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    sb.append(queue.empty() + "\n");
                    break;
                case "front":
                    sb.append(queue.front() + "\n");
                    break;
                case "back":
                    sb.append(queue.back() + "\n");
                    break;
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Queues {

    Queue<Integer> q = new LinkedList();
    int rear = 0;

    public Queues() {
    }

    public void push(int num) {
        rear = num;
        q.add(num);
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public int empty() {
        if (q.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int front() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    public int back() {
        if (q.isEmpty()) {
            return -1;
        }
        return rear;
    }

}