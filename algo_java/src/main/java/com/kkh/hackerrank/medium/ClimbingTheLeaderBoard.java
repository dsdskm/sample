package com.kkh.hackerrank.medium;

import java.util.*;

public class ClimbingTheLeaderBoard {

    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(100);
        list1.add(100);
        list1.add(50);
        list1.add(40);
        list1.add(40);
        list1.add(20);
        list1.add(10);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(5);
        list2.add(25);
        list2.add(50);
        list2.add(120);
        climbingLeaderboard(list1, list2);
        list1.clear();
        list1.add(100);
        list1.add(90);
        list1.add(90);
        list1.add(80);
        list1.add(75);
        list1.add(60);
        list2.clear();
        list2.add(50);
        list2.add(65);
        list2.add(77);
        list2.add(90);
        list2.add(102);
        climbingLeaderboard(list1, list2);


    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int r : ranked) {
            treeSet.add(r);
        }
        NavigableSet<Integer> nSet = treeSet.descendingSet();
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        Iterator iter = nSet.iterator();
        while (iter.hasNext()) {
            map.put((Integer) iter.next(), rank++);
        }
        List<Integer> result = new ArrayList<>();
        for (int p : player) {
            if (nSet.first() < p) {
                result.add(1);
            } else if (nSet.last() > p) {
                result.add(map.get(nSet.last()) + 1);
            } else {
                result.add(map.get(nSet.ceiling(p)));
            }
        }
        return result;
    }

    private static int convertIndex(List<Integer> ranked, int score) {
        int rank = 1;
        int prvScore = -1;
        for (int i = 0; i < ranked.size(); i++) {
            if (prvScore > 0) {
                if (prvScore != ranked.get(i)) {
                    rank++;
                }
            }
            prvScore = ranked.get(i);
            if (score >= ranked.get(i)) {
                break;
            }
            if (i == ranked.size() - 1) {
                rank++;
            }

        }
        return rank;
    }

    private static void print(List<Integer> ranked) {
        System.out.println("rankedList");
        for (int i = 0; i < ranked.size(); i++) {
            System.out.println(ranked.get(i));
        }
    }
}
