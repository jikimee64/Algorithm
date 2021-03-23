package main.java.com.soap.ndb.implementation;

import java.io.*;

public class NDB_Part02_왕실의나이트 {
    public static void main(String[] args) throws IOException {

        int num = 12345;



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        //int[][] arr = new int[8][8];
        int[][] arr = new int[][]{ {2, 1}, {2, -1}, {-2, 1}, {-2 , -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2} };
        int result = 0;

        int x = Integer.parseInt(N.split("")[1])-1;
        String sen = N.split("")[0];
        int y = 0;

        //이것보다 나동빈 답방법이 좋은듯
        switch (sen){
            case "a": y = 0;break;
            case "b": y = 1;break;
            case "c": y = 2;break;
            case "d": y = 3;break;
            case "e": y = 4;break;
            case "f": y = 5;break;
            case "g": y = 6;break;
            case "h": y = 7;break;
        }

        for(int i = 0; i < arr.length; i++){
            x += arr[i][1];
            y += arr[i][0];
            if(x >= 0 && x <= 7 && y >= 0 && y <= 7){
               result++;
            }
            x -= arr[i][1];
            y -= arr[i][0];
        }

        System.out.println(result);

        /* 나동빈 답
         Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0'; //문자를 숫자로 바꾸기
        int column = inputData.charAt(0) - 'a' + 1; //알파벳을 1~8로 바꾸기

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

        System.out.println(result);
         */
    }
}
