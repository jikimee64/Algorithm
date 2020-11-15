package com.soap.programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/68644?language=java

import java.util.*;

public class TwoNumber_68664 {
    public static void main(String[] args) {
        TwoNumber_Process process = new TwoNumber_Process();
        process.play();
    }
}

class TwoNumber_Process {
    public void play() {
        int[] arr = new int[]{2, 1, 3, 4, 1};
        int[] result = solution(arr);
        System.out.println("정답");
        for (int num : result) {
            System.out.print(num + ", ");
        }
    }

    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;

        //내코드
//        for(int i=0; i<numbers.length; i++){
//            index = numbers[i];
//            for(int j=0; j<numbers.length; j++){
//                int temp = 0;
//                temp = index + numbers[j];
//                if(arrayList.contains(temp)) { //answer안에 있다면
//                    continue;
//                }else if(numbers[j] == index && i == j){
//                    continue;
//                }
//                arrayList.add(temp);
//            }
//        }

        //다른사람 풀이1
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int temp = numbers[i] + numbers[j];
                /*
                ArrayList.indexOf()
                indexOf(Object o)는 인자로 객체를 받는다.
                리스트의 앞쪽부터 인자와 동일한 객체가 있는지 찾으며,
                존재한다면 그 인덱스를 리턴. 존재하지 않는다면 -1을 리턴
                 */
                if (arrayList.indexOf(temp) < 0) {
                    arrayList.add(temp);
                }
            }
        }

        /*
        다른사람 풀이2(고급)
        HashSet은 중복이 제거가 되므로, 중복에 대해 신경쓸 필요가 없음!
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
               if(i != j){
                   hashSet.add(numbers[i] + numbers[j]);
               }
            }
        }

        //HashSet to List 로 변환한 후, 정렬
        List<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);

        //List의 제네릭 타입이 Integer이므로, int로 변환한다.
        return list.stream().mapToInt(i -> i).toArray();
        */


        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] += arrayList.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

}


