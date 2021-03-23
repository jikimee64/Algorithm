package main.java.com.soap.programmers.level1;

import java.util.*;
/*
 * 분류1 : 옵션 존재 O X
 * 분류2 : 옵션존재하지 않으면 알파벳으로 끊으면 됨
 *
 */

public class Dart_KaKao_17682 {
    public static void main(String[] args) {
        try {
            String sample = "1D10S0T";
            System.out.println(solution(sample));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //하다가 포기
    public static int solution(String dartResult) throws Exception {
        int answer = 0;
        HashMap<String, Integer> area = new HashMap<>();
        area.put("S", 1);
        area.put("D", 2);
        area.put("T", 3);

        HashMap<String, Integer> option = new HashMap<>();
        area.put("*", 2);
        area.put("#", -1);

//        char[] sample = new char[dartResult.length()];
//
//        //하나씩 삽입
//        for (int i = 0; i < sample.length; i++) {
//            sample[i] = dartResult.charAt(i);
//        }


        //옵션이 아무것도 포함되지 않을 경우
        if (!dartResult.contains("*") && !dartResult.contains("#")) {
            //숫자 제거 정규표현식
            String mu = dartResult.replaceAll("[0-9]", "");

            String str[] = dartResult.split("S|D|T");
            int x[] = new int[3];
            char y[] = new char[3];

            for (int i = 0; i < str.length; i++) {
                x[i] = Integer.parseInt(str[i]);
                y[i] = mu.charAt(i);
            }
            for (int i = 0; i < 3; i++) {
                answer += Math.pow(x[i], area.get(String.valueOf(y[i])));
            }
//            for (int i = 0; i < sample.length; i += 2) {
//                answer += Math.pow((sample[i] - '0'), area.get(String.valueOf(sample[i + 1])));
//            }

        } else {

            String num = dartResult.replaceAll("[^0-9]", "");
            String mu = dartResult.replaceAll("[0-9]", "");

            int x[] = new int[3];
            char y[] = new char[3];

            for (int i = 0; i < 3; i++) {
                x[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
                y[i] = mu.charAt(i);
            }

        }


        return answer;
    }

    public static int solution2(String dartResult) throws Exception {
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        int cnt = -1;

        for (int i = 0; i < darts.length; i++) {
            if (darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if (darts[i] == '1' && darts[i + 1] == '0') {
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }

            } else if (darts[i] == 'D') {
                score[cnt] *= score[cnt];
            } else if (darts[i] == 'T') {
                score[cnt] *= score[cnt] * score[cnt];
                ;
            } else if (darts[i] == '*') {
                if (cnt > 0) {
                    score[cnt - 1] *= 2;
                }
                score[cnt] *= 2;
            } else if (darts[i] == '#') {
                score[cnt] *= -1;
            }
        } //for
        return score[0] + score[1] + score[2];
    }

}
