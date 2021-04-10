package com.kkh.exam.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTreeSet {
    public static void main(String args[]){

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(100,"A");
        treeMap.put(100,"B");
        treeMap.put(80,"C");
        treeMap.put(70,"D");
        treeMap.put(50,"E");

        // 이진탐색트리의 형태로 데이터를 저장한다
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(100);
        treeSet.add(100);
        treeSet.add(80);
        treeSet.add(70);
        treeSet.add(50);

        NavigableSet<Integer> nset = treeSet.descendingSet();
        Iterator iterator =nset.iterator();
        while(iterator.hasNext()){
            int value = (int) iterator.next();
            System.out.println("value : "+value);

        }

        System.out.println(nset.ceiling(75));



    }
}
