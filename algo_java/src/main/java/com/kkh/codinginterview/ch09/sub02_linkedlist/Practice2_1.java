package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice2_1 {
    /*
    2.1 중복 없애기 : 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드
	임시 버퍼를 사용할 수 없다면
     */
    public static void main(String args[]) {
        new Practice2_1();
    }

    public Practice2_1() {
        solution();
    }

    public void solution() {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 4, null, null);
            first.next = second;
            second.prv = first;
            first = second;
        }
        deleteDups(head);
        print(head);
    }

    private void print(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data+"-");
            current = current.next;
        }

        System.out.println();
    }

    private void deleteDups(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


}
