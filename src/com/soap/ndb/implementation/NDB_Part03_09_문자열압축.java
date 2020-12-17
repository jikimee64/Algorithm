package com.soap.ndb.implementation;

/**
 * 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와
 * 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현
 *
 * Ex)
 * 1) ababcdcdababcdcd
 * - 1개 단위로 자르기
 * => a | b | a | b | c ....
 * - 2개 단위로 자르기
 * => ab | ab | cd | cd | ab | ab | cd | cd
 * =>   2ab       2cd       2ab       2cd
 * - 8개 단위로 자르기
 * => ababcdcd | ababcdcd
 *         2ababcdcd
 *
 * 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
 *
 * 제한 사항
 * - s의 길이는 1 이상 1,000 이하
 * - s는 알파벳 소문자로만 이루어져 있음
 */

//참고 : https://lkhlkh23.tistory.com/153
//https://woongsin94.tistory.com/419
//https://regularmember.tistory.com/154 :  result += (processHit(hit) + next); 해결
public class NDB_Part03_09_문자열압축 {
    public static void main(String[] args) {
        int answer = solution("ababcdcdababcdcd");
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
            //System.out.println(i + "단위로 자른 결과 : " + result + "크기 : " + result.length());
            result += (processHit(hit) + next);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }

    static String processHit(int hit) {
        return hit > 1 ? String.valueOf(hit) : "";
    }

}


