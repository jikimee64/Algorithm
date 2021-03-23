package main.java.com.soap.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2565
public class BJ_2565 {

    public static List<Line> list = new ArrayList<>();
    public static int[] d = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            Line line = new Line(left, right);
            list.add(line);
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(list.get(j).getRight() < list.get(i).getRight()){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        Set set = new HashSet();
        for(int i = 0; i < N; i++){
            set.add(d[i]);
        }

        System.out.println(N - set.size());

    }
}

class Line implements Comparable<Line>{
    private int left;
    private int right;

    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public int compareTo(Line o) {
        return this.getLeft() - o.getLeft();
    }
}