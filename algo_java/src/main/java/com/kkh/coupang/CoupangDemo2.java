package com.kkh.coupang;

import java.util.ArrayList;

public class CoupangDemo2 {


    public static void main(String args[]) {
        MyLinkedList mL = new MyLinkedList();
        System.out.println();
        mL.input(1);
        mL.input(2);
        mL.input(3);
        mL.input(4);
        mL.input(5);
        mL.input(6);
        mL.output(4);
        mL.printNode();
    }
}

class MyLinkedList {

    ArrayList<Integer> mList = new ArrayList<>();
    Node mParentNode;

    public void input(int n) {
        System.out.println("input");
        if (mParentNode == null) {
            mParentNode = new Node(n, null);
        } else {
            Node tmp = mParentNode;
            while (true) {
                System.out.println(tmp.value);
                if (tmp.next == null) {
                    break;
                }
                tmp = tmp.next;
            }
            tmp.next = new Node(n, null);
        }
        System.out.println("input end");
    }

    public void printNode() {
        System.out.println("printNode");
        if (mParentNode != null) {
            Node node = mParentNode;
            while (true) {
                System.out.print(node.value + " - ");
                node = node.next;
                if (node == null) {
                    break;
                }
            }
        }
        System.out.println();
    }

    public void output(int value) {
        System.out.println("output : "+value);
        Node node = mParentNode;
        while (true) {
            if (value == node.value) {
                mParentNode = node;
                break;
            }
            node = node.next;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
