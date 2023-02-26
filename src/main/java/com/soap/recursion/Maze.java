package com.soap.recursion;

/**
 * 미로찾기
 */
public class Maze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    private static final int PATHWAY_COLOR = 0; // white
    private static final int WALL_COLOR = 1; // blue
    private static final int BLOCKED_COLOR = 2; // red (visited이며 출구까지의 경로상에 있지 않음이 밝혀진 cell
    private static final int PATH_COLOR = 3; // green (visited이며 아직 출구로 가는 경로가 될 가능성이 있는 cell)

    public static void main(String[] args) {
        printMaze();
        findMazePath(0, 0);
        printMaze();
    }

    public static void printMaze() {
        // 2차원 배열 출력 메서드
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // 참고: https://digest1.tistory.com/7
    public static boolean findMazePath(int x, int y) {
        return false;
    }

}
