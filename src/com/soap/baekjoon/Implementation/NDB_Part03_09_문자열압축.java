package com.soap.baekjoon.Implementation;

//참고 : https://lkhlkh23.tistory.com/153
//https://woongsin94.tistory.com/419
//https://regularmember.tistory.com/154 :  result += (processHit(hit) + next); 해결
public class NDB_Part03_09_문자열압축 {
    public static void main(String[] args) {
        int answer = solution("aaaaa");
        System.out.println(answer);
    }


    public static int solution(String s) {
        if (s.length() == 1) return 1;

        int answer = 1001;
        for (int i = 1; i <= s.length() / 2; i++) {
            String now, next = "", result = "";
            int hit = 1;
            // j 기준 단위 0부터 length/i 단위까지
            // 나누어 떨어지지않을때 끝까지 계산해주려면 <=
            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                //s.length()는 값 넘을 시 보정=>마지막 남은값??
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                now = next;
                next = s.substring(start, end);

                if (now.equals(next)) {
                    hit++;
                } else {
                    result += (processHit(hit) + now);
                    hit = 1;
                }
            }
            /**
             * i개로 나누어 떨어지지 않고 남은 부분은 마지막에 추가적으로 붙여줌.
             */
            result += (processHit(hit) + next);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }

    static String processHit(int hit) {
        return hit > 1 ? String.valueOf(hit) : "";
    }

}


