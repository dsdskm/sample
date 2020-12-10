package com.kkh.condigtest.hash;

import java.util.Arrays;
import java.util.HashMap;

public class CodingTest_Hash1 {
    public static void main(String args[]) {

        new CodingTest_Hash1();
    }

    public CodingTest_Hash1() {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if (i == completion.length) {
                answer = participant[i];
                break;
            }
            if (!participant[i].equalsIgnoreCase(completion[i])) {
                // 케이스 1 : 존슨 [존슨] 메리 ... & 존슨 [메리] 비드 ...
                // 케이스 2 : 존슨 [비드] & 존슨 [메리] 비드 ...
                // 케이스 3 : 키키 레오 & 키키

                if (participant[i + 1].equalsIgnoreCase(completion[i])) {
                    answer = participant[i];
                    break;
                } else if (participant[i].equalsIgnoreCase(completion[i + 1])) {
                    answer = completion[i + 1];
                    break;
                }
            }
        }
        return answer;
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 해시 사용
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String key = participant[i];
            if (hashMap.containsKey(key)) {
                int value = hashMap.get(key);
                hashMap.put(key, value + 1);
            } else {
                hashMap.put(key, 0);
            }
        }

        // 완주자를 체크하면서 저장된 값들을 체크
        // 2이 사람이 미완주자
        for (int i = 0; i < completion.length; i++) {
            String key = completion[i];
            int value = hashMap.get(key);
            hashMap.put(key, value - 1);
        }

        for (int i = 0; i < participant.length; i++) {
            String key = participant[i];
            int value = hashMap.get(key);
            if (value == 0) {
                answer = key;
                break;
            }
        }


        return answer;
    }
}
