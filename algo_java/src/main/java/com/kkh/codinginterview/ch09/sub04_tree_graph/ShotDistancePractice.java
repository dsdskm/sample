package com.kkh.codinginterview.ch09.sub04_tree_graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShotDistancePractice {
    public static void main(String args[]) {
        new ShotDistancePractice();
    }

    int arr[][];

    public ShotDistancePractice() {

        int size = 8;
        arr = new int[size + 1][size + 1];
        input(1, 2, 3);
        input(1, 5, 4);
        input(1, 4, 4);
        input(2, 3, 2);
        input(3, 4, 1);
        input(4, 5, 2);
        input(5, 6, 4);
        input(4, 7, 6);
        input(7, 6, 3);
        input(3, 8, 3);
        input(6, 8, 2);

        int distance[] = new int[8 + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean visited[] = new boolean[8 + 1];


        int start = 1;

        visited[start] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int current_node = tmp[0];  // start부터 current_node 까지
            int current_dis = tmp[1];   // start부터 current_node 까지의 거리
            if (current_dis > distance[current_node]) {
                continue;
            }

            for (int i = 0; i < arr.length; i++) {
                // 현재 노드에서 다음 연결 노드까지 연결되어있는지 확인
                if (arr[current_node][i] != 0) {
                    int next_d = current_dis + arr[current_node][i];
                    // 출발 노드부터 다음 노드까지의 거리를 비교 계산
                    if (next_d < distance[i]) {
                        distance[i] = next_d;
                        pq.add(new int[]{i, next_d});
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public void input(int from, int to, int value) {
        arr[from][to] = value;
    }

}
