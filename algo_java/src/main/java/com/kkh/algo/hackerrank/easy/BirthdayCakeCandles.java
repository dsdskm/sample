package com.kkh.algo.hackerrank.easy;

import com.kkh.Utils;

import java.util.Collections;
import java.util.List;

public class BirthdayCakeCandles {
    public static void main(String args[]) {

        System.out.println(birthdayCakeCandles(Utils.getList(3, 2, 1, 3)));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {


        //가장 큰수의 개수를 리턴
        Collections.sort(candles,Collections.reverseOrder());
        int max = 0;
        int answer = 0;
        for (int n : candles) {
            if (max == 0) {
                max = n;
                answer++;
            } else {
                if (max != n) {
                    break;
                } else {
                    answer++;
                }
            }
        }
        return answer;

    }
}
