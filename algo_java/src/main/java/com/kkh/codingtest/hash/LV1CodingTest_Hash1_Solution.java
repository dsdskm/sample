package com.kkh.codingtest.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class LV1CodingTest_Hash1_Solution {
    /*
    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

     */
    public static void main(String args[]) {
        String p1[];
        String c1[];

        p1 = new String[]{"leo", "kiki", "eden"};
        c1 = new String[]{"kiki", "eden"};
        System.out.println(solution(p1, c1));
        p1 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        c1 = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(p1, c1));
        p1 = new String[]{"mislav", "stanko", "mislav", "ana"};
        c1 = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(p1, c1));
    }

    public static String solution(String[] participant, String[] completion) {
        /*
        participant 와 completion을 정렬
        원소가 일치하지 않는 인덱스의 값 리턴
         */
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        // completion 길이가 1작으므로 completion 기준으로 순회

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equalsIgnoreCase(participant[i])) {
                answer = participant[i];
                break;
            }
        }
        if (answer.isEmpty()) {
            answer = participant[participant.length - 1];
        }

        return answer;

    }

    public static String solution_(String[] participant, String[] completion) {
        /*
        1. 참가한 선수 이름과 명수를 hash로 등록한다. key:name,value:count
        2. 완주한 선수 이름을 hash에서 지워간다
        2-1. count ==1 : remove key
        2-2. count >1 : value--
        3. count ==1인 값을 리턴한다
         */

        //1. 참가한 선수 이름과 명수를 hash로 등록한다. key:name,value:count
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String name = participant[i];
            if (hash.containsKey(name)) {
                int count = hash.get(name);
                hash.replace(participant[i], count + 1);
            } else {
                hash.put(participant[i], 1);
            }


        }

        //2. 완주한 선수 이름을 hash에서 지워간다
        for (int i = 0; i < completion.length; i++) {
            String name = completion[i];
            int count = hash.get(name);
            if (count == 1) {
                // 2-1. count ==1 : remove key
                hash.remove(name);
            } else {
                // 2-2. count >1 : value--
                hash.replace(name, count - 1);
            }
        }

        // 3. count ==1인 값을 리턴한다
        String ret = "";
        Iterator iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            ret = String.valueOf(iter.next());
        }
        return ret;
    }
}
