package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice2_5 {
    /*
    2.5 리스트의 합 : 연결리스트로 숫자를 표현할 때 각 노드가 자릴수 하나를 가리키는 방식으로 표현할 수 있다.
	두 수를 더하여 그 합을 연결리스트로 반환하는 함수를 작성하라
     */
    public static void main(String args[]) {
        new Practice2_5();
    }

    public Practice2_5() {
        LinkedListNode node1 = getLinkedListNode(new int[]{7, 1, 6, 1});
        LinkedListNode node2 = getLinkedListNode(new int[]{5, 9, 2});
//        printNode(node1);
//        printNode(node2);
        solution(node1, node2);
    }


    public LinkedListNode getLinkedListNode(int arr[]) {
        LinkedListNode head = new LinkedListNode(arr[0], null, null);
        LinkedListNode start = head;
        LinkedListNode last = null;
        for (int i = 1; i < arr.length; i++) {
            LinkedListNode newNode = new LinkedListNode(arr[i], null, null);
            newNode.prv = start;
            start.next = newNode;
            start = start.next;
            last = start;
        }
        return head;
    }

    public void solution(LinkedListNode node1, LinkedListNode node2) {
        /*
        1. 다른 자리수 를 더하는 케이스도 고려한다
        2. 뒤에서부터 동시에 순회하면서 계산한다
         */

        LinkedListNode nd1 = node1;
        LinkedListNode nd2 = node2;
        LinkedListNode res = null;
        LinkedListNode resHead = null;
        int sum = 0;
        int plus = 0;
        while (true) {
            int value1 = nd1 != null ? nd1.data : 0;
            int value2 = nd2 != null ? nd2.data : 0;
            sum = value1 + value2 + plus;
            if (10 <= sum) {
                plus = 1;
                sum -= 10;
            } else {
                plus = 0;
            }
            //System.out.println(nd1.data + " , " + nd2.data + " , " + sum + " , plus : " + plus);
            if (res == null) {
                res = new LinkedListNode(sum, null, null);
                resHead = res;
            } else {
                res.next = new LinkedListNode(sum, null, null);
                res = res.next;

            }
            //System.out.println(res.data + " ");
            if (nd1 != null) {
                nd1 = nd1.next;
            }
            if (nd2 != null) {
                nd2 = nd2.next;
            }
            if (nd1 == null && nd2 == null) {
                break;
            }
        }
        printNode(resHead);

    }

    private void printNode(LinkedListNode head) {
        int count = 0;
        while (true) {
            count++;
            System.out.print(head.data + " ");
            head = head.next;
            if (head == null) {
                break;
            }
        }
        System.out.println();
    }


}
