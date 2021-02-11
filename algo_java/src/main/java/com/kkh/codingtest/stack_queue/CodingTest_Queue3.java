package com.kkh.codingtest.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest_Queue3 {
    public static void main(String args[]) {
        new CodingTest_Queue3();
    }

    public CodingTest_Queue3() {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
//        System.out.println(solution(new int[]{1, 1, 9, 1, 1,1}, 0));
    }


    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<Integer>();

        // int 배열 priorities의 값들 Queue에 옮겨 담는다.
        for (int item : priorities) {
            Q.offer(item);
        }

        // Queue가 비어질 때까지 루프
        while (!Q.isEmpty()) {

            // poll() => Queue 맨 앞에 있는 요소를 반환, 해당 요소를 Queue에서 제거
            int target = Q.poll();

            // poll()으로 요소 하나를 뽑았으니 location이 하나 앞으로 당겨진다.
            location -= 1;

            // if => 가장 큰 수가 아니니 해당 요소를 Queue 맨 뒤로 옮긴다.
            // else => 가장 큰 수이니 해당 요소가 location이 지정한 요소인지 판별한다.
            if (chkQueue(target, Q)) {
                Q.offer(target);
                // location이 지정한 요소가 맨 뒤로 옮겨지면 location의 값을 바꿔준다.
                if (location == -1) {
                    location = Q.size() - 1;
                }
            } else {
                // if => 추출한 요소가 location이 지정한 요소
                // else => 지정한 요소가 아니다.
                // 어떤 경우든지 프린트가 되었으니 answer++
                if (location == -1) {
                    answer++;
                    return answer;
                } else {
                    answer++;
                }
            }

        }

        return answer;
    }

    // chkPriorities => poll() 뽑은 요소가 Queue 안에서 가장 높은 우선순위를 가지고 있는 것인가 판별
    static public boolean chkQueue(int one, Queue<Integer> Q) {

        for (Integer i : Q) {
            if (i > one) {
                return true;
            }
        }

        return false;
    }
}
