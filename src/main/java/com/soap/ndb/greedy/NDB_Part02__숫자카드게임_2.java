package com.soap.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NDB_Part02__숫자카드게임_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = size[0]; //행
        int m = size[1]; //열

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < m; j++){
                if(min > row[j]){
                    min = row[j];
                }
            }
            list.add(min);
        }

        Integer maxNumber = list.stream().mapToInt(x -> x).max().getAsInt();
        System.out.println(maxNumber);

    }
}