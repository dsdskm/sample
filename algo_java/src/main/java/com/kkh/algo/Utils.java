package com.kkh.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Utils {
    public static void println(String content) {
        System.out.println(content);
    }

    public static void print(String content) {
        System.out.print(content);
    }

    public static void print(int arr[]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
        System.out.println();
    }
    public static void print(String arr[]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("a[" + i + "]=" + arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("a[" + i + "][" + j + "]=" + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArr(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("a[" + i + "][" + j + "]=" + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printHash(HashMap<String, Integer> hash) {
        Iterator iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            String key = String.valueOf(iter.next());
            int value = hash.get(key);
            System.out.println("key = " + key + " , value = " + value);
        }
    }

    public static void printHash2(HashMap<Integer, Integer> hash) {
        Iterator iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            int key = (int) iter.next();
            int value = hash.get(key);
            System.out.println("key = " + key + " , value = " + value);
        }
    }

}
