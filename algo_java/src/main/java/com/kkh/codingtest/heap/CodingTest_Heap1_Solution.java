package com.kkh.codingtest.heap;

import java.util.*;

import static com.kkh.algo.Utils.print;

public class CodingTest_Heap1_Solution {
    public static void main(String args[]) {
        new CodingTest_Heap1_Solution();
    }


    public CodingTest_Heap1_Solution() {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
//        System.out.println(solution(new int[]{5, 5, 5, 5, 5, 5}, 7));
    }
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

    int search_data1 = -1;
    int search_data2 = -1;

    class MySco implements Comparable<MySco> {
        private int mValue;

        public MySco(int value) {
            mValue = value;
        }


        @Override
        public int compareTo(MySco o) {
            if (mValue < o.mValue) {
                return -1;
            } else if (mValue == o.mValue) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "MySco{" +
                    "mValue=" + mValue +
                    '}';
        }
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // Tree 형태로 추가
        for (int i = 0; i < scoville.length; i++) {
            insertNode(scoville[i]);
        }

        PriorityQueue<MySco> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(new MySco(scoville[i]));
        }

        while (true) {
            answer++;
            if (queue.size() == 1) {
                answer = -1;
                break;
            }
            System.out.println(queue);
            MySco ms1 = queue.poll();
            MySco ms2 = queue.poll();
            queue.offer(new MySco(ms1.mValue + (ms2.mValue * 2)));
            if (queue.peek().mValue >= K) {
                break;
            }

        }
        return answer;
    }

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

    Node root = null;

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
            if (search_data1 < 0) {
                search_data1 = node.data;
            } else {
                if (search_data2 < 0) {
                    search_data2 = node.data;
                }
            }
//            print(" data = " + node.data);
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
