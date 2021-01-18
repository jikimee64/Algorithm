package com.soap.ndb.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NDB_Part03_고정점찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list);

        int start = 0;
        int end = list.size()-1;
        int result = -1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(list.get(mid) == mid){
                result = mid;
                break;
            }
            else if(list.get(mid) < mid){ //중간값이 인덱스(mid)보다 작다면 중간값 이후를 탐색
                start = mid + 1;
            }else { //중간값이 인덱스(mid)보다 크다면 중간값 이전을 탐색
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}


