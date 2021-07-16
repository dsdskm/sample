package com.kkh.algo.codejam.online_2021_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

public class ProblemA {
    /*
    Albert가 다니는 회사의 주차장에 지금 자동차 n대 일렬로 (좌에서 우로) 주차되어있다.
    편의상 차는 좌측부터 순서대로 1번에서 n번까지 번호로 나타내자.
    i번 차의 번호판에 적힌 문자열을 x[i]라 하자.
    n개의 문자열은 서로 다르며, 영어 대/소문자 (a-z와 A-Z)로만 구성된 길이 k인 문자열이다. 즉, 모든 번호판의 길이는 같다.
    임의의 두 자동차 i, j 에 대하여 번호판 x[i] 와 x[j]가 아래 조건을 모두 만족하면 두 자동차는 비슷한 번호판을 가졌다고 한다:

    26가지의 각 알파벳에 대하여, 대/소문자를 무시했을 때 해당 알파벳이 x[i]에 적힌 횟수와 x[j]에 적힌 횟수가 같다 (이 조건은 각 알파벳에 대해 만족해야 한다).
    x[i]에 적힌 대문자의 개수와 x[j]에 적힌 대문자의 개수가 같다.
    예를 들어, n = 4, k = 3 이고 x = ["AtY", "YtA", "aTy", "Ayt"]라 하자.

    1번차와 2번차의 번호판은 비슷하다: 두 번호판 모두 A/a 1개, T/t 1개, Y/y 1개씩을 포함하고 대문자는 3글자 중 2글자이다.
    3번차와 4번차의 번호판은 비슷하다: 두 번호판 모두 A/a 1개, T/t 1개, Y/y 1개씩을 포함하고 대문자는 3글자 중 1글자이다.
    1번차와 3번차의 번호판은 비슷하지 않다: 1번차는 대문자 2개, 3번차는 대문자 1개를 포함한다 (단, 첫 번째 조건은 만족한다).
    입력으로 n, k 그리고 x[1], ..., x[n]이 주어졌을 때, 비슷한 번호판 쌍의 수를 구해서 Albert에게 알려주자.
     */
    public static void main(String args[]) {
        /*
        T
        n k
        Aty Yta aTy Ayt
         */
        System.out.println(solution(4, 3, new String[]{"AtY", "YtA", "aTy", "Ayt"}));
        System.out.println(solution(4, 4, new String[]{"AAaa", "AaAa", "aaAA", "AaaA"}));
        System.out.println(solution(5, 4, new String[]{"AAAA", "aaaa", "AAaa", "AAAa", "Aaaa"}));
        System.out.println(solution(10, 1, new String[]{"A", "a", "B", "b", "C", "c", "D", "d", "E", "e"}));
        System.out.println(solution(2, 10, new String[]{"ABCDEabcde", "abcdeEDCBA"}));
    }

    static int ANSWER = 0;
    static Hashtable<String, Integer> sHashTable = new Hashtable<>();
    public static int solution(int n, int k, String[] arr) {
        ArrayList<String> group[] = new ArrayList[k + 1];
        for (int i = 0; i < group.length; i++) {
            group[i] = new ArrayList<>();
        }

        ANSWER = 0;
        sHashTable.clear();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            sHashTable.put(str, count);
        }

        Iterator iter = sHashTable.keySet().iterator();
        while (iter.hasNext()) {
            String key = String.valueOf(iter.next());
            int value = sHashTable.get(key);
            group[value].add(key);
        }


        for (int i = 0; i < group.length; i++) {
            ArrayList<String> list = group[i];
            if (list != null && list.size() > 0) {
                String[] array = list.toArray(new String[list.size()]);
                boolean isVisited[] = new boolean[array.length];
                combination(array, isVisited, 0, array.length, 2);
            }

        }
        int ret = ANSWER;
        return ret;
    }
    static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(String[] arr, boolean[] visited, int n) {
        String temp[] = new String[2];
        int tempIndex = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp[tempIndex++] = arr[i];
            }
        }
        boolean isCondition1Ok = true;
        for (int i = 0; i < temp[0].length(); i++) {
            char ch1 = temp[0].charAt(i);
            char ch2 = temp[1].charAt(i);
            String chs1U = String.valueOf(ch1).toUpperCase();
            String chs2U = String.valueOf(ch2).toUpperCase();
            String chs1L = chs1U.toLowerCase();
            String chs2L = chs2U.toLowerCase();
            if ((temp[0].contains(chs2U) && temp[1].contains(chs1U))
                    || (temp[0].contains(chs2U) && temp[1].contains(chs1L))
                    || (temp[0].contains(chs2L) && temp[1].contains(chs1U))
                    || (temp[0].contains(chs2L) && temp[1].contains(chs1L))
            ) {
                isCondition1Ok = true;
            } else {
                isCondition1Ok = false;
            }

            if (!isCondition1Ok) {
                break;
            }
        }
        if (isCondition1Ok) {
            // 조건1 만족
            int count1 = sHashTable.get(temp[0]);
            int count2 = sHashTable.get(temp[1]);
            if (count1 == count2) {
                ANSWER++;
            }
        }
    }
}
