package com.soap;

public class ArrGraph {
    private int[][] arrGraph;

    //그래프 초기화
    public ArrGraph(int size) {
        //그래프 초기화
        this.arrGraph = new int[size + 1][size + 1];
    }

    public static void main(String[] args) {
        int size = 6;
        ArrGraph graph = new ArrGraph(size);

        graph.put(1, 2);

        graph.printGraphToAdjArr();
    }

    public int[][] getArrGraph() {
        return arrGraph;
    }

    //그래프 추가 (양방향)
    public void put(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    //그래프 추가(단방향)
    public void putSingle(int x, int y) {
        arrGraph[x][y] = 1;
    }

    //그래프 출력
    public void printGraphToAdjArr() {
        for (int i = 0; i < arrGraph.length; i++) {
            for (int j = 0; j < arrGraph[i].length; j++) {
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }

}
