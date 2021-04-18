package com.kkh.algo.codinginterview.ch09.sub10_sort;

import java.util.Hashtable;

public class Practice10_5 {
    public static void main(String args[]) {
        new Practice10_5();
    }

    public Practice10_5() {
        System.out.println(solution("ball", new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}));
    }

    public int solution(String str, String arr[]) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            if (!ht.containsKey(arr[i])) {
                ht.put(arr[i], i);
            }
        }

        return ht.get(str);
    }
}
