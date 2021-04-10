package com.kkh.hackerrank.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NonDivisibleSubset {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(4);
        System.out.println(nonDivisibleSubset(3, list));
    }

    static HashSet<Integer> hashSet = new HashSet<>();

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        /*
         */
        boolean isVisited[] = new boolean[s.size()];
        combination(s, isVisited, 0, s.size(), 2,k);
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            int value = (int) iterator.next();
            System.out.println("value : "+value);
        }
        return 0;
    }

    static void combination(List<Integer> s, boolean[] visited, int start, int n, int r, int k) {
        if (r == 0) {
            print(s, visited, n,k);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(s, visited, i + 1, n, r - 1, k);
            visited[i] = false;
        }
    }

    static void print(List<Integer> arr, boolean[] visited, int n, int k) {
        int index = 0;
        int temp[] = new int[2];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp[index++] = arr.get(i);
                System.out.print(arr.get(i) + " ");
            }
        }
        System.out.println();
        System.out.println(temp[0] + "," + temp[1] + "=" + (temp[0] + temp[1]));
        int sum = temp[0]+temp[1];
        if(sum%k==0){
            hashSet.add(temp[1]);
        }
    }

}
