package com.kkh.exam.data_structure;

import java.util.TreeMap;
import java.util.TreeSet;

import static com.kkh.algo.Utils.print;
import static com.kkh.algo.Utils.println;

public class TreeExam {

    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }


    public static void main(String args[]) {
        new TreeExam();
    }

    public TreeExam() {
        /*
        TreeSet : 하나의 노드값만 사용
        TreeMap : key,value로 저장
        */

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(50, "A");
        treeMap.put(10, "B");
        treeMap.put(70, "C");
        treeMap.put(35, "D");
        treeMap.put(85, "E");
        System.out.println("TREE MAP");
        println(String.valueOf(treeMap));

        System.out.println("TREE SET");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(70);
        treeSet.add(30);
        treeSet.add(80);
        println(String.valueOf(treeSet));
        BST();
    }

    Node root = null;

    private void BST() {
        insertNode(70);
        insertNode(50);
        insertNode(90);
        insertNode(10);
        insertNode(30);
        insertNode(80);
        searchNode();
    }

    private void insertNode(int data) {
        if (root == null) {
            root = new Node(null, null, data);
            return;
        }

        insert(root, data);
    }

    private void insert(Node node, int data) {

        if (data < node.data) {
            if (node.left != null) {
                insert(node.left, data);
            } else {
                node.left = new Node(data);
            }
        } else {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                node.right = new Node(data);
            }
        }
    }

    private void searchNode() {
        search(root);
    }

    private void search(Node node) {
        if (node != null) {
            search(node.left);
            print(" data = " + node.data);
            search(node.right);
        }
    }

    private void deleteNode(int data) {
        // 삭제할 노드가 leaf
        // 삭제할 노드가 한 개 자식
        // 삭제할 노드가 두 개 자식
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        // 노드를 탐색
        while (current.data != data) {
            parent = current;
            if (current.data > data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return;
            }
        }

        // 삭제할 노드가 leaf
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }

            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // 자식이 하나인 경우
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }

        // 자식이 두개인 경우
        else if (current.left != null && current.right != null) {
            // 오른쪽 서브 트리의 최소값( or 왼쪽 서브 트리의 최대값)
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    public Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }


}
