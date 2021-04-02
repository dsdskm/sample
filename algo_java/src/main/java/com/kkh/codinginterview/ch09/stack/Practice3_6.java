package com.kkh.codinginterview.ch09.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Practice3_6 {
    public static void main(String args[]) {
        new Practice3_6();
    }

    public Practice3_6() {
        /*
        먼저 들어온 동물이 먼저 나가는 동물 보호소가 있다
        개와 고양이만 수용
        사람들은 가장 오래된 동물부터 입양 가능
        개와 고양이중 선택 가능
        특정한 동물을 지정해 데려갈 수는 없다
         */
        solution();
    }

    private void solution() {

        /*
        1. 하나의 큐 함깨 offer 한다
        2. 개만 pop한다
        3. 고양이만 pop한다
        4. 아무거나 pop한다
         */
        AnimalShelter as = new AnimalShelter();
        as.enqueue("개1");
        as.enqueue("개2");
        as.enqueue("고양이1");
        as.enqueue("고양이2");
        as.enqueue("개3");
        as.enqueue("개4");
        as.enqueue("고양이3");
        as.enqueue("고양이4");
        as.enqueue("개5");
        as.enqueue("개6");
        as.enqueue("고양이5");
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueDog());
        System.out.println(as.dequeueDog());
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueAny());
        System.out.println(as.dequeueAny());
        System.out.println(as.dequeueAny());
    }

    class AnimalShelter {
        // 0 is dog, 1 is cat
        private Queue<String> queue;

        public void enqueue(String value) {
            if (queue == null) {
                queue = new LinkedList<>();
            }
            queue.offer(value);
        }

        public String dequeueAny() {
            return queue.poll();
        }

        public String dequeueDog() {
            return dequeue("개");
        }

        public String dequeueCat() {
            return dequeue("고양이");
        }

        private String dequeue(String category){
            Queue<String> tmpQueue = new LinkedList<>();
            String ret = "";
            while (!queue.isEmpty()) {
                String poll = queue.poll();
                if (poll.contains(category) && ret.isEmpty()) {
                    ret = poll;
                } else {
                    tmpQueue.offer(poll);
                }
            }
            queue = tmpQueue;

            return ret;
        }


    }
}
