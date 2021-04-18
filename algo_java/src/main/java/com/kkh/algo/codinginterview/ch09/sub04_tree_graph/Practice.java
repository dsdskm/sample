package com.kkh.algo.codinginterview.ch09.sub04_tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice {
    public static void main(String args[]) {
        new Practice();
    }

    public Practice() {
        Graph g = new Graph(6);
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 3);
        g.add(1, 4);
        g.add(4, 5);
        g.print();
        g.bfs();
        g.dfs();
    }
}

class Graph {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public Graph(int size) {
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void add(int i, int v) {
        list.get(i).add(v);
        list.get(v).add(i);     // 무방향
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    boolean visit[];

    public void dfs() {
        System.out.println("dfs");
        visit = new boolean[list.size()];
        visit[1] = true;
        searchDfs(1);
    }

    public void bfs() {
        System.out.println("bfs");
        visit = new boolean[list.size()];
        visit[1] = true;
        searchBfs(1);
    }

    private void searchDfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int num = stack.pop();
            System.out.println("num : " + num);
            ArrayList<Integer> l = list.get(num);
            for (int t : l) {
                if (!visit[t]) {
                    visit[t] = true;
                    stack.push(t);
                }
            }
        }
    }

    private void searchBfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            System.out.println("num : " + num);
            ArrayList<Integer> l = list.get(num);
            for (int t : l) {
                if (!visit[t]) {
                    visit[t] = true;
                    queue.offer(t);
                }
            }
        }


    }
}