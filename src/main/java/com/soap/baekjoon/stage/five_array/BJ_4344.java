package main.java.com.soap.baekjoon.stage.five_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int[] arr;

        StringTokenizer st = null;
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); //학생 수
            arr = new int[N];

            double sum = 0; //성적 누적 합 변수

            //성적 입력
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val;
                sum += val;
            }

            double mean = (sum / N);
            double count = 0; //평균 넘는 학생 수 변수

            for(int z = 0; z < N; z++){
                if(arr[z] > mean){
                    count++;
                }
            }

            //%% = '%'
            System.out.printf("%.3f%%\n", (count/N)*100);

        }
    }
}
