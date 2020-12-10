package com.kkh.coupang.practice;

public class LinkedListTest {
    class Node {
        int mValue;
        int mData;
        Node mNextNode = null;

        public Node(int mValue) {
            this.mValue = mValue;
            this.mData = mValue * 10;
        }
    }

    public LinkedListTest() {

    }

    public static void main(String args[]) {
        LinkedListTest llt = new LinkedListTest();
        llt.addNode(1);
        llt.addNode(3);
        llt.addNode(5);
        llt.addNode(7);
        llt.addNode(8);
        llt.addNode(9);
        llt.addNode(10);
        llt.addNode(11);
        llt.addNode(12);
        llt.addNode(13);
        llt.addNode(14);

        System.out.println(llt.searchNode(7));
    }

    private int searchNode(int value) {
        int ret = -1;
        Node node = mParentNode;
        while (true) {
            if (value == node.mValue) {
                ret = node.mData;
                break;
            }
            if (node.mNextNode == null) {
                break;
            }
            node = node.mNextNode;
        }

        return ret;
    }

    private Node mParentNode = null;

    private void addNode(int value) {
        if (mParentNode == null) {
            mParentNode = new Node(value);
        } else {
            Node currentNode = mParentNode;
            while (true) {
                if (currentNode.mNextNode == null) {
                    currentNode.mNextNode = new Node(value);
                    break;
                }
                currentNode = currentNode.mNextNode;
            }
        }
    }


}
