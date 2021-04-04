package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice2_4 {
    /*
    2.4 분할 : 값 x가 주어졌을 때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다 앞에 오도록 하는 코드를 작성
	정렬은 필요없다
     */
    public static void main(String args[]) {
        new Practice2_4();
    }

    public Practice2_4() {

        solution(4);
    }

    public void solution(int x) {
        /*
        1. 2개의 링크드 리스트를 만들어 x와 비교하여 나누어 연결한다

         */
        // make linked list
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

        LinkedListNode node = head;
        LinkedListNode smallNode = null;
        LinkedListNode smallHeadNode = null;
        LinkedListNode smallLastNode = null;
        LinkedListNode bigNode = null;
        LinkedListNode bigHeadNode = null;
        while (true) {
            if (node.data < x) {
                if (smallNode == null) {
                    smallNode = new LinkedListNode(node.data, null, null);
                    smallHeadNode = smallNode;
                } else {
                    smallNode.next = new LinkedListNode(node.data, null, null);
                    smallNode = smallNode.next;
                    smallLastNode = smallNode;
                }
            } else {
                if (bigNode == null) {
                    bigNode = new LinkedListNode(node.data, null, null);
                    bigHeadNode = bigNode;
                } else {
                    bigNode.next = new LinkedListNode(node.data, null, null);
                    bigNode = bigNode.next;
                }
            }
            node = node.next;
            if (node == null) {
                break;
            }
        }
        smallLastNode.next = bigHeadNode;

        printNode(head);
        printNode(smallHeadNode);
        printNode(bigHeadNode);

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
