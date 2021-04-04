package com.kkh.codinginterview.ch09.sub04_tree_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice4_1 {
    //4.1 노드 사이의 경로 : 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는지 확인하는 알고리즘
    public static void main(String args[]) {
        new Practice4_1();
    }

    ListGraphPractice lgp = new ListGraphPractice(6);

    public Practice4_1() {

        lgp.put(1, 2);
        lgp.put(1, 3);
        lgp.put(2, 4);
        lgp.put(3, 4);
        lgp.put(4, 6);
        lgp.print();
        System.out.println(bfs(1, 6));
        System.out.println(dfs(1, 6));
    }

    private boolean bfs(int from, int to) {
        System.out.println("bfs "+from+" to "+to);
        boolean visit[] = new boolean[lgp.getSize()];
        visit[from] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < lgp.get(poll).size(); i++) {
                int v = lgp.get(poll).get(i);
                System.out.println("poll : " + poll + " , v : " + v + " , to : " + to);
                if (v == to) {
                    return true;
                }
                if (!visit[v]) {
                    visit[v] = true;
                    queue.offer(v);
                }
            }
        }
        return false;
    }

    private boolean dfs(int from, int to) {
        System.out.println("dfs "+from+" to "+to);
        boolean visit[] = new boolean[lgp.getSize()];
        visit[from] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(from);
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            for (int i = 0; i < lgp.get(pop).size(); i++) {
                int v = lgp.get(pop).get(i);
                System.out.println("pop : " + pop + " , v : " + v + " , to : " + to);
                if (v == to) {
                    return true;
                }
                if (!visit[v]) {
                    visit[v] = true;
                    stack.push(v);
                }
            }
        }
        return false;
    }


}
