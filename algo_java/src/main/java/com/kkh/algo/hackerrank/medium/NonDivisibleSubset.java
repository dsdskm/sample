package com.kkh.algo.hackerrank.medium;

import com.kkh.Utils;

import java.util.*;

public class NonDivisibleSubset {
    public static void main(String args[]) {
        System.out.println(nonDivisibleSubset(3, Utils.getList(1, 7, 2, 4)));//3
    }


    public static int nonDivisibleSubset(int k, List<Integer> s) {
        //https://gaegosoo.tistory.com/62?category=945477
        int []cnt = new int[k];
        // 나머지를 담는 배열
        for(int i=0;i<s.size();i++){
            cnt[s.get(i)%k]++;
        }
        int ans = 0;
        // 나머지가 0인개 있다면 한번만 포함한다
        if(cnt[0]>0) ans +=1;

        //k가 짝수이고 3,3형태로 존재한다면 하나만 추가해야한다
        if(k%2==0 && cnt[k/2] >0) ans +=1;
        for(int i=1;i<=(k-1)/2;i++){
            // cnt[i]와 cnt[k-i]를 더하면 k와 나눠진다.
            // 둘중 하나만 카운트한다
            ans += Math.max(cnt[i], cnt[k - i]);
        }
        return ans;
    }

}
