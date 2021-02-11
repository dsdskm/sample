package com.kkh.codingtest.hash;

import java.util.HashMap;
import java.util.Iterator;

public class LV2CodingTest_Hash3_Solution {
    /*
    스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
    예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
    다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
    스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
    서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String args[]) {
        System.out.println(new LV2CodingTest_Hash3_Solution().solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));

        /*
        headgear 2
        eyewear 1
        3*2 - 1 = 5;
        */
        System.out.println(new LV2CodingTest_Hash3_Solution().solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}));
        /*
        face 3
        3
        */
    }

    public int solution(String[][] clothes) {

        /*
        1. 카테고리 카운트를 hash에 저장. name은 중요하지 않음
        2. hash 순회하면서 계산
        1-1.안입는 경우까지 고려하여 항목별로 +1하여 곱함
        1-2.모두 안입는 경우 발생 가능하므로 -1
        1-3 category가 한 가지인 경우는 해당 count 리턴
         */

        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            if (hash.containsKey(category)) {
                int count = hash.get(category);
                hash.replace(category, count + 1);
            } else {
                hash.put(category, 1);
            }
        }

        if(hash.size()==1){
            answer = hash.get(clothes[0][1]);
        } else {
            Iterator iter = hash.keySet().iterator();
            while (iter.hasNext()) {
                String key = String.valueOf(iter.next());
                int count = hash.get(key);
                //1-1. 안입는 경우까지 고려하여 항목별로 +1하여 곱함
                answer = answer * (count + 1);
                System.out.println("key : "+key+" , count : "+count+" , answer : "+answer);
            }

            //1-2. 모두 안입는 경우 발생 가능하므로 -1
            answer = answer - 1;
        }
        return answer;
    }
}
