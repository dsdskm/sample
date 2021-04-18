package com.kkh.algo.codinginterview.ch09.tree;

public class Practice {
    //https://madplay.github.io/post/binary-search-tree-in-java
    public static void main(String args[]) {
        new Practice();
    }

    public Practice() {
        BstNode bst = new BstNode();
        bst.insert(2);
        bst.insert(5);
        bst.insert(1);
        bst.insert(6);
        bst.insert(7);
        bst.insert(4);
        bst.remove(2);  // leaf node;
        bst.print();
    }
}

class BstNode {

    BNode root;

    public void insert(int value) {
        if (root == null) {
            root = new BNode(value);
            return;
        }

        add(root, value);
    }

    public void add(BNode node, int value) {
        int c = node.value;
        if (value < c) {
            if (node.left == null) {
                node.left = new BNode(value);
            } else {
                add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new BNode(value);
            } else {
                add(node.right, value);
            }
        }
    }

    public void print() {
        search(root);
    }

    private void search(BNode node) {
        if (node != null) {
            search(node.left);
            System.out.println("node : " + node.value);
            search(node.right);
        }
    }

    public void remove(int value) {
        BNode node = root;
        BNode parentNode = null;
        // 노드 찾음
        while (node.value != value) {
            parentNode = node;
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }

            if (node == null) {
                return;
            }
        }


        if (node.left == null && node.right == null) {
            System.out.println("child is 0");
            // child 0
            // root node
            if (node == root) {
                root = null;
            } else if (node == parentNode.right) {
                parentNode.right = null;
            } else {
                parentNode.left = null;
            }
        } else if (node.left != null && node.right != null) {
            System.out.println("child is 2");
            // child 2
            // 둘중 하나를 올려야한다
            // 좌측에서 가장 큰놈 or 우측에서 가장 작은놈
            if (node == root) {
                root = findBigInLeft(node.left);
                root.right = node.right;
            } else if (node == parentNode.left) {
                // 왼쪽 방향 노드
                // 부모의 왼쪽과 node의 왼쪽 연결
                // 부모의 오른쪽에 새로운 노드 연결
                BNode newNode = findBigInLeft(node);
                newNode.right = node.right;
                newNode.left = node.left;
                parentNode.left = node;

            } else {
                // 오른쪽 방향 노드
                // 부모의 오른쪽과 node의 오른쪽 연결
                // 부모의 오른쪽에 새로운 노드 연결
                BNode newNode = findBigInLeft(node);
                newNode.right = node.right;
                newNode.left = node.left;
                parentNode.right = node;
            }
        } else {
            if (node == parentNode.left) {
                if (node.left != null) {
                    parentNode.left = node.left;
                } else {
                    parentNode.left = node.right;
                }

            } else {
                if (node.left != null) {
                    parentNode.right = node.left;
                } else {
                    parentNode.right = node.right;
                }
            }
        }
    }

    private BNode findBigInLeft(BNode left) {
        BNode parent = null;
        while (left.right != null) {
            parent = left;
            left = left.right;
        }
        if (parent != null) {
            parent.right = null;
        }
        return left;
    }
}

class BNode {
    int value;
    BNode left;
    BNode right;

    public BNode(int value) {
        this.value = value;
    }
}


