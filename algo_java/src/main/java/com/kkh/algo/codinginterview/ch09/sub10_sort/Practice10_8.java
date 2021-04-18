package com.kkh.algo.codinginterview.ch09.sub10_sort;

import java.util.Hashtable;

public class Practice10_8 {
    public static void main(String args[]) {
        new Practice10_8();
    }

    public Practice10_8() {
        solution();
    }

    public void solution() {
        /*
        1부터 N(<=32000)까지의 숫자로 이루어진 배열이 있다
        중복 숫자 가능
        N이 무엇인지는 모른다
        사용 가능한 메모리 4KB일때 중복된 원소를 모두 출력하는 법
         */
        Hashtable<Integer, Boolean> ht = new Hashtable<>();
        int N = 32000;
        int arr[] = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            if (ht.containsKey(arr[i])) {
                System.out.print(arr[i] + " ");
            } else {
                ht.put(arr[i], true);
            }
        }
        System.out.println();
    }
}
