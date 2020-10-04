package com.soap.programmers.level1;

import java.util.*;

public class Crane_Kakao_64061 {

    //내 풀이
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList();
        boolean flag = true;
        //바구니에 넣는 이중 for문
        for (int i : moves) {
            for (int z = 0; z < board.length; z++) {
                if (board[z][i - 1] != 0) {
                    int val = board[z][i - 1];
                    list.add(val);
                    board[z][i - 1] = 0;
                    break;
                }
            }
        }
        //중복값 제거
        while (flag) {
            flag = false;
            int preNum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (preNum == list.get(i)) {
                    answer += 2;
                    list.remove(i);
                    list.remove(i - 1);
                    flag = true;
                    break;
                } else {
                    preNum = list.get(i);
                }
            }
        }
        return answer;
    }
    //---------------------------------------------------
    //다른사람 풀이
    public int solution2(int[][] board, int[] moves) {
        int answer = 0;

        int row = board.length;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves) {
            pos = pos - 1;
            for(int i=0; i<row; i++){
                if(board[i][pos] != 0){
                    int val = board[i][pos];
                    if(!stack.isEmpty() && stack.peek() == val){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(val);
                    }
                    board[i][pos] = 0;
                    break;
                }
            }
        }
        return 0;
    }


}
