package com.kkh.condigtest.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest_Queue1 {
    public static void main(String args[]) {
        new CodingTest_Queue1();
    }

    public CodingTest_Queue1() {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        //System.out.println(solution(100, 100, new int[]{10}));
    }

    class Truck {
        int weight;
        int entry;

        Truck(int weight, int entry){
            this.weight = weight;
            this.entry = entry;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for(int i = 0 ; i < truck_weights.length ; ++i){
            waiting.offer(new Truck(truck_weights[i], 0));
        }

        int time = 0;
        int totalWeight = 0;
        // 대기,다리위의 트럭이 모두 비는 경우 stop
        while(!waiting.isEmpty() || !bridge.isEmpty()){
            time++;
            if(!bridge.isEmpty()) {
                Truck t = bridge.peek();
                System.out.println("time = "+time+" , t.entry = "+t.entry+" , t.weight = "+t.weight);
                if(time - t.entry >= bridge_length) {
                    totalWeight -= t.weight;
                    bridge.poll();
                }
            }

            if(!waiting.isEmpty()) {
                if(totalWeight + waiting.peek().weight <= weight) {
                    Truck t = waiting.poll();
                    totalWeight += t.weight;

                    bridge.offer(new Truck(t.weight, time));
                }
            }
        }
        return time;
    }
}
