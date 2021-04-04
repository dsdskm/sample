package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice2_6 {
    /*
    2.6 회문 : 주어진 연결리스트가 회문인지 검사하는 함수를 작성
     */
    public static void main(String args[]) {
        new Practice2_6();
    }

    public Practice2_6() {
        LinkedListNode n[] = getLinkedListNode(new int[]{0, 1, 2, 1, 0});
        System.out.println(solution(n[0], n[1]));
    }


    public LinkedListNode[] getLinkedListNode(int arr[]) {
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
        return new LinkedListNode[]{head, last};
    }

    public boolean solution(LinkedListNode head, LinkedListNode tail) {
        /*
        1. 전체를 순회하고 ArrayList에 담는다
        2. ArrayList를 체크한다

        1. head와 tail에서 각각 시작하여 값이 다른경우 바로 리턴
         */

        while (true) {
            if (head.data != tail.data) {
                return false;
            }
            head = head.next;
            tail = tail.prv;
            if (head.data == tail.data) {
                break;
            }
        }
        return true;

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
