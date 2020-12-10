package com.kkh.coupang.test;

import java.util.HashMap;
import java.util.Iterator;

public class Coupang_Test3 {
    public static void main(String args[]) {
        new Coupang_Test3();
    }

    public Coupang_Test3() {
        System.out.println(solution(new String[]{
                "..........",
                "AAACC.....",
                ".AAA.....Z",
                "..AAAA..C.",
                "...BBBBB..",
                "....BBB...",
                "...ZBBB...",
                "ZZZZAAAC..",
                ".....CCCC.",
                "QQ......C.",
                ".........."}));
        System.out.println(solution(new String[]{
                "A,B,C,D",
                ".B.C.D."}));
    }

    public int[] solution(String[] maps) {
        int[] answer = new int[2];
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 쌍의 개수와 가장 많은 국경을 공유하는 나라의 수
        // 순회하면서 오른쪽과 아래만 확인한다
        HashMap<Character, Integer> country_hash = new HashMap<>();                 // 최다 공유구 계산 용도;
        for (int i = 0; i < maps.length; i++) {
            String rowStr = maps[i];
            for (int j = 0; j < rowStr.length(); j++) {
                char c = rowStr.charAt(j);
                if (c == '.' || c == ',') {
                    continue;
                } else {

                    if (j != rowStr.length() - 1) {
                        char next = rowStr.charAt(j + 1);
                        if (c != next && next != '.' && next != ',') {
                            // 서로다르게 접경해있는 경우 ex)AC로 hash에 넣는다
                            // hash 에 이미 존재하면 count +1;
                            // 존재할때 중복 여부 확인한다(ex)AC & CA)
                            StringBuilder sb = new StringBuilder();
                            if (c < next) {
                                sb.append(c);
                                sb.append(next);
                            } else {
                                sb.append(next);
                                sb.append(c);
                            }
                            String key = sb.toString();
                            // 공유국 계산
                            if (hashMap.containsKey(key)) {
                                hashMap.replace(key, hashMap.get(key) + 1);
                            } else {
                                hashMap.put(key, 1);
                            }
                            // 나라별 공유국 개수 업데이트
                            if (country_hash.containsKey(c)) {
                                country_hash.replace(c, country_hash.get(c) + 1);
                            } else {
                                country_hash.put(c, 1);
                            }
                            if (country_hash.containsKey(next)) {
                                country_hash.replace(next, country_hash.get(next) + 1);
                            } else {
                                country_hash.put(next, 1);
                            }
                        }
                    }
                    // 가장 우측 끝에 있는 겨우 아래 나라만 체크 한다
                    // 아래 나라 체크할 떄는 가장 아래 영토가 아닌지 확인
                    if (i != maps.length - 1) {
                        char down = maps[i + 1].charAt(j);
                        if (c != down && down != '.' && down != ',') {
                            // 서로다르게 접경해있는 경우 ex)AC로 hash에 넣는다
                            // hash 에 이미 존재하면 count +1;
                            // 존재할때 중복 여부 확인한다(ex)AC & CA)
                            StringBuilder sb = new StringBuilder();
                            if (c < down) {
                                sb.append(c);
                                sb.append(down);
                            } else {
                                sb.append(down);
                                sb.append(c);
                            }
                            String key = sb.toString();
                            // 공유국 계산
                            if (hashMap.containsKey(key)) {
                                hashMap.replace(key, hashMap.get(key) + 1);
                            } else {
                                hashMap.put(key, 1);
                            }
                            // 나라별 공유국 개수 업데이트
                            if (country_hash.containsKey(c)) {
                                country_hash.replace(c, country_hash.get(c) + 1);
                            } else {
                                country_hash.put(c, 1);
                            }
                            if (country_hash.containsKey(down)) {
                                country_hash.replace(down, country_hash.get(down) + 1);
                            } else {
                                country_hash.put(down, 1);
                            }
                        }
                    }
                }
            }
        }
        // Hash size = 쌍의 개수
        answer[0] = hashMap.size();
        Iterator iter = country_hash.keySet().iterator();
        int share_count = 0;

        char[] country_arr = new char[country_hash.size()];
        int[] cross_count_arr = new int[country_hash.size()];
        int index = 0;
        while (iter.hasNext()) {
            char key = (char) iter.next();
            country_arr[index++] = key;
        }

        iter = hashMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = String.valueOf(iter.next());
            for (int i = 0; i < country_arr.length; i++) {
                String country = String.valueOf(country_arr[i]);
                if (key.contains(country)) {
                    cross_count_arr[i] = cross_count_arr[i] + 1;
                }
            }
        }

        int max_cross_count = 0;
        for (int i = 0; i < cross_count_arr.length; i++) {
            if (max_cross_count < cross_count_arr[i]) {
                max_cross_count = cross_count_arr[i];
            }
        }
        answer[1] = max_cross_count;

        return answer;
    }
}
