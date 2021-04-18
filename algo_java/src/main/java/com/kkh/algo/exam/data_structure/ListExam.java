package com.kkh.algo.exam.data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListExam {
    public static void main(String args[]) {
        linkedList();
        sort();
        fill();
    }

    private static void fill() {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Collections.fill(list, 100);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void sort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(10);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

    }

    private static void linkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(2);
        list.offer(1);
        list.offer(10);
        list.offer(3);
        list.offer(6);
        list.offer(5);
        list.offer(7);
        list.offer(8);
        list.offer(9);
        list.offer(4);
        while (!list.isEmpty()) {
            int poll = list.poll();
            System.out.println("poll : " + poll);
        }
    }

}
