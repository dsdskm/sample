package com.kkh.algo.codinginterview.ch09.sub10_sort;

public class Practice10_4 {
    public static void main(String args[]) {
        new Practice10_4();
    }

    public Practice10_4() {
        Listy listy = new Listy();
        listy.add(1);
        listy.add(3);
        listy.add(5);
        listy.add(7);
        listy.add(9);
        listy.add(11);
        listy.print();
        System.out.println(listy.elementAt(3));
        System.out.println(listy.elementAt(10));
    }

    class Listy {
        int index = 0;
        int arr[] = new int[1];

        public void add(int value) {
            if (index == arr.length) {
                int tmp[] = new int[arr.length * 2];
                System.arraycopy(arr, 0, tmp, 0, arr.length);
                arr = tmp;
            }
            arr[index++] = value;
        }

        public int elementAt(int index) {
            if (index >= arr.length) {
                return -1;
            } else {
                return arr[index];
            }
        }

        public void print() {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
