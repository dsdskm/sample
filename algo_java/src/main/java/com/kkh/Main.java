package com.kkh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String args[]) {
        Main m = new Main();
        m.sort();
    }

    public void sort() {
        //array
        int arr[] = new int[]{5, 3, 1, 2, 4};
        Integer arr2[] = new Integer[]{5, 3, 1, 2, 4};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Arrays.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        // list
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 2-array

        Integer arr3[][] = new Integer[][]{
                {4, 2},
                {3, 3},
                {5, 1},
                {10, 4},
                {1, 5}
        };
        Arrays.sort(arr3, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i][0] + " , " + arr3[i][1]);
        }
        System.out.println();

        // string
        String str[] = new String[]{"AAAAA", "BBB", "CCCCCCCCC", "DDDD"};
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] + " ");
        }
        System.out.println();

        str = new String[]{"119", "97674224", "1195524421", "1199333","DDDD"};
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] + " ");
        }
        System.out.println();
    }
}
