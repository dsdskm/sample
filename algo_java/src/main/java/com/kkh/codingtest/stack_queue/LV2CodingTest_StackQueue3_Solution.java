package com.kkh.codingtest.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class LV2CodingTest_StackQueue3_Solution {
    /*
    트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
    트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.

    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
    0	    []	            []	            [7,4,5,6]
    1~2 	[]	            [7]         	[4,5,6]
    3   	[7]         	[4]         	[5,6]
    4   	[7]         	[4,5]	        [6]
    5   	[7,4]	        [5]         	[6]
    6~7 	[7,4,5]	        [6]         	[]
    8   	[7,4,5,6]   	[]          	[]

    bridge_length	weight	truck_weights	                return
    2	            10  	[7,4,5,6]	                    8
    100         	100	    [10]	                        101
    100         	100	[10,10,10,10,10,10,10,10,10,10] 	110
     */
    public static void main(String args[]) {
        LV2CodingTest_StackQueue3_Solution s = new LV2CodingTest_StackQueue3_Solution();
        System.out.println(s.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(s.solution(100, 100, new int[]{10}));
        System.out.println(s.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
        1. A:대기 장소에 있는 트럭, B:다리 건너고 있는 트럭, C:다리를 건넌 트럭
        2. 시간 값을 계속 업데이트하면서 B 스택에 값을 넣거나 뺀다
        3. 값을 넣거나 뺄때 합을 계속 해서 계산한다

         */
        int answer = 0;
        Stack<Integer> waiting = new Stack<Integer>();
        Queue<Integer> moving = new LinkedList<>();
        Stack<Integer> passed = new Stack<Integer>();

        for (int i = truck_weights.length - 1; i >= 0; i--) {
            waiting.push(truck_weights[i]);
        }

        // bridge_length-1 만큼 미리 0으로 채워 놓는다.
        for (int i = 0; i < bridge_length; i++) {
            moving.offer(0);
        }
        int sum = 0;
        while (true) {
            answer += 1;

            // 매회 무조건 poll 한다.
            int poll = moving.poll();
            sum-=poll;
            //System.out.println("poll : "+poll+" , waiting:"+waiting.size()+" , moving : " + moving.size() + " , passed : "+passed.size()+" , answer : " + answer);
            if (poll != 0) {
                passed.push(poll);
            }


            // offer를 waiting에서 가져올지 or 0을 넣을지 결정한다
            // waiting이 empty일수도 있다
            if (waiting.isEmpty()) {
                moving.offer(0);
            } else {
                int peek = waiting.peek();
                //System.out.println("sum : "+sum+", peek : "+peek);
                if (sum + peek > weight) {
                    moving.offer(0);
                } else {
                    int pop = waiting.pop();
                    sum+=pop;
                    moving.offer(pop);
                }
            }

            if (passed.size() == truck_weights.length) {
                break;
            }

        }

        return answer;
    }
}
