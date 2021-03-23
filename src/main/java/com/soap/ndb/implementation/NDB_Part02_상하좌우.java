package main.java.com.soap.ndb.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class NDB_Part02_상하좌우 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int x = 0;
        int y = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            switch (st.nextToken()) {
                case "R":
                    if (y < N-1) {
                        y++;
                    }
                    break;
                case "L":
                    if (y > 0) {
                        y--;
                    }
                    break;
                case "U":
                    if (x > 0) {
                        x--;
                    }
                    break;
                case "D":
                    if (x < N-1) {
                        x++;
                    }
                    break;
            }
        }

        System.out.println((x + 1) + " " + (y + 1));

        /** 나동빈 풀이방법 : 어렵다...
         *  Scanner sc = new Scanner(System.in);
         *
         *         // N을 입력받기
         *         int n = sc.nextInt();
         *         sc.nextLine(); // 버퍼 비우기
         *         String[] plans = sc.nextLine().split(" ");
         *         int x = 1, y = 1;
         *
         *         // L, R, U, D에 따른 이동 방향
         *         int[] dx = {0, 0, -1, 1};
         *         int[] dy = {-1, 1, 0, 0};
         *         char[] moveTypes = {'L', 'R', 'U', 'D'};
         *
         *         // 이동 계획을 하나씩 확인
         *         for (int i = 0; i < plans.length; i++) {
         *             char plan = plans[i].charAt(0);
         *             // 이동 후 좌표 구하기
         *             int nx = -1, ny = -1;
         *             for (int j = 0; j < 4; j++) {
         *                 if (plan == moveTypes[j]) {
         *                     nx = x + dx[j];
         *                     ny = y + dy[j];
         *                 }
         *             }
         *             // 공간을 벗어나는 경우 무시
         *             if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
         *             // 이동 수행
         *             x = nx;
         *             y = ny;
         *         }
         *
         *         System.out.println(x + " " + y);
         */

    }
}
