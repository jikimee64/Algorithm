package main.java.com.soap.bocho.Queue_Stack.Queue;

import java.util.*;
import java.util.stream.Collectors;

public class PRO_42586 {
    public static void main(String[] args) {
        List<Integer> solution = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        solution.forEach(System.out::print);
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = new int[101];
        Queue<Integer> q = new LinkedList<Integer>(); //소요기간

        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) % speeds[i];
            if (day == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        outer : while (!q.isEmpty()) {
            Integer poll = q.poll();
            answer[poll] += 1;
            if(q.isEmpty()){
                break outer;
            }
            while (poll >= q.peek()) {
                q.poll();
                answer[poll] += 1;
                if(q.isEmpty()){
                    break outer;
                }
            }
        }

        List<Integer> list = Arrays.stream(answer).boxed().collect(Collectors.toList());
        return list.stream().
                filter(s -> s != 0).collect(Collectors.toList());
    }

}
