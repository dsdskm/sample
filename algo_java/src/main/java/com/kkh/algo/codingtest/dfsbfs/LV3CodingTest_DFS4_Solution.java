package com.kkh.algo.codingtest.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class LV3CodingTest_DFS4_Solution {
    public static void main(String args[]) {
        LV3CodingTest_DFS4_Solution l = new LV3CodingTest_DFS4_Solution();
//        l.solution(new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//        });
        l.solution(new String[][]{
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
                {"ATL", "ICN"}, {"ATL", "SFO"}
        });
    }

    List<String[]> resultList;

    public String[] solution(String[][] tickets) {

        resultList = new ArrayList<>();
        String[] result = new String[tickets.length + 1];
        boolean[] used = new boolean[tickets.length + 1];

        for (int i = 0; i < tickets.length; i++) {

            // 최초 출발지는 ICN
            if (tickets[i][0].equals("ICN")) {

                // 첫번째 티켓 정보는 미리 담아두고 재귀 함수 호출
                result[0] = tickets[i][0];
                result[1] = tickets[i][1];

                // 재귀함수 호출
                // 해당 티켓을 사용한 경우와 사용하지 않았을 경우를 모두 체크해줘야 함
                used[i] = true;
                dfs(tickets, used, 2, tickets[i][1], result);
                used[i] = false;
            }
        }

        // 배열 오름차순 정렬
        resultList.sort((o1, o2) -> {

            for (int i = 0; i < o1.length; i++) {

                if (o1[i].compareTo(o2[i]) > 0) {
                    return 1;

                } else if (o1[i].compareTo(o2[i]) < 0) {
                    return -1;
                }
            }
            return 0;
        });

        // 오름차순 정렬된 배열의 첫번 째 리턴
        return resultList.get(0);
    }

    private void dfs(String[][] tickets, boolean[] used, int resultIdx, String pre,
                     String[] result) {

        // 모든 티켓을 다 썼을 경우
        if (resultIdx == result.length) {

            String[] temp = new String[result.length];
            for (int i = 0; i < result.length; i++) {
                temp[i] = result[i];
            }

            resultList.add(temp);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {

            // 이전 티켓의 목적지와 현재 티켓의 출발지가 같다면
            if (!used[i] && tickets[i][0].equals(pre)) {

                result[resultIdx] = tickets[i][1]; // 도착지 입력

                // 재귀함수 호출
                used[i] = true; // 티켓 사용
                dfs(tickets, used, resultIdx + 1, tickets[i][1], result);
                used[i] = false; // 티켓 미사용
            }
        }
    }
}
