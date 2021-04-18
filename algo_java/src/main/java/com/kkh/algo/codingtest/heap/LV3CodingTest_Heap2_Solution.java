package com.kkh.algo.codingtest.heap;

import java.util.*;

public class LV3CodingTest_Heap2_Solution {
    /*
    SJF 알고리즘
    하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
    예를들어
    - 0ms 시점에 3ms가 소요되는 A작업 요청
    - 1ms 시점에 9ms가 소요되는 B작업 요청
    - 2ms 시점에 6ms가 소요되는 C작업 요청
     */
    public static void main(String args[]) {
        LV3CodingTest_Heap2_Solution l = new LV3CodingTest_Heap2_Solution();
        System.out.println(l.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }


    public int solution(int[][] jobs) {

        /*
        1. 시작 시간 오름 차순으로 정렬 리스트 선언 & 초기화한다
        2. waiting queue를 선언한다
        3. 반복문을 계속 돈다
        4. 리스트 반복하면서 현재시간보다 시작시간이 작으면 waiting queue에 추가한다
        5.
         */

        // 리스트는 시작 시간 오름차순 정렬
        LinkedList<Job> waiting = new LinkedList<>();
        // 작업 큐는 작업 시간 오름차순 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.workingTime - j2.workingTime;
            }
        });

        for (int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.requestTime - j2.requestTime;
            }
        });

        int answer = 0;
        int cnt = 0;            // 총 처리한 작업수
        int time = waiting.peek().requestTime;

        // 총 처리한 작업수가 전체 작업수랑 같아질때까지 계속 반복
        while (cnt < jobs.length) {
            //System.out.println("============================");
            while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                // 현재 time보다 작거나 같으면 작업 큐에 넣는다
                //System.out.println(" waiting peek : "+waiting.peek());
                pq.offer(waiting.pollFirst());
            }

            if (!pq.isEmpty()) {
                //작업큐에 작업이 있으면 제일 작업시간 짧은거 뺀다
                Job job = pq.poll();
                //System.out.println(" job :" + job.toString());
                // 작업 완료 시점에만 확인하면 되므로 time을 더해준다
                time += job.workingTime;
                // 요청부터 종료까지의 시간을 계산하여 answer에 더한다
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }

        return answer / cnt;
    }

    class Job {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "requestTime=" + requestTime +
                    ", workingTime=" + workingTime +
                    '}';
        }
    }


}
