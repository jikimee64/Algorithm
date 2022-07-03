package com.soap;

import java.util.LinkedList;
import java.util.Stack;

public class DFS_Stack {

    int vertex;
    LinkedList<Integer> list[];

    public DFS_Stack(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[9];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            var v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                for (int i = 0; i < list[v].size(); i++) {
                    int dest = list[v].get(i);
                    if (!visited[dest]) {
                        stack.push(dest);
                    }
                }
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            LinkedList<Integer> nodeList = list[i];
            if (nodeList.isEmpty() == false) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }

}
