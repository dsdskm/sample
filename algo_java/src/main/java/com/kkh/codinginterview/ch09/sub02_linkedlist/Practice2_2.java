package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice2_2 {
    /*
    2.2 뒤에서 k번째 원소 구하기 : 단방향 연결리스트가 주어졌을 때 뒤에서 k번째 원소를 찾는 알고리즘
     */
    public static void main(String args[]) {
        new Practice2_2();
    }

    public Practice2_2() {

        solution(3);
    }

    public void solution(int k) {
        int ret = 0;

        /*
        1. 연결리스트를 뒤집어 k만큼 돈다 or 전체 사이즈 - k만큼 돈다
         */

        LinkedListNode head = new LinkedListNode(1, null, null);
        LinkedListNode start = head;
        LinkedListNode last = null;
        for (int i = 2; i < 10; i++) {
            LinkedListNode newNode = new LinkedListNode(i, null, null);
            newNode.prv = start;
            start.next = newNode;
            start = start.next;
            last = start;
        }

        // 거꾸로 순회한다
        printNode(head, false, k);
        printNode(last, true, k);
    }

    private void printNode(LinkedListNode head, boolean isReverse, int k) {
        int count = 0;
        while (true) {
            if (count == k) {
                break;
            }
            count++;
            System.out.print(head.data + " ");
            if (isReverse) {
                head = head.prv;
            } else {
                head = head.next;
            }
            if (head == null) {
                break;
            }
        }
        System.out.println();
    }


}
