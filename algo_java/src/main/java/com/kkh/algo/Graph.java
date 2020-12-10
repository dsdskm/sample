package com.kkh.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


public class Graph {

    public static void main(String args[]) {
        new Graph();
    }

    HashMap<String, String[]> HASH = new HashMap<>();

    public Graph() {

        HASH.put("A", new String[]{"B", "C"});
        HASH.put("B", new String[]{"A", "D", "E"});
        HASH.put("C", new String[]{"A", "F"});
        HASH.put("D", new String[]{"B"});
        HASH.put("E", new String[]{"B", "F"});
        HASH.put("F", new String[]{"C", "E"});

        //graphInit();
        //bfs();
        bfs_path("A", "F");
        //dfs();
    }

    class Node {
        String start;
        LinkedList<String> paths = new LinkedList<>();
    }

    private void bfs_path(String start, String goal) {
        System.out.println("bfs_path");
        LinkedList<Node> queue = new LinkedList<>();
        Node node = new Node();
        node.start = start;
        node.paths.add(start);
        queue.add(node);
        ArrayList<String> visit_list = new ArrayList<>();
        ArrayList<LinkedList<String>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.pop();

            System.out.println(current.start);
            if (current.start.equalsIgnoreCase(goal)) {
                result.add(current.paths);
            } else {
                if (!visit_list.contains(current.start)) {
                    visit_list.add(current.start);
                    String values[] = HASH.get(current.start);
                    for (int i = 0; i < values.length; i++) {
                        String next = values[i];
                        System.out.println(" next = " + next);
                        if (visit_list.contains(next)) {
                            continue;
                        }
                        Node nextNode = new Node();
                        nextNode.start = next;
                        nextNode.paths.addAll(current.paths);
                        nextNode.paths.add(next);
                        queue.add(nextNode);

                        for (int k = 0; k < queue.size(); k++) {
                            System.out.print(queue.get(k).start + " " + queue.get(k).paths);
                        }
                        System.out.println();

                    }
                }
            }
        }
        System.out.println(result);

    }

    private void dfs() {
        System.out.println("dfs");

        Stack<String> stack = new Stack<>();
        ArrayList<String> visit_list = new ArrayList<>();
        stack.add("A");
        while (!stack.isEmpty()) {
            String node = stack.pop();
            System.out.println("node = " + node);
            String nodes[] = HASH.get(node);
            if (!visit_list.contains(node)) {
                visit_list.add(node);
            }

            for (int i = 0; i < nodes.length; i++) {
                System.out.println(" node = " + nodes[i]);
                if (!visit_list.contains(nodes[i])) {
                    System.out.println("    add queue : " + nodes[i]);
                    stack.add(nodes[i]);
                }
                System.out.println("que size = " + stack.size());
            }
        }
        Utils.print(visit_list);
    }

    private void bfs() {
        System.out.println("bfs");
        HashMap<String, String[]> HASH = new HashMap<>();
        HASH.put("A", new String[]{"B", "C"});
        HASH.put("B", new String[]{"A", "D", "E"});
        HASH.put("C", new String[]{"A", "F"});
        HASH.put("D", new String[]{"B"});
        HASH.put("E", new String[]{"B", "F"});
        HASH.put("F", new String[]{"C", "E"});


        LinkedList<String> queue = new LinkedList<>();
        ArrayList<String> visit_list = new ArrayList<>();
        queue.add("A");
        while (!queue.isEmpty()) {
            String node = queue.pop();
            System.out.println("node = " + node);
            String nodes[] = HASH.get(node);
            if (!visit_list.contains(node)) {
                visit_list.add(node);
            }

            for (int i = 0; i < nodes.length; i++) {
                System.out.println(" node = " + nodes[i]);
                if (!visit_list.contains(nodes[i])) {
                    System.out.println("    add queue : " + nodes[i]);
                    queue.add(nodes[i]);
                }
                System.out.println("que size = " + queue.size());
            }
        }
        Utils.print(visit_list);
    }

    private void graphInit() {
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

}
