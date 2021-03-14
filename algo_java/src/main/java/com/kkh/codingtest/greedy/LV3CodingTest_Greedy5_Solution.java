package com.kkh.codingtest.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LV3CodingTest_Greedy5_Solution {
    /*
    n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
    최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

    다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
    예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

    제한사항

    섬의 개수 n은 1 이상 100 이하입니다.
    costs의 길이는 ((n-1) * n) / 2이하입니다.
    임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
    같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
    모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
    연결할 수 없는 섬은 주어지지 않습니다.

     */
    public static void main(String args[]) {
        LV3CodingTest_Greedy5_Solution l = new LV3CodingTest_Greedy5_Solution();
        //System.out.println(l.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));      // 4
        System.out.println(l.solution(5, new int[][]{{0, 1, 1}, {2, 3, 1}, {1, 4, 2}, {0, 2, 3}}));      // 4
    }

    int parent[];

    public int solution(int n, int[][] costs) {
        /*
        1. 가중치 오름 차순으로 배열 정렬
        2. 자신이 부모인 배열을 생성
         */
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int index = 0;
        while (!isOne(parent)) {
            int[] current = costs[index++];
            int one = current[0];
            int the_other = current[1];
            //the_other의 값을 one의 값으로 변경하되 the_other의 값과 일치하는 모든 것을 함께 변경한다
            int cost = current[2];
            System.out.println("one : " + one + " , the_other : " + the_other + " , parent[one]:" + parent[one] + " , parent[the_other]:" + parent[the_other] + " cost : " + cost);
            if (parent[the_other] != parent[one]) {
                //둘은 아직 연결안되어 있고 연결해야하는 상태
                //the_other의 부모값을 other의 부모값으로 변경한
                parent = changeCycleTableNumber(parent, one, the_other);
                display();
                answer += cost;

            }
        }

        return answer;
    }

    void display() {
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    int[] changeCycleTableNumber(int cycleTable[], int one, int the_other) {
        int cycleTheOther = cycleTable[the_other];
        int cycleOne = cycleTable[one];
        System.out.println("cycleOne : " + cycleOne + " , cycleTheOther : " + cycleTheOther);
        for (int i = 0; i < cycleTable.length; i++) {
            if (cycleTable[i] == cycleTheOther) {
                //부모가 the_other인 것을 찾아 other로 일괄 변경해준다
                cycleTable[i] = cycleOne;
            }
        }
        return cycleTable;
    }

    boolean isOne(int[] cycleTable) {
        for (int i = 1; i < cycleTable.length; i++) {
            if (cycleTable[i - 1] != cycleTable[i]) {
                return false;
            }
        }
        return true;
    }

}
