package main.java.com.soap.programmers.level1;

import java.util.*;

public class Failure_Kakao_42889 {

    //내풀이
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int humanNum = stages.length;
        int count = 0;
        List<Integer> list = new ArrayList();
        HashMap<Integer, Double> map = new HashMap();

        //stages배열 리스트에 삽입
        for (int i = 0; i < humanNum; i++) {
            list.add(stages[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int z = 0; z < list.size(); z++) {
                if (list.get(z) <= N && list.get(z) == i) {
                    count++;
                }
            }
            if (count == 0) {
                map.put((Integer) i, 0.0);
            } else {
                double num = (double) count / (double) humanNum;
                map.put((Integer) i, num);
            }
            humanNum -= count;
            count = 0;
        }

        //HashMap
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int index = 0;
        for (Integer key : keySetList) {
            answer[index] = key;
            index++;
        }
        return answer;
    }
    //------------------------------------------------------

    //https://leveloper.tistory.com/105
    //다른사람 풀이
    public int[] solution2(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //key : 스테이지, value : 스테이지아 존재하는 총 개수
       for(int s : stages){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

       int total = stages.length;
       Node[] nodes = new Node[N];
       for(int i=1; i<=N; i++){
           if(!map.containsKey(i)){
               nodes[i-1] = new Node(i, 0);
               continue;
           }
           int count = map.get(i);
           nodes[i-1] = new Node(i, (double)count/total);
           total -= count;
       }

       Arrays.sort(nodes);
       int[] answer = new int[N];
       for(int i = 0; i < N; i++){
           answer[i] = nodes[i].num;
       }
       return answer;
    }
}

class Node implements Comparable<Node> {
    int num;
    double rate;

    Node(int num, double rate){
        this.num = num;
        this.rate = rate;
    }

    @Override
    public int compareTo(Node other) {
        //내림차순
        return Double.compare(other.rate, this.rate);
    }
}
