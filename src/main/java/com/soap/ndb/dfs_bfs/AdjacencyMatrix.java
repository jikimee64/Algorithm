package main.java.com.soap.ndb.dfs_bfs;

import java.util.ArrayList;

class NodeTemp {
    private int index;
    private int distance;

    public NodeTemp(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.println("(" + this.index + "," + this.distance + ") ");
    }
}

public class AdjacencyMatrix {
    public static ArrayList<ArrayList<NodeTemp>> graph = new ArrayList<ArrayList<NodeTemp>>();

    public static void main(String[] args) {
        //그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<NodeTemp>());
        }
        //노드 0에 연결된 노드 정보 저장(노드, 거리)
        graph.get(0).add(new NodeTemp(1, 7));
        graph.get(0).add(new NodeTemp(2, 5));

        //노드 1에 연결된 노드 정보 저장(노드, 거리)
        graph.get(1).add(new NodeTemp(0, 7));

        //노드 2에 연결된 노드 정보 저장(노드, 거리)
        graph.get(2).add(new NodeTemp(0, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }

    }
}
