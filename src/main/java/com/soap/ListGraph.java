package com.soap;

import java.util.ArrayList;
import java.util.List;

public class ListGraph {

    private List<List<Integer>> listGraph;

    //그래프 초기화
    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<>(); // 그래프 생성

        //그래프 초기화
        //put(int x, int y)에서 입력되는 정점의 값은 0이상의 정수이나
        //ArrayList의 index는 0부터 시작이므로
        //outofboundsexception 방지를 위해
        //정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
        //ex) size = 3
        //graph[0]
        //graph[1] -> 2 -> 3
        //graph[2]
        //graph[3]
        for (int i = 0; i < initSize + 1; i++) {
            listGraph.add(new ArrayList<>());
        }

    }

    public static void main(String[] args) {
        int size = 6;
        ListGraph graph = new ListGraph(size);

        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 3);
        graph.put(2, 4);
        graph.put(3, 4);
        graph.put(3, 5);
        graph.put(4, 5);
        graph.put(4, 6);

        graph.printGraphToAdjList();
    }

    public List<List<Integer>> getListGraph() {
        return listGraph;
    }

    // 그래프의 특정 노드 return
    public List<Integer> getNode(int i) {
        return this.listGraph.get(i);
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        listGraph.get(x).add(y);
    }

    // 그래프 출력 (인접리스트)
    public void printGraphToAdjList() {
        for (int i = 1; i < listGraph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");

            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(" -> " + listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

}
