package main.java.com.soap.ndb.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14501
public class NDB_Part03_퇴사 {

    public static List<Resign> list = new ArrayList<>();
    public static int[] d = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //0 제외
        list.add(new Resign(0, 0));

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Resign r = new Resign(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(r);
        }

        //뒤쪽 날짜부터 거꾸로 확인하는 방식
        int end = list.size() - 1;
        for (int i = end; i >= 1; i--) {
            int t = list.get(i).getT();
            int p = list.get(i).getP();

            int next = i + t;
            if (next > N + 1) { //상담 불가
                d[i] = d[i + 1];
            } else { //상담시간이 1일인 경우 else문을 탐
                d[i] = Math.max(d[i + 1], d[next] + p);
            }
        }

        System.out.println(d[1]);


    }
}

class Resign {
    private int t;
    private int p;

    public Resign(int t, int p) {
        this.t = t;
        this.p = p;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}