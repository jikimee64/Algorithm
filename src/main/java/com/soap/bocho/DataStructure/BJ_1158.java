package com.soap.bocho.DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1158
public class BJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList();

        //1부터 N까지 큐에 삽입
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        sb.append("<");
        int index = 1;
        //큐에서 하나씩 뽑은다음 세번째 숫자가 아니면 다시 큐에 집어넣는다.
        while(!q.isEmpty()){
            int num = q.poll();
            if(index != K){
                q.offer(num);
                index++;
            }else{
                if(q.size() == 0){
                    sb.append(num);
                }else{
                    sb.append(num+", ");
                    index = 1;
                }
            }
        }

        sb.append(">");
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}