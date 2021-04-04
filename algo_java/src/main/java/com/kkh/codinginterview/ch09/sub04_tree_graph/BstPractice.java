package com.kkh.codinginterview.ch09.sub04_tree_graph;

public class BstPractice {

    static class BstNode {
        int value;
        BstNode left, right;

        public BstNode(int v) {
            value = v;
        }
    }

    BstNode root;

    public void insert(int v) {
        if (root == null) {
            root = new BstNode(v);
        } else {
            search(root, v);
        }
    }

    public void print() {
        printNode(root);
    }

    private void printNode(BstNode node) {
        if (node == null) {
            return;
        }
        printNode(node.left);
        System.out.println(node.value);
        printNode(node.right);
    }

    private void search(BstNode node, int v) {
        if (node.value < v) {
            if (node.right != null) {
                search(node.right, v);
            } else {
                node.right = new BstNode(v);
            }
        } else {
            if (node.left != null) {
                search(node.left, v);
            } else {
                node.left = new BstNode(v);
            }
        }
    }
}
