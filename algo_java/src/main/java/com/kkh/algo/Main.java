package com.kkh.algo;

import com.kkh.Test;

import java.io.*;
import java.util.*;

import static com.kkh.algo.Utils.print;
import static com.kkh.algo.Utils.println;

public class Main {

    public static void main(String args[]) {
        println("");
        new Main();
        println("");
    }

    public Main() {
        //arrayCopy();
        //fileRead("./data/problem1/");
        //tokenizer();
        //arrayTest();
        //sort();
        linkedList();

    }

    private void linkedList() {
        Queue<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        Queue<Integer> list2 = new LinkedList<>();
        list2.addAll(list1);
        list1.add(100);
        list2.add(500);
        System.out.println(list2);

    }

    private void sort() {
        String arr[] = {"CC","AA","BB",};
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private void arrayTest() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        // list1&list2
        println("list1&list2");
        list1.retainAll(list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        // list1-list2
        println("list1-list2");
        list1.removeAll(list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        // list1+list2
        println("list1+list2");
        list1.addAll(list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    private void tokenizer() {
        String input = "1 2 3 4 5";
        StringTokenizer st = new StringTokenizer(input, "");
        while (st.hasMoreTokens()) {
            print(st.nextToken());
        }
    }

    private void fileRead(String folder) {
        String pre = folder;
        ArrayList<String> mInList = new ArrayList<>();
        ArrayList<String> mOutList = new ArrayList<>();
        ArrayList<Test> mTestList = new ArrayList<>();
        for (File file : new File(folder).listFiles()) {
            if (file.isDirectory()) {
                for (File sub : new File(pre + file.getName()).listFiles()) {
                    if (sub.getName().contains(".out")) {
                        mOutList.add(sub.getName());
                    } else if (sub.getName().contains(".in")) {
                        mInList.add(sub.getName());
                    }
                }
            } else {
                if (file.getName().contains(".out")) {
                    mOutList.add(file.getName());
                } else if (file.getName().contains(".in")) {
                    mInList.add(file.getName());
                }
            }
        }

        print(mInList);
        print(mOutList);
        for (int i = 0; i < mInList.size(); i++) {
            mTestList.add(new Test(pre + mInList.get(i), pre + mOutList.get(i)));
        }

        for (int i = 0; i < mTestList.size(); i++) {
            test(mTestList.get(i).input, mTestList.get(i).output);
        }
    }

    public void test(String input, String output) {
        println(input);
        println(output);
        File file = new File(input);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void arrayCopy() {
        print("arrayCopy");

        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {10, 20, 30, 40, 50};
        int arr3[] = {100, 200, 300, 400, 500};

        int res1[];
        int res2[];
        int res3[] = new int[5];

        // shallow
        println("Shallow Copy");
        res1 = arr1;
        for (int i = 0; i < res1.length; i++) {
            res1[i] = i + 300;
        }
        print(res1);
        print(arr1);

        // deep
        println("Deep Copy");
        res2 = arr1.clone();
        for (int i = 0; i < res2.length; i++) {
            res2[i] = i + 300;
        }
        print(res2);
        print(arr2);

        // system array copy
        // src = 전송원배열
        // srcPos = 복사 시작 위치
        // dest = 전송처 배열
        // destPos = 목적 시작 위치
        // length = 복사 개수
        System.arraycopy(arr3, 0, res3, 0, res3.length - 2);
        println("Array Copy");
        print(res3);
        print(arr3);


    }
}
