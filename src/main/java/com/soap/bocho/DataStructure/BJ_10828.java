package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10828
public class BJ_10828 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = 0;
            while(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }
            switch (command){
                case "push":
                    list.add(num);
                    break;
                case "pop":
                    if(list.isEmpty()){
                        System.out.println("-1");
                    }else{
                        Integer remove = list.remove(list.size() - 1);
                        System.out.println(remove);
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if(list.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if(list.isEmpty()){
                        System.out.println("-1");
                    }else{
                        Integer integer = list.get(list.size() - 1);
                        System.out.println(integer);
                    }
                    break;
            }
        }
    }

}
