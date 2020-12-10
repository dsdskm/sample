package com.kkh.condigtest.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Test_Level2_2 {
    public Test_Level2_2() {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));//5
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));//3
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face1"}, {"smoky_makeup", "face2"}})); //
    }

    public static void main(String args[]) {
        new Test_Level2_2();
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        /*
        (n+1)*(m+1)*(o+1) -1
        +1을 해주는 이유 -> 안 입는 경우
        -1을 해주는 이유 -> 모두 안입는 경우

         */

        // 의상 종류별로 count 저장
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String value1 = clothes[i][0];
            String category = clothes[i][1];
            if(hashMap.containsKey(category)){
                int count = hashMap.get(category);
                count+=1;
                hashMap.replace(category,count);
            } else {
                hashMap.put(category,1);
            }
        }

        Iterator iter = hashMap.keySet().iterator();
        while(iter.hasNext()){
            String key = (String) iter.next();
            int count = hashMap.get(key);
            answer *= (count+1);
        }
        answer -=1;

        return answer;
    }


}
