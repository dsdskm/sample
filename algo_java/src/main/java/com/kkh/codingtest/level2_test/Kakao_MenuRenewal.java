package com.kkh.codingtest.level2_test;

import com.kkh.Utils;

import java.util.*;

public class Kakao_MenuRenewal {
    public static void main(String args[]) {
        new Kakao_MenuRenewal();
    }

    public Kakao_MenuRenewal() {
        /*
        각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
        코스요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
        최수 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
        ex)
        1   A   B   C   F   G
        2   A   C
        3   C   D   E
        4   A   C   D   E
        5   B   C   F   G
        6   A   C   D   E   H

        ->
        1,2,4,6     A   C
        3,4,6       C   D   E
        1,5         B   C   F   G
        4,6         A   C   D   E

         */
        String res[] = solution(new String[]{
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        }, new int[]{
                2, 3, 4
        });
        res = solution(new String[]{
                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ","ACD"
        }, new int[]{
                2, 3, 5
        });
        res = solution(new String[]{
                "XYZ", "XWY", "WXA"
        }, new int[]{
                2, 3, 4
        });
        Utils.print(res);
    }

    Hashtable<String, Integer> ht = new Hashtable();

    public String[] solution(String[] orders, int[] course) {
        /*
        course를 반복하면서 조합을 찾는다
        1번에서 course[0]개 조합을 모두 찾아 count
        2번에서 course[0]개 조합을 모두 찾아 count에 누적
        ...
        count가 가장 많은 조합 누적을 result에 추가
        ... 반복하여 추가
        최종적으로 결과 알파벳 정렬후 리턴
         */
        ArrayList<String> resultList = new ArrayList<>();
        for (int c : course) {
            ht.clear();
            for (String str : orders) {
                search(c, str);
            }
            int maxCount = 0;

            Iterator iter = ht.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                int count = ht.get(key);
                if (maxCount <= count) {
                    maxCount = count;
                }
            }
            iter = ht.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                int count = ht.get(key);
                if (maxCount == count && 1<count) {
                    resultList.add(key);
                }
            }
        }
        Collections.sort(resultList);
        String[] answer = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    private void search(int course, String str) {

        int n = str.length();
        boolean visit[] = new boolean[n];
        combination(str.toCharArray(), visit, 0, n, course);
    }

    private void combination(char[] str, boolean[] visit, int start, int n, int r) {
        if (r == 0) {
            save(str, visit, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            combination(str, visit, i + 1, n, r - 1);
            visit[i] = false;
        }
    }

    private void save(char[] arr, boolean[] visited, int n) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
                //System.out.print(arr[i] + " ");
            }
        }
        String value = sb.toString();

        if (ht.containsKey(value)) {
            int count = ht.get(value);
            ht.replace(value, count + 1);
        } else {
            ht.put(value, 1);
        }
    }

}
