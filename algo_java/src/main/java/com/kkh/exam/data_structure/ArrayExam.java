package com.kkh.exam.data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayExam {
    public static void main(String args[]) {
        arrayCopy();
        sort();
        fill();
        convert();
    }

    private static void convert() {
        // Array to List
        List<String> outList = Arrays.asList("a", "b", "C");
        List<String> outList2 = Arrays.asList(new String[]{"a", "b", "C"});
        int[] list = {1, 2, 3, 4, 5, 6};

        // List to Array
        List<String> arrayList = Arrays.asList("a", "b", "C");
        String[] array = arrayList.toArray(new String[arrayList.size()]);
    }

    private static void fill() {
        int arr[] = new int[10];
        Arrays.fill(arr, 10);
    }

    private static void sort() {
        int arr[] = new int[]{5, 3, 1, 2, 4};
        Arrays.sort(arr);
        Integer arr2[] = new Integer[]{1, 3, 5, 2, 3};
        Arrays.sort(arr2, Collections.reverseOrder());
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
    }

    private static void arrayCopy() {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target[] = new int[3];
        System.arraycopy(arr, 2, target, 0, 3);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
        System.out.println();
    }
}
