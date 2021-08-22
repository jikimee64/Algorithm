package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/10866
public class BJ_10866 {
    public static void main(String[] args) throws IOException {

        List<String> pushActions = Arrays.asList("push_back", "push_front");

        QueuesV2 queue = new QueuesV2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            String action = st2.nextToken();
            int num2 = 0;
            if (pushActions.contains(action)) {
                num2 = Integer.parseInt(st2.nextToken());
            }

            switch (action) {
                case "push_front":
                    queue.push_front(num2);
                    break;
                case "push_back":
                    queue.push_back(num2);
                    break;
                case "pop_front":
                    sb.append(queue.pop_front() + "\n");
                    break;
                case "pop_back":
                    sb.append(queue.pop_back() + "\n");
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


class QueuesV2 {

    Deque<Integer> q = new LinkedList<>();
    int rear = 0;

    public QueuesV2() {

    }

    public void push_front(int num) {
        rear = num;
        q.addFirst(num);
    }

    public void push_back(int num) {
        rear = num;
        q.addLast(num);
    }

    public int pop_front() {
        if (empty() == 1) {
            return -1;
        }
        return q.pollFirst();
    }

    public int pop_back() {
        if (empty() == 1) {
            return -1;
        }
        return q.pollLast();
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
        return q.peekFirst();
    }

    public int back() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekLast();
    }

}