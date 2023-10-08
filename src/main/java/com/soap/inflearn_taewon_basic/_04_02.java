package com.soap.inflearn_taewon_basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_02 {

    public static void main(String[] args) {
        _04_02 a0402 = new _04_02();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(a0402.solution(a, b));
    }

    public static String solution(String a, String b) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : b.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static String solution2(String a, String b) {
        String answer = "YES";
        int[] arr = new int[60];
        for (char x : a.toCharArray()) {
            arr[x - 65]++;
        }
        for (char x : b.toCharArray()) {
            arr[x - 65]--;
        }
        for (int i : arr) {
            if (i != 0) {
                answer = "NO";
                break;
            }
        }
        return answer;
    }

}
