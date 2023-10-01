package com.soap.inflearn_taewon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01_06 {

    public static boolean[] alpha = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        solution(sentence);
    }

    //비효율적
    public static void solution(String sentence) {
        //List<String> list = new ArrayList<>(Arrays.asList(sentence.split("")));
        String[] list = sentence.split("");
        List<Integer> removeIndexs = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            char c = list[i].charAt(0);
            int c1 = c - 97;
            if(!alpha[c1]){
                alpha[c1] = true;
            }else{
                removeIndexs.add(i);
            }
        }

        for (Integer removeIndex : removeIndexs) {
            list[removeIndex] = "";
        }

        List<String> collect = Arrays.stream(list)
                .filter(value -> !"".equals(value))
                .collect(Collectors.toList());
        collect.forEach(value -> System.out.print(value));
    }

    public static void solution2(String sentence) {
        String answer="";
        for(int i=0; i<sentence.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(sentence.indexOf(sentence.charAt(i))==i) answer+=sentence.charAt(i);
        }
        System.out.println(answer);
    }

}
