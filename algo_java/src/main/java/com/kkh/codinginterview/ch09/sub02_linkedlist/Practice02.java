package com.kkh.codinginterview.ch09.sub02_linkedlist;

public class Practice02 {

    class MyLinkedList {
        MyNode root;
        int size = 0;

        public void addNode(int value) {
            if (root == null) {
                root = new MyNode(value, null);
            } else {
                MyNode tmp = root;
                while (tmp.nextNode != null) {
                    tmp = tmp.nextNode;
                }
                tmp.nextNode = new MyNode(value, tmp);
            }
            size++;
        }

        public void addNode(String value) {
            if (root == null) {
                root = new MyNode(value, null);
            } else {
                MyNode tmp = root;
                while (tmp.nextNode != null) {
                    tmp = tmp.nextNode;
                }
                tmp.nextNode = new MyNode(value, tmp);
            }
            size++;
        }

        public void print() {
            System.out.println("size : " + getSize());
            MyNode node = root;
            System.out.print(node.value + " ");
            while (node.nextNode != null) {
                node = node.nextNode;
                System.out.print(node.value + " ");
            }
            System.out.println();
        }

        public int getSize() {
            return size - 1;
        }

        public int get(int index) {
            int count = 0;
            int ret = 0;
            MyNode node = root;
            while (node.nextNode != null) {
                if (count == index) {
                    ret = (int) node.value;
                    break;
                }
                node = node.nextNode;
                count++;

            }
            return ret;
        }

        public void remove(int v) {
            MyNode node = root;
            while (node.nextNode != null) {
                int value = (int) node.value;
                if (value == v) {
                    System.out.println("prv : " + node.prevNode.value + " , next : " + node.nextNode.value);
                    node.prevNode.nextNode = node.nextNode;
                    break;
                }
                node = node.nextNode;
            }
        }

        MyNode tmpRoot1;
        MyNode tmpRoot2;

        public void separate(int v, int base) {
           /*
           두 개의 루트 노드를 나중에 결합한다.
            */
            if (v < base) {
                if (tmpRoot1 == null) {
                    tmpRoot1 = new MyNode(v, null);
                } else {
                    MyNode m = tmpRoot1;
                    while (m.nextNode != null) {
                        m = m.nextNode;
                    }
                    m.nextNode = new MyNode(v, null);
                }

            } else {
                if (tmpRoot2 == null) {
                    tmpRoot2 = new MyNode(v, null);
                } else {
                    MyNode m = tmpRoot2;
                    while (m.nextNode != null) {
                        m = m.nextNode;
                    }
                    m.nextNode = new MyNode(v, null);
                }
            }
        }

        public String getSum() {
            MyNode node = root;
            System.out.println("getSum node : " + node.value);
            StringBuilder sb = new StringBuilder();
            while (node.nextNode != null) {
                sb.append(node.value);
                node = node.nextNode;
            }
            sb.append(node.value);
            return sb.reverse().toString();
        }

        public int[] getArr() {
            int answer[] = new int[size];
            int index = 0;
            MyNode node = root;
            while (node.nextNode != null) {
                answer[index++] = (int) node.value;
                node = node.nextNode;
            }
            answer[index] = (int) node.value;
            return answer;
        }

        public void makeCircular(String v1, String v2) {
            MyNode node = root;
            MyNode node1 = null;
            while (node.nextNode != null) {
                System.out.println("node value : " + node.value);
                if (node.value.equals(v1)) {
                    node1 = node;
                    break;
                }
                node = node.nextNode;
            }
            if (node.value.equals(v1)) {
                node1 = node;
            }

            node = root;
            MyNode node2 = null;
            while (node.nextNode != null) {
                if (node.value.equals(v2)) {
                    node2 = node;
                    break;
                }
                node = node.nextNode;
            }
            if (node.value.equals(v2)) {
                node2 = node;
            }
            node1.nextNode = node2;
        }

        public void searchCircular() {
            System.out.println("searchCircular");
            MyNode node = root;
            node.checked = true;
            String value = "";
            while (node.nextNode != null) {
                if(node.nextNode.checked){
                    value = (String) node.nextNode.value;
                    break;
                }
                node.checked = true;
                node = node.nextNode;
            }
            System.out.println("value : "+value);
        }
    }

