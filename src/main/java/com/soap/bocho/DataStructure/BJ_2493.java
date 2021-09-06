package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간 초과
public class BJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Top> stack = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int answer = 0;
            int num = Integer.parseInt(st2.nextToken());

            for (int j = stack.size() - 1; j >= 0; j--) {
                if (num <= stack.get(j).getNum()) {
                    answer = stack.get(j).getOrder();
                    break;
                }
            }

            stack.add(new Top(i, num));

            sb.append(answer + " ");
        }

        System.out.println(sb.toString().trim());
    }
}

class Top {
    int order;
    int num;

    public Top(int order, int num) {
        this.order = order;
        this.num = num;
    }

    public int getOrder() {
        return order;
    }

    public int getNum() {
        return num;
    }
}
