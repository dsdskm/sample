package com.kkh.exam.data_structure;

import java.util.ArrayList;

public class GraphExam {
    public static void main(String args[]) {
        listGraph();
        arrayGraph();
    }

    private static void arrayGraph() {
        ArrGraph g = new ArrGraph(10);
        g.put(1, 4);
        g.put(2, 3);
        g.put(1, 6);
        g.put(2, 5);
        g.printGraphToAdjArr();
    }

    private static void listGraph() {
        ListGraph g = new ListGraph(10);
        g.put(1, 4);
        g.put(2, 3);
        g.put(1, 6);
        g.put(2, 5);
        g.printGraphToAdjList();
    }


}

class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;

    // 그래프 초기화
    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<ArrayList<Integer>>(); // 그래프 생성

        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // ArrayList의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해
        // 정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
        // ex) initSize = 3
        // graph[0]
        // graph[1] -> 2 -> 3
        // graph[2] -> 1 -> 3 -> 4
        // graph[3] -> 1 -> 2 -> 4 -> 5
        for (int i = 0; i < initSize + 1; i++) {
            listGraph.add(new ArrayList<Integer>());
        }
    }

    // 그래프 return
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.listGraph;
    }

    // 그래프의 특정 노드 return
    public ArrayList<Integer> getNode(int i) {
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

class AdjacencyList {

    public static void main(String[] args) {
        int initSize = 6;
        ListGraph adjList = new ListGraph(initSize);

        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 3);
        adjList.put(2, 4);
        adjList.put(3, 4);
        adjList.put(3, 5);
        adjList.put(4, 5);
        adjList.put(4, 6);

        adjList.printGraphToAdjList();
    }

}

class ArrGraph {
    private int[][] arrGraph;

    // 그래프 초기화
    public ArrGraph(int initSize) {
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // 배열의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해
        // 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌
        this.arrGraph = new int[initSize + 1][initSize + 1];
    }

    // 그래프 return
    public int[][] getGraph() {
        return this.arrGraph;
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        arrGraph[x][y] = 1;
    }

    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr() {
        for (int i = 0; i < arrGraph.length; i++) {
            for (int j = 0; j < arrGraph[i].length; j++) {
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }
}

class AdjacencyArray {

    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph adjArr = new ArrGraph(initSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);

        adjArr.printGraphToAdjArr();
    }

}



