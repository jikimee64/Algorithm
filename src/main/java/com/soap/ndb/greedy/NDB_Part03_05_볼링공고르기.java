package main.java.com.soap.ndb.greedy;

import java.util.*;

/**
 * 생각할 조건 - 서로 무게가 다른 볼링공을 고르려고 한다.
 *            - 볼링공의 무게가 1부터 10까지만 존재 한다.
 */
public class NDB_Part03_05_볼링공고르기 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(in.nextLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //볼링공의 개수
        int m = Integer.parseInt(st.nextToken()); //공의 최대 무게
        int count = 0; //볼링공 조합을 고를 수 있는 총 개수(방법1)

        int[] ballList = new int[n];

        for (int i = 0; i < n; i++) {
            ballList[i] = in.nextInt();
        }

        //방법1 : 모든 조합의 수를 이중 for문으로 확인
        /*for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ballList[i] != ballList[j]) { //무게가 같지 않은 경우 count++
                    count++;
                }
            }
        }
        System.out.println(count);*/

        //방법2
       /*
        Map<Integer, Integer> map = new HashMap();
        int total = n * (n - 1) / 2; //주어진 볼링공의 개수(n)중 두개를 고르는 총 수
        int minus = 0; //같은 무게의 개수에 따른 조합의 수를 담을 변수

        공의 무게 : 개수
          Ex) 1 3 2 3 2
          <1,1> <2,2>,<3,2>
        for (int i = 0; i < ballList.length; i++) {
            map.put(ballList[i], map.getOrDefault(ballList[i], 0) + 1);
            //찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
        }

        for (Integer integer : map.keySet()) { //키값만 추출
            int value = map.get(integer);
            if (value >= 2) { //만약 키의 value가 2이상이면 중복
                minus += value * (value - 1) / 2;
                // value의 값만큼 개수에서 두개의 조합으로 선택할 수 있는 개수를 구함
            }
        }
         //주어진 n중 두개를 고르는 총 수 - 2개의 조합으로 중복된 볼링공을 선택하는 수
         System.out.println(total - minus);
        */

        //나동빈 방법
        //1부터 10까지의 무게를 담을 수 있는 배열
        int[] arr = new int[11]; //인덱스0 사용 X

        //공의 무게에 따른 개수
        //Ex)1번째 인덱스의 값이 2이면 1의 무게는 2개
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            arr[x] += 1;
        }

        /**
         * 무게가 1인 볼링공 : 1개
         * 무게가 2인 볼링공 : 2개
         * 무게가 3인 볼링공 : 2개
         *
         * A가 특정한 무게의 볼링공을 선택했을 떄, B가 선택하는 경우의 수 차례대로 계산
         *
         * A가 무게가 1인 공을 선택할 때의 경우의 수
         * 1(무게가 1인 공의 개수) X 4(B가 선택하는 경우의 수) = 4가지
         *
         * A가 무게가 2인 공을 선택할 때의 경우의 수
         * 2(무게가 2인 공의 개수) X 2(B가 선택하는 경우의 수) = 4가지
         *
         * A가 무게가 3인 공을 선택할 때의 경우의 수
         * 2(무게가 3인 공의 개수) X 0(B가 선택하는 경우의 수) = 0가지
         *
         * 단계가 진행함에 따라 B가 선택하는 경우의 수는 줄어듬, 이미 계산했던 경우(조합)는 제외
         * (1,2) == (2,1)
         */

        // 1부터 m까지의 각 무게에 대하여 처리
        for (int i = 1; i <= m; i++) {
            //n은 볼링공의 개수
            n -= ballList[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외(
                              // 다시말하면 A가 선택하는 경우의수 제외
            count += ballList[i] * n; // (A가 선택하는 경우의 수) * (B가 선택하는 경우의 수)
                                      // 이전에 조합했던 경우의 수를 제외시켜야 되므로 n은 누적해서 빼줌
        }
        System.out.println(count);

    }
}
