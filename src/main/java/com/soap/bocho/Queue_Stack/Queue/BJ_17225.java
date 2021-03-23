package main.java.com.soap.bocho.Queue_Stack.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/17225
//https://moons-memo.tistory.com/112
public class BJ_17225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Order> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //상민이가 포장하는데 걸리는 시간
        int G = Integer.parseInt(st.nextToken()); //지수가 포장하는데 걸리는 시간
        int N = Integer.parseInt(st.nextToken()); //어제 가게 손님 수

        int t, c, num;
        int bMax = 0; //들어갈 위치값
        int aMax = 0; //들어갈 위치값
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st2.nextToken());
            c = st2.nextToken().charAt(0);
            num = Integer.parseInt(st2.nextToken());

            for (int j = 0; j < num; j++) {
                if (c == 'B') {
                    if (bMax >= t) {
                        pq.add(new Order(bMax, 'b'));
                        bMax += S;
                    } else { //S가 0이든 아니든 처음만 옴
                        pq.add(new Order(t, 'b'));
                        bMax = t + S; //S가 0일때 t가 그대로 bMax
                    }
                } else {
                    if (aMax >= t) {
                        pq.add(new Order(aMax, 'a'));
                        aMax += G;
                    } else { //G가 0이든 아니든 처음만 옴
                        pq.add(new Order(t, 'a'));
                        aMax = t + G; //G가 0일때 t가 그대로 aMax
                    }
                }
            }
        }
        ArrayList<Integer> blue = new ArrayList<>();
        ArrayList<Integer> red = new ArrayList<>();
        int idx = 1;
        while (!pq.isEmpty()) {
            Order order = pq.poll();
            if (order.color == 'a') {
                red.add(idx);
            } else {
                blue.add(idx);
            }
            idx++;
        }
        System.out.println(blue.size());
        for (int k : blue)
            System.out.print(k + " ");
        System.out.println();
        System.out.println(red.size());
        for (int k : red)
            System.out.print(k + " ");
        System.out.println();
    }
}

class Order implements Comparable<Order> {
    int startTime; //주문 시각
    char color; //선택한 포장지의 색깔

    public Order(int startTime, char color) {
        this.startTime = startTime;
        this.color = color;
    }

    @Override
    public int compareTo(Order o) {
        if (this.startTime == o.startTime) {
            return o.color - this.color; //R(들어온값) - B(기존값) = 양수 => 오름차순
        }
        return this.startTime - o.startTime;
    }
}