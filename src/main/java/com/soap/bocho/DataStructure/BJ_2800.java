package com.soap.bocho.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS, 백트래킹 기법
 * 풀이 : https://alwaysbemoon.tistory.com/164
 */
public class BJ_2800 {

    public static StringBuilder sb = new StringBuilder();
    public static List<Pair> pairs = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static HashSet<String> removedExpressions = new HashSet<>(); //  괄호가 제거된 수식
    public static int N; //괄호쌍의 개수
    public static char[] expression;
    public static String origin;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        origin = st.nextToken();
        expression = new char[origin.length()];
        for(int i = 0; i < origin.length(); i++){
            expression[i] = origin.charAt(i);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            char currentChar = expression[i];
            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar== ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }

        N = pairs.size();
        removePair(0, expression);

        //중복 괄호 제거 후 List에 담음
        List removedExpressionList = new ArrayList(removedExpressions);
        Collections.sort(removedExpressionList);

        for(int index = 0; index<removedExpressionList.size(); index++){
            if(!removedExpressionList.get(index).equals(origin)){
                System.out.print(removedExpressionList.get(index)+"\n");
            }
        }

    }

    public static void removePair(int index, char[] expression) {
        if (index >= N) {
            String removeExpression = new String(expression);
            removeExpression = removeExpression.replaceAll(" ", "");
            removedExpressions.add(removeExpression);
        } else {
            Pair currentPair = pairs.get(index);

            //currentPair 삭제
            expression[currentPair.leftIndex] = ' '; //공백으로 초기화
            expression[currentPair.rightIndex] = ' '; //공백으로 초기화
            removePair(index + 1, expression);

            //currentPair 삭제안함
            expression[currentPair.leftIndex] = '(';
            expression[currentPair.rightIndex] = ')';
            removePair(index + 1, expression);
        }
    }

}

class Pair {
    int leftIndex;
    int rightIndex;

    public Pair(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }
}