package com.kkh.coupang.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Coupang_Test4 {
    public static void main(String args[]) {
        new Coupang_Test4();
    }

    public Coupang_Test4() {
//        System.out.println(solution(1210));
//        System.out.println(solution(1425));
//        System.out.println(solution(100));
        System.out.println(solution(9876));
    }

    public int solution(int number) {
        int answer = -1;

        // 자기 표현수에 해당하는 진법을 리턴

        // 2~10진법 순으로 순회하다가 리턴
        String numberStr = "";
        String numberStr2 = "";
        for (int index = 2; index <= 10; index++) {
            numberStr = numberConverted(number, index);
            int len = String.valueOf(numberStr).length();
            // 각 자리수별 등장 횟수 저장
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < numberStr.length(); i++) {
                int num = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
                if (hashMap.containsKey(num)) {
                    hashMap.replace(num, hashMap.get(num) + 1);
                } else {
                    hashMap.put(num, 1);
                }
            }

            int arr[] = new int[len];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                // 인덱스자체 값의 존재 카운트 확인
                int count = 0;
                if (hashMap.containsKey(i)) {
                    count = hashMap.get(i);
                }
                sb.append(count);
            }

            numberStr2 = sb.toString();
            if (numberStr.equalsIgnoreCase(numberStr2)) {
                answer = index;
                break;
            }
        }

        return answer;
    }

    private String numberConverted(int num, int to) {
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; // max 10진법
        ArrayList<Integer> list = new ArrayList<>();
        int res = 0;
        while (num != 0) {
            res = num % to;
            num = num / to;
            list.add(res);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(arr[list.get(i)]);

        }
        return sb.toString();
    }
}
