package com.soap.bocho.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://hoho325.tistory.com/90
public class BJ_2615 {

    static int[][] map;
    static int row = 1, col = 1;
    static int ur = 1, dr = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1: 검은 바둑알
        //2: 흰 바둑알
        //0: 알이 놓이지 않음
        map = new int[20][20];
        for (int i = 1; i <= 19; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }


        // 어떤 색이 이겼는가?? 승부가 나지 않았는가?
        // 5개의 알이 연속으로 가로, 세로, 대각선으로 놓인 경우에 이김
        // 6개는 이긴게 아니다.

        // 가로로 이긴 경우 가장 왼쪽알
        // 대각선이나 세로는 가장 위 왼쪽
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] == 1) {
                    search(i, j, 1);
                } else if (map[i][j] == 2) {
                    search(i, j, 2);
                }
            }
        }

        System.out.println("0");
        br.close();
    }

    public static boolean check(int x, int y, int num) {
        if (isValidPosition(x, y)) {
            if (map[x][y] != num) {
                return false;
            }
        } else
            return false;

        return true;
    }

    public static boolean isValidPosition(int x, int y) {
        if (x < 1 || x > 19 || y < 1 || y > 19)
            return false;
        return true;
    }

    public static void search(int i, int j, int num) {
        //가로 확인
        for (int k = 1; k < 5; k++) {
            if (!check(i, j + k, num))
                break;
            else
                row++;
        }

        //세로 검사
        for (int k = 1; k < 5; k++) {
            if (!check(i + k, j, num))
                break;
            else
                col++;
        }

        //아래 오른쪽 대각선 검사
        for (int k = 1; k < 5; k++) {
            if (!check(i + k, j + k, num))
                break;
            else
                dr++;
        }

        //위로 오른쪽 대각선
        for (int k = 1; k < 5; k++) {
            if (!check(i - k, j + k, num))
                break;
            else
                ur++;
        }

        //양쪽 끝으로 더 연결된 것이 있는지 확인
        //가로
        if (row == 5) {
            if (isValidPosition(i, j - 1)) {
                if (map[i][j - 1] != num) {
                    if (isValidPosition(i, j + 5)) {
                        if (map[i][j + 5] != num)
                            finish(i, j, num);
                    } else //바둑판 범위에 벗어나도 row=5, 이전X(육목X)이기 때문에 가능
                        finish(i, j, num);
                }
            } else {
                if (isValidPosition(i, j + 5)) {
                    if (map[i][j + 5] != num)
                        //이전 위치 범위 벗어남, 다음 위치 안붙어있음
                        finish(i, j, num);
                } else //이전 위치도 벗어나고, 다음위치도 벗어남 = 이런경우가 어딨?
                    finish(i, j, num);
            }
        }
        //세로
        if (col == 5) {
            if (isValidPosition(i - 1, j)) {
                if (map[i - 1][j] != num) {
                    if (isValidPosition(i + 5, j)) {
                        if (map[i + 5][j] != num)
                            finish(i, j, num);
                    } else
                        finish(i, j, num);
                }
            } else {
                if (isValidPosition(i + 5, j)) {
                    if (map[i + 5][j] != num)
                        finish(i, j, num);
                } else
                    finish(i, j, num);
            }
        }

        //아래 오른쪽 대각선
        if (dr == 5) {
            if (isValidPosition(i - 1, j - 1)) {
                if (map[i - 1][j - 1] != num) {
                    if (isValidPosition(i + 5, j + 5)) {
                        if (map[i + 5][j + 5] != num)
                            finish(i, j, num);
                    } else
                        finish(i, j, num);
                }
            } else {
                if (isValidPosition(i + 5, j + 5)) {
                    if (map[i + 5][j + 5] != num)
                        finish(i, j, num);
                } else
                    finish(i, j, num);
            }
        }

        //위로 오른쪽
        if (ur == 5) {
            if (isValidPosition(i + 1, j - 1)) {
                if (map[i + 1][j - 1] != num) {
                    if (isValidPosition(i - 5, j + 5)) {
                        if (map[i - 5][j + 5] != num) {
                            finish(i, j, num);
                        }
                    } else
                        finish(i, j, num);
                }
            } else {
                if (isValidPosition(i - 5, j + 5)) {
                    if (map[i - 5][j + 5] != num) {
                        finish(i, j, num);
                    }
                } else
                    finish(i, j, num);
            }
        }

        row = 1;
        col = 1;
        ur = 1;
        dr = 1;
    }

    public static void finish(int i, int j, int num) {
        System.out.println(num);
        System.out.println(i + " " + j);
        System.exit(0);
    }
}
