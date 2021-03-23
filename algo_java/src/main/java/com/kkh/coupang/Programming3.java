package com.kkh.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Programming3 {
    public static void main(String args[]) {
        int answer = 0;

        Programming3 p = new Programming3();
        System.out.println(p.solution(new int[]{5, 3, 9, 1,2,33,1122,33}, 7));

    }

    public boolean solution(int[] arr, int n) {
        Arrays.sort(arr);
        // i ~ j 까지 자른다
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr : "+arr[i]);
            if(arr[i]>=n){
                index = i;
                break;
            }
        }
        int newArr[] = new int[arr.length-index];
        System.arraycopy(arr,0,newArr,0,arr.length-index);

        boolean ret = false;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < newArr.length; i++) {
            System.out.println("newArr : "+arr[i]);
            list.add(arr[i]);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);

            if (current >= n) {
                break;
            }
            if (list.contains(n - current) || list.contains(n + current)) {
                ret = true;
            }
        }
        return ret;
    }
}
