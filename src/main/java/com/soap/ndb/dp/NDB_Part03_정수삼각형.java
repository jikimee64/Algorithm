package main.java.com.soap.ndb.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1932
public class NDB_Part03_정수삼각형 {

    public static int[][] tri;
    public static int[][] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        tri = new int[N][N];
        d = new int[N][N];

        //값 삽입
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        d[0][0] = tri[0][0];
        for(int i = 1; i < tri.length; i++){
            int end = tri[i].length;
            for(int j = 0; j < end; j++){
                if(j == 0){//처음
                    d[i][j] = d[i-1][j] + tri[i][j];
                }else if(j == end-1){//끝
                    d[i][j] = d[i-1][j-1] + tri[i][j];
                }else{//중간
                    d[i][j] = Math.max(d[i-1][j-1] + tri[i][j],
                            d[i-1][j] + tri[i][j]);
                }
            }
        }

        for(int i = 0; i < d[N-1].length; i++){
            answer = Math.max(answer, d[N-1][i]);
        }

        System.out.println(answer);

    }
}
