package com.soap.inflearn_taewon_basic;

import java.util.HashMap;
import java.util.Scanner;

public class _04_04 {


    public static void main(String[] args) {
        _04_04 T = new _04_04();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.print(T.solution(a, b));
    }

    //a에서 b의 아나그램을 찾음
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        // 투포인트 알고리즘
        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) { // 키-값 쌍이 같고(순서는 상관없음) 개수도 같을때 true
                answer++;
            }
            //lt는 무조껀 있으니 get만 해도 됨
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);

            // 놓치지 마셈
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
        }

        return answer;
    }

}
