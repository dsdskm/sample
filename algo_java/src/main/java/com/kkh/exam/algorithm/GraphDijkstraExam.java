package com.kkh.exam.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphDijkstraExam {

    //https://bumbums.tistory.com/4
    public static void main(String args[]) {

        new GraphDijkstraExam();
    }


    private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수


    public GraphDijkstraExam() {
        n = 8;
        maps = new int[n + 1][n + 1];
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

        //dijkstra(1);           // 0 3 5 4 4 8 10 8
        dijkstraPq(1);          // 0 3 5 4 4 8 10 8

    }

    private void dijkstraPq(int v) {
        int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

        //distance값 초기화.
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //시작노드값 초기화.
        distance[v] = 0;
        check[v] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
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
            System.out.println("=====current : "+current+" , current_d : "+current_d);

            for (int i = 0; i < maps.length; i++) {
//                System.out.println("maps["+current+"]["+i+"] : "+maps[current][i]);
                if (maps[current][i] != 0) {
                    int next_d = current_d+maps[current][i];
                    System.out.println("    next : "+ i +" , next_d : "+next_d+distance[i]);
                    if (next_d < distance[i]) {
                        distance[i] = next_d;
                        pq.add(new int[]{i, next_d});
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println("");
    }

    public void input(int i, int j, int w) {
        maps[i][j] = w;
        maps[j][i] = w;
    }

    public void dijkstra(int v) {
        int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

        //distance값 초기화.
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //시작노드값 초기화.
        distance[v] = 0;
        check[v] = true;

        //연결노드 distance갱신(시작 노드)
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && maps[v][i] != 0) {
                distance[i] = maps[v][i];
                System.out.print("distance[" + i + "]:" + distance[i] + " ");
            }
        }
        System.out.println();


        for (int a = 0; a < n - 1; a++) {
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            //최소값 찾기
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && distance[i] != Integer.MAX_VALUE) {
                    if (distance[i] < min) {
                        min = distance[i];
                        min_index = i;
                        System.out.println("    min_index = " + min_index + " , dis = " + distance[i]);
                    }
                }
            }

            check[min_index] = true;
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && maps[min_index][i] != 0) {
                    if (distance[i] > distance[min_index] + maps[min_index][i]) {
                        distance[i] = distance[min_index] + maps[min_index][i];
                    }
                }
            }
            System.out.println();
        }

        //결과값 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println("");
    }
}
