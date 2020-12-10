package com.kkh.condigtest.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CodingTest_Hash3 {
    public static void main(String args[]) {

        new CodingTest_Hash3();
    }

    public CodingTest_Hash3() {
        System.out.println(solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}));
    }

    public int solution(String[][] clothes) {

        // 서로다른 옷 조합의 수 return
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String item = clothes[i][0];
            String category = clothes[i][1];
            if (hashMap.containsKey(category)) {
                hashMap.replace(category, hashMap.get(category) + 1);
            } else {
                hashMap.put(category, 1);
            }
        }

        int answer = 1;
        /*
        입을 수 있는 옷 종류의 수는 각 종류별로 선택할지 안 할지 여부(+1)를 포함하여 아래와 같은 방식으로 구할 수 있습니다.
        (A종류 옷 가지수 + 1)*(B종류 옷 가지수 + 1)*(C종류 옷 가지수 + 1) - 1
         */
        for (int value : hashMap.values()) {
            answer *= (value + 1);
        }
        answer--;

        return answer;
    }
}
