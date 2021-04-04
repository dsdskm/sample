package com.kkh.codinginterview.ch09.sub02_linkedlist;

import java.util.Hashtable;

public class Practice2_8 {
    /*
    2.8 루프 발견 : 순환 연결리스트가 주어졌을 때, 순환되는 부분의 첫째 노드를 반환하는 알고리즘을 작성하라
     */
    public static void main(String args[]) {
        new Practice2_8();
    }

    public Practice2_8() {
        LinkedListNode head = getLinkedListNode(new int[]{0, 1, 2, 3, 4});
        System.out.println(solution(head));
    }

    public LinkedListNode getLinkedListNode(int arr[]) {
        LinkedListNode head = new LinkedListNode(arr[0], null, null);
        LinkedListNode node1 = new LinkedListNode(arr[1], null, null);
        LinkedListNode node2 = new LinkedListNode(arr[2], null, null);
        LinkedListNode node3 = new LinkedListNode(arr[3], null, null);
        LinkedListNode node4 = new LinkedListNode(arr[4], null, null);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;

        return head;
    }

    public boolean solution(LinkedListNode head) {
        /*
        마지막 노드의 next가 null이 아니면 순회이다
         */
        Hashtable<Integer, Boolean> ht = new Hashtable<>();
        LinkedListNode node = head;
        while (true) {
            ht.put(node.data, true);
            node = node.next;
            if (node == null) {
                break;
            }
            if (ht.containsKey(node.data)) {
                return true;
            }
        }
        return false;

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
