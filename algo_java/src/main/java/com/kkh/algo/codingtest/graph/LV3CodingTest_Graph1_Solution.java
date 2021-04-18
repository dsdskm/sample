package com.kkh.algo.codingtest.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LV3CodingTest_Graph1_Solution {
    /*
    n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
    1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
    가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
    노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
    1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String args[]) {
        LV3CodingTest_Graph1_Solution l = new LV3CodingTest_Graph1_Solution();
        System.out.println(l.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));   //3

    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>());
        }

        //양방향 연결
        for (int[] i : edge) {
            int a = i[0];
            int b = i[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        //거리 저장을 위한 배열
        int[] cnt = new int[n + 1];
        cnt[0] = cnt[1] = 0;
        //방문 체크를 위한 배열
        boolean[] visited = new boolean[n + 1];
        visited[0] = visited[1] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);// 시작점
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println("cur : " + cur);
            for (int v : list.get(cur)) {
                System.out.print("v : " + v + " ");
                if (!visited[v]) {
                    visited[v] = true;
                    cnt[v] = cnt[cur] + 1;
                    q.add(v);
                }
            }
            System.out.println();
        }
        int max = 0;
        int ans = 0;
        for (int i : cnt) {
            if (max < i) {
                max = i;
                ans = 1;
            } else if (max == i) {
                ans += 1;
            }
        }

        return ans;
    }
}
