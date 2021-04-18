package com.kkh.algo.exam.algorithm;

import java.util.*;

public class GraphPrimExam {
    // https://ghkvud2.tistory.com/97
    static int N;
    static int M;
    static LinkedList<GraphPrimExamNode>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        N = 6;

        nodes = new LinkedList[N + 1];
        visited = new boolean[N + 1];


        for (int i = 1; i <= N; i++) {
            nodes[i] = new LinkedList<>();
        }
        PriorityQueue<GraphPrimExamNode> pq = new PriorityQueue<>();
        addNode(1, 2, 6);
        addNode(1, 3, 1);
        addNode(1, 4, 5);
        addNode(2, 3, 5);
        addNode(2, 5, 3);
        addNode(3, 4, 5);
        addNode(3, 5, 6);
        addNode(3, 6, 4);
        addNode(4, 6, 2);


        visited[1] = true;
        for (GraphPrimExamNode graphPrimExamNode : nodes[1]) {
            pq.add(new GraphPrimExamNode(graphPrimExamNode.idx, graphPrimExamNode.val));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            GraphPrimExamNode current = pq.poll();
            if (visited[current.idx]) {
                continue;
            }
            visited[current.idx] = true;
            ans += current.val;
            for (GraphPrimExamNode graphPrimExamNode : nodes[current.idx]) {
                if (!visited[graphPrimExamNode.idx]) {
                    pq.add(new GraphPrimExamNode(graphPrimExamNode.idx, graphPrimExamNode.val));
                }
            }
        }
        System.out.println(ans);
    }

    private static void addNode(int s, int e, int val) {
        nodes[s].add(new GraphPrimExamNode(e, val));
        nodes[e].add(new GraphPrimExamNode(s, val));
    }
}

class GraphPrimExamNode implements Comparable<GraphPrimExamNode> {
    public int idx;
    public long val;

    public GraphPrimExamNode(int idx, long val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(GraphPrimExamNode n1) {
        return (int) (this.val - n1.val);
    }
}

