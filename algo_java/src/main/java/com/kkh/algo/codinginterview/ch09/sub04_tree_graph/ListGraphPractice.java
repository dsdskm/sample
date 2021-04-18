package com.kkh.algo.codinginterview.ch09.sub04_tree_graph;

import java.util.ArrayList;

public class ListGraphPractice {

    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ListGraphPractice(int size) {
        for (int i = 0; i < size + 1; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void put(int from, int to) {
        list.get(from).add(to);
    }

    public int getSize() {
        return list.size();
    }

    public void print() {
        for (int i = 1; i < list.size(); i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> get(int from) {
        return list.get(from);
    }
}
