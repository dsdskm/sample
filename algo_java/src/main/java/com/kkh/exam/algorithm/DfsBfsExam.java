package com.kkh.exam.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfsExam {
    public static void main(String args[]) {
        solution(new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6},

        }, 6);
        solution2(new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6},

        }, 6);
    }

    private static void solution2(int[][] arr, int n) {
        System.out.println("solution bfs");
        int nodeArr[][] = new int[n + 1][n + 1];
        boolean visited[] = new boolean[n + 1];

        // 연결 관계 설정
        for (int i = 0; i < arr.length; i++) {
            int v1 = arr[i][0];
            int v2 = arr[i][1];
            nodeArr[v1][v2] = 1;
            nodeArr[v2][v1] = 1;
        }

        bfs(nodeArr, 1, visited);
        System.out.println();
    }

    public static void bfs(int[][] nodeArr, int start, boolean[] visited) {
        // check배열 초기화
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작노드 추가
        queue.add(start);
        // 처음 시작노드 방문처리
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            System.out.print(num+"-");

            for (int i = 1; i < visited.length; i++) {
                // 현재 노드와 다른 노드 중 && 미방문 && 간선이 존재
                if (i != num && !visited[i] && nodeArr[num][i] == 1) {
                    // 노드 추가
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void solution(int[][] arr, int n) {
        System.out.println("solution dfs");
        int nodeArr[][] = new int[n + 1][n + 1];
        boolean visited[] = new boolean[n + 1];

        // 연결 관계 설정
        for (int i = 0; i < arr.length; i++) {
            int v1 = arr[i][0];
            int v2 = arr[i][1];
            nodeArr[v1][v2] = 1;
            nodeArr[v2][v1] = 1;
        }

        dfs(nodeArr, 1, visited);
        System.out.println();
    }

    public static void dfs(int node[][], int start, boolean visited[]) {
        // 경로 출력
        System.out.print(start+"-");

        // 현재 노드 방문 처리
        visited[start] = true;

        for (int i = 1; i < visited.length; i++) {
            // 현재 노드와 다른 노드 중 && 미방문 && 간선이 존재
            if (i != start && !visited[i] && node[start][i] == 1) {
                dfs(node, i, visited);
            }
        }
    }

//    public static void bfs(int start) {
//        // check배열 초기화
//        initCheck();
//        Queue<Integer> queue = new LinkedList<>();
//
//        // 처음 시작노드 추가
//        queue.add(start);
//        // 처음 시작노드 방문처리
//        check[start] = true;
//
//        while (!queue.isEmpty()) {
//            int num = queue.poll();
//            sb.append(num + " ");
//
//            for (int i = 1; i < check.length; i++) {
//                // 현재 노드와 다른 노드 중 && 미방문 && 간선이 존재
//                if (i != num && check[i] == false && arr[num][i] == 1) {
//                    // 노드 추가
//                    queue.add(i);
//                    check[i] = true;
//                }
//            }
//        }
//        sb.append("\n");
//    }

}
