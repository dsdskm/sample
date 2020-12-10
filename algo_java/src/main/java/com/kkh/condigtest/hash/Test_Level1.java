package com.kkh.condigtest.hash;

import java.util.HashMap;

public class Test_Level1 {
    public Test_Level1() {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution.solution(new String[]{"kiki", "kiki", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public static void main(String args[]) {
        new Test_Level1();
    }

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> completeHashMap = new HashMap<>();
            for (int i = 0; i < completion.length; i++) {
                String name = completion[i];
                if (completeHashMap.containsKey(name)) {
                    int count = completeHashMap.get(name);
                    completeHashMap.replace(name, count + 1);
                } else {
                    completeHashMap.put(completion[i], 1);
                }


            }

            for (int i = 0; i < participant.length; i++) {
                String name = participant[i];
                if (completeHashMap.containsKey(name)) {
                    int count = completeHashMap.get(name);
                    if (count - 1 == 0) {
                        completeHashMap.remove(name);
                    } else {
                        completeHashMap.replace(name, count - 1);
                    }
                } else {
                    answer = name;
                    break;
                }
            }

            return answer;
        }
    }
}

