package main.java.com.soap.bocho.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int answer = 0;

        for(int i = 1; i <= 100_000_000; i++){
            if(N == count){
                answer = i-1;
                break;
            }
            if(String.valueOf(i).contains("666")){
                count += 1;
            }
        }

        System.out.println(answer);

    }
}
