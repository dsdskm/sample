package com.kkh.coupang.practice;

public class TreeTest {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public TreeTest() {

    }

    public static void main(String args[]) {
        TreeTest tt = new TreeTest();
        tt.add(5);
        tt.add(1);
        tt.add(9);
        tt.search();
    }

    private void search() {
        searchNode(mParent);
        System.out.println();
        searchNode2(mParent);
        System.out.println();
        searchNode3(mParent);
        System.out.println();
    }

    private void searchNode(Node node) {
        if (node == null) {
            return;
        }
        searchNode(node.left);
        System.out.println("[" + node.value + "]");
        searchNode(node.right);
    }

    private void searchNode2(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("[" + node.value + "]");
        searchNode2(node.left);
        searchNode2(node.right);
    }

    private void searchNode3(Node node) {
        if (node == null) {
            return;
        }
        searchNode3(node.left);
        searchNode3(node.right);
        System.out.println("[" + node.value + "]");
    }

    private Node mParent;

    private void add(int value) {
        if (mParent == null) {
            mParent = new Node(value);
        } else {
            Node node = mParent;
            while (true) {
                if (node.value > value) {
                    if (node.left == null) {
                        node.left = new Node(value);
                        System.out.println("add left Node : " + value);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(value);
                        System.out.println("add right Node : " + value);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }
}
