package main.java.com.soap.ndb.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 파라메트릭 서치 유형의 문제
 * 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제에 주로 사용
 * 주로 재귀보다 반복문이 간결
 */

public class NDB_Part02_떡볶이떡만들기 {

    public static List<Integer> rice = new ArrayList<>();
    public static List<Integer> request = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //떡의 개수
        int M = Integer.parseInt(st.nextToken()); //요청한 떡의 길이
        int H = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rice.add(Integer.valueOf(st2.nextToken())); //떡의 개별 높이 추가
        }

        Collections.sort(rice);
        int start = 0;
        int end = rice.get(rice.size() - 1);

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < rice.size(); i++) {
                // 잘랐을 때의 떡의 양 계산
                if (rice.get(i) > mid) {
                    sum += rice.get(i) - mid;
                }
            }

            if (sum < M) {  // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            } else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                H = mid; //최대한 덜 잘랐을 때가 정답
                start = start + 1;
            }
        }
        System.out.println(H);

    }
}