    class MyNode {
        Object value;
        MyNode nextNode;
        MyNode prevNode;
        boolean checked = false;

        public MyNode(int v, MyNode prv) {
            this.value = v;
            this.prevNode = prv;
        }

        public MyNode(String v, MyNode prv) {
            this.value = v;
            this.prevNode = prv;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "value=" + value +
                    ", nextNode=" + nextNode +
                    ", prevNode=" + prevNode +
                    '}';
        }
    }


    public static void main(String args[]) {
        new Practice02();
    }

    public Practice02() {

//        problem1();
//        problem2();
//        problem3();
//        problem4();
//        problem5();
//        problem6();
//        problem7();
        problem8();

    }

    private void problem8() {
        System.out.println("problem8");
        MyLinkedList l1 = new MyLinkedList();
        l1.addNode("A");
        l1.addNode("B");
        l1.addNode("C");
        l1.addNode("D");
        l1.addNode("E");
        l1.makeCircular("E", "C");
        l1.searchCircular();
    }

    private void problem7() {
        System.out.println("problem7");

    }

    private void problem6() {
        System.out.println("problem6");
        MyLinkedList l1 = new MyLinkedList();
        l1.addNode(7);
        l1.addNode(1);
        l1.addNode(6);
        l1.addNode(4);
        l1.addNode(1);
        l1.addNode(7);
        System.out.println(solution6(l1));
    }

    private boolean solution6(MyLinkedList l1) {
        int arr[] = l1.getArr();
        boolean isPalindrome = true;
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] != arr[arr.length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println();
        return isPalindrome;
    }

    private void problem5() {
        System.out.println("problem5");
        /*
        리스트의 합

         */
        MyLinkedList l1 = new MyLinkedList();
        l1.addNode(7);
        l1.addNode(1);
        l1.addNode(6);
        MyLinkedList l2 = new MyLinkedList();
        l2.addNode(5);
        l2.addNode(9);
        l2.addNode(2);

        solution5(l1, l2);

    }

    private void solution5(MyLinkedList l1, MyLinkedList l2) {
        l1.print();
        int sum1 = Integer.parseInt(l1.getSum());
        int sum2 = Integer.parseInt(l2.getSum());
        String sum = String.valueOf(sum1 + sum2);
        MyLinkedList r = new MyLinkedList();
        for (int i = sum.length() - 1; i >= 0; i--) {
            int c = Character.getNumericValue(sum.charAt(i));
            r.addNode(c);
        }
        r.print();

    }

    private void problem4() {
        System.out.println("problem4");
        /*
        리스트 분할
        값 x가 주어졌을 떄 x보다 작은 노드들을 x보다 크거나 같은 노드들보다 앞에 오도록 하는 코드
         */
        MyLinkedList list = new MyLinkedList();
        list.separate(3, 5);
        list.separate(5, 5);
        list.separate(8, 5);
        list.separate(5, 5);
        list.separate(10, 5);
        list.separate(2, 5);
        list.separate(1, 5);
    }

    private void problem3() {
        System.out.println("problem3");
        /*
        중간 노드 삭제
         */

        MyLinkedList list = new MyLinkedList();
        list.addNode(1);
        list.addNode(3);
        list.addNode(5);
        list.addNode(7);
        list.addNode(9);
        list.addNode(11);
        System.out.println("5 삭제");
        list.print();
        list.remove(5);
        list.print();

    }

    private void problem2() {
        System.out.println("problem2");
        /*
        뒤에서 k번째 원소 구하기 : 단방향 연결리스트가 주어졌을 때 뒤에서 k번째 원소를 찾는 알고리즘
         */

        MyLinkedList list = new MyLinkedList();
        list.addNode(1);
        list.addNode(3);
        list.addNode(5);
        list.addNode(7);
        list.addNode(9);
        list.addNode(11);
        list.print();

        int k = 2;
        System.out.println("뒤에서 k(" + k + ") 번째 : " + list.get(list.getSize() - k + 1));
    }

    private void problem1() {
        /*
        중복 없애기 : 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라
        임시 버퍼를 사용할 수 없다면?

         */


    }

}
