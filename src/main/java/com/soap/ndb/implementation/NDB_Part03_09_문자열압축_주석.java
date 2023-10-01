package com.soap.ndb.implementation;

/**
 * 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와
 * 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현
 * <p>
 * Ex)
 * 1) ababcdcdababcdcd
 * - 1개 단위로 자르기
 * => a | b | a | b | c ....
 * - 2개 단위로 자르기
 * => ab | ab | cd | cd | ab | ab | cd | cd
 * =>   2ab       2cd       2ab       2cd
 * - 8개 단위로 자르기
 * => ababcdcd | ababcdcd
 * 2ababcdcd
 * <p>
 * 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
 * <p>
 * 제한 사항
 * 1) s의 길이는 1 이상 1,000 이하
 * 2) s는 알파벳 소문자로만 이루어져 있음
 * 3) 문자가 반복되지 않아 한 번만 나타난 경우 1은 생략
 */

public class NDB_Part03_09_문자열압축_주석 {
    public static void main(String[] args) {
        int answer = solution("ababcdcdababcdcd");
        System.out.println("정답 : " + answer);
    }

    public static int solution(String s) {

        if (s.length() == 1) return 1;
        int answer = 1001; //최솟값을 구하기 위한 변수, s는 1000이하 이기 때문에 1001로 초기화

        //문자열 길이의 반이상 자르면 좌항, 우항의 개수가 맞지 않기 때문에 의미가 없음
        for (int i = 1; i <= s.length() / 2; i++) { //i개 단위로 자르는 for문
            String now = "";
            String next = "";
            StringBuilder compression = new StringBuilder(); //단위별 압축했을때 문자(열) 결과
            int count = 1; //연속된 문자(열) 개수 체크
            for (int j = 0; j <= s.length() / i; j++) {
                /**
                 * start, end
                 * 1) i = 1, j = 0,1,2,3,4..
                 * => start : 0,1,2,3,4..
                 * => end :   1,2,3,4,5...
                 * 1) i = 2, j = 0,1,2,3,4..
                 * => start : 0,2,4,6,8..
                 * => end :   2,4,6,8,10....
                 * 만약 end값이 문자열 길이보다 크다면 인덱스 에러가 발생하니 문자열최대 길이로 바꿔준다.
                 */
                int start = i * j;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                /**
                 * 2단위 기준
                 * now : "", next : "ab",
                 * now : "ab", next : "ab",
                 * now : "ab", next : "cd",
                 */
                now = next; //이전에 넣은 next 값을 now에 대입
                next = s.substring(start, end); //start 0부터 next에 대입
                if (now.equals(next)) { //전과 같다면 count++
                    count++;
                } else { //전과 다르면 count와 문자열을 합친뒤 count = 1로 초기화
                    compression.append(processNum(count)).append(now);
                    count = 1;
                }
            }
            //System.out.println(i + "단위로 자른 결과 : " + compression + "크기 : " + compression.length());
            /**
             * i개로 나누어 떨어지지 않고 남은 부분은 마지막에 추가적으로 붙여줌.
             * Ex) aabbaccc 3으로 나눌시 ( 8/3 = 2 )
             *     aab | baa | cc(for문의 조건에 의해 세지 않음)
             *     남은 cc 붙여줌
             */
            compression.append(processNum(count)).append(next);
            answer = Math.min(answer, compression.length());
        }
        return answer;

    }

    //숫자를 String으로 변환 후 리턴, 조건에 false일시 위의 제한사항 3에 의해 ""리턴
    static String processNum(int count) {
        return count > 1 ? String.valueOf(count) : "";
    }

}
