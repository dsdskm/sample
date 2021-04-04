package com.kkh.codinginterview.ch09.sub04_tree_graph;

public class Practice4_2 {
    /*
    4.2 최소 트리 : 오름차순으로 정렬된 배열이 있다. 이 배열 안에 들어 있는 원소는 정수이며 중복된 값이 없다
	높이가 최소가 되는 이진 탐색 트리를 만들어라
     */
    public static void main(String args[]) {
        new Practice4_2();
    }

    public Practice4_2() {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};

        /*
        매 insert 마다 인덱스 절반의 값을 넣어야 한다
         */
        BstPractice.BstNode root = createMinimalBST(arr, 0, arr.length - 1);

        printNode(root);
    }

    private void printNode(BstPractice.BstNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        printNode(node.left);
        printNode(node.right);
    }

    BstPractice.BstNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        BstPractice.BstNode n = new BstPractice.BstNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }


}
