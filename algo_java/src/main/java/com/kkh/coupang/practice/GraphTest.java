package com.kkh.coupang.practice;

import java.util.ArrayList;

public class GraphTest {

    public GraphTest() {

    }

    public static void main(String args[]) {
        GraphTest gt = new GraphTest();
        gt.adgList();
        gt.adgMatrix();

    }

    private void adgMatrix() {
        AdjMatrix am = new AdjMatrix(6);
        am.addEdge(1,2);
        am.addEdge(1,3);
        am.addEdge(2,3);
        am.addEdge(2,4);
        am.addEdge(3,4);
        am.addEdge(3,5);
        am.addEdge(4,5);
        am.addEdge(4,6);
        am.printGraph();
    }

    private void adgList() {
        AdjList al = new AdjList(6);
        al.put(1, 2);
        al.put(1, 3);
        al.put(2, 3);
        al.put(2, 4);
        al.put(3, 4);
        al.put(3, 5);
        al.put(4, 5);
        al.put(4, 6);

        al.printList();
    }

    class AdjList {
        private ArrayList<ArrayList<Integer>> mListGraph;

        public AdjList(int initSize) {
            mListGraph = new ArrayList<>();
            for (int i = 0; i < initSize + 1; i++) {
                mListGraph.add(new ArrayList<>());
            }
        }

        public ArrayList<ArrayList<Integer>> getList() {
            return mListGraph;
        }

        public ArrayList<Integer> getNode(int value) {
            return mListGraph.get(value);
        }

        public void put(int x, int y) {
            mListGraph.get(x).add(y);
            mListGraph.get(y).add(x);
        }

        public void printList() {
            for (ArrayList list : mListGraph) {
                for (Object o : list) {
                    int value = (int) o;
                    System.out.print("[" + value + "]");
                }
                System.out.println();
            }
        }
    }

    class AdjMatrix {
        private int[][] mMatrix;
        private int mVertex;

        public AdjMatrix(int size) {
            mMatrix = new int[size + 1][size + 1];
        }

        public int[][] getMatrix() {
            return mMatrix;
        }

        public void addEdge(int start, int to) {
            mMatrix[start][to] = mMatrix[to][start] = 1;
        }

        public void removeEdge(int start, int to) {
            mMatrix[start][to] = mMatrix[to][start] = 0;
        }

        public void printGraph() {
            for (int i = 0; i < mMatrix.length; i++) {
                for (int j = 0; j < mMatrix[i].length; j++) {
                    System.out.print(" " + mMatrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
