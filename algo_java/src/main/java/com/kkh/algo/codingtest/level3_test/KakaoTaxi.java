package com.kkh.algo.codingtest.level3_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KakaoTaxi {
    public static void main(String args[]) {
        new KakaoTaxi();
    }

    public KakaoTaxi() {
        solution(6, 4, 6, 2, new int[][]{
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25},
        });
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
        가중치가 있는 그래프를 구성
        s에서 a,b까지 가는 최단 거리
         */

        WeightGraphNode wg = new WeightGraphNode(n);
        for (int i = 0; i < fares.length; i++) {
            int f[] = fares[i];
            wg.add(f[0], f[1], f[2]);
        }
        wg.start(s);
        int answer = 0;
        return answer;
    }

    class WeightGraphNode {
        int arr[][];
        int start;
        int end;
        public WeightGraphNode(int size) {
            arr = new int[size + 1][size + 1];
        }

        public void add(int start, int end, int value) {
            this.start = start;
            this.end = end;
            arr[start][end] = value;
            arr[end][start] = value;

        }

        public void start(int v) {
            int distance[] = new int[arr.length];
            boolean visit[] = new boolean[arr.length];
            Arrays.fill(distance, Integer.MAX_VALUE);

            distance[v] = 0;
            visit[v] = true;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            pq.add(new int[]{v, 0});
            while (!pq.isEmpty()) {
                int top[] = pq.poll();
                int current = top[0];   // 노드
                int current_d = top[1]; // 거리
                if (distance[current] < current_d) {
                    continue;
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[current][i] != 0) {
                        int next_d = current_d + arr[current][i];
                        if (next_d < distance[i]) {
                            distance[i] = next_d;
                            pq.add(new int[]{i, next_d});
                        }
                    }
                }
            }
            for (int i = 1; i < arr.length; i++) {
                System.out.print(distance[i] + " ");
            }

        }
    }


}
