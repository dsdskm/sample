package com.kkh.algo.codinginterview.ch09.sub02_linkedlist;

public class Practice2_3 {
    /*
    2.3 중간 노드 삭제 : 단방향 연결리스트가 주어졌을 때 중간에 있는 노드 하나를 삭제하는 알고리즘.을 구해라
	단 삭제할 노드에만 접근할 수 있다(헤드부터 접근불가)
     */
    public static void main(String args[]) {
        new Practice2_3();
    }

    public Practice2_3() {

        solution(3);
    }

    public void solution(int k) {
        int ret = 0;

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
        printNode(head, false, 99);
        printNode(last, true, 99);
    }

    private boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
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
