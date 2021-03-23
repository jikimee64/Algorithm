package main.java.com.soap.ndb.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//참조 : https://so0choi.github.io/2020/08/21/Algorithm/Greedy04/
public class NDB_Part03_04_만들수없는금액 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        while(st.hasMoreTokens()){
            arr[count] = Integer.parseInt(st.nextToken());
            count++;
        }

        Arrays.sort(arr); //오름차순 정렬

        /**
         * 1. price 금액은 1부터 시작하고 화폐 단위는 오름차순 정렬을 수행한다.
         * 2. 화폐단위를 순차적으로 검사하면서 만약 price보다 단위가 작을 경우 해당 price는 만들 수 있다.
         * 3. price를 만들 수 있을 경우, 다음 price은 해당 화폐단위를 더한 값으로 갱신한다.
         * 4. price보다 큰 값이 검사 단위로 주어질 경우 해당 price는 만들지 못한다고 판단되어 답으로 출력한다.
         * ★ 핵심은 price 이하의 값은 모두 만들 수 있다고 정의하는 것. 화폐 단위가 작은 동전부터 하나씩 확인하면서
         *   price를 증가시키고 가장 작은 price 값을 찾아가기 때문에 그리디 알고리즘으로 분류된다.
         *
         *   price = 1
         *   Ex1) 1 1 2 3 9
         *   1) 1 <= 1 //OK
         *   2) 1 <= 2 //OK
         *   3) 2 <= 3 //OK
         *   4) 3 <= 5 //OK
         *   5) 9 <= 8 //NO, 8이 정답
         *   => 7까지는 1,1,2,3 조합으로 만들 수 있음
         *
         *   Ex1) 3 5 7
         *   1) 3 <= 1 //NO, 1이 정답
         */
        int price = 1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= price){
                price += arr[i];
            }else{
                break;
            }
        }

        bw.write(price);
        bw.flush();
        bw.close();
    }
}
