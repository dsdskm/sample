package com.kkh.coupang.practice;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorTest {
    public static void main(String args[]) {
        IteratorTest it = new IteratorTest();
        it.test();
    }

    private void test() {
        ConcurrentHashMap<Integer, Integer> hash = new ConcurrentHashMap<>();
        hash.put(1, 2);
        hash.put(2, 3);
        hash.put(3, 4);
        hash.put(4, 5);
        hash.put(5, 6);
        hash.put(6, 7);
        hash.put(7, 8);
        hash.put(8, 9);
        hash.put(9, 10);
        hash.put(10, 11);

        Iterator iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            int key = Integer.parseInt(String.valueOf(iter.next()));
            int value = hash.get(key);
            System.out.println("key=" + key + ",value=" + value);
            hash.remove(key);
        }
    }


}
