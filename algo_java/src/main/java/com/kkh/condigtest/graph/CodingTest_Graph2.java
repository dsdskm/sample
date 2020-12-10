package com.kkh.condigtest.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest_Graph2 {
    public static void main(String args[]) {
        new CodingTest_Graph2();
    }

    public CodingTest_Graph2() {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        int maxValue= 1000000;
        int[][] FW = new int[n+1][n+1];
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j<=n; j++) {
                FW[i][j] = maxValue;
            }
        }

        for(int[] e : results) {
            FW[e[0]][e[1]] = 1;
        }
        //거치는 노드
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <=n; i++) {            //시작 노드
                for(int j = 1; j <= n; j++) {
                    if(FW[i][j] > FW[i][k]+FW[k][j]) {    //종료(도착)노드
                        FW[i][j] = FW[i][k] + FW[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int j = 1; j <=n; j++) {
                if(i == j) continue;
                if(FW[i][j] == maxValue && FW[j][i] == maxValue) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
