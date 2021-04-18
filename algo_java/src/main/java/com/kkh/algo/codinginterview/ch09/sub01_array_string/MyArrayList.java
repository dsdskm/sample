package com.kkh.algo.codinginterview.ch09.sub01_array_string;

public class MyArrayList {
    public MyArrayList() {
        MyArray ma = new MyArray();
        ma.add(0);
        ma.add(11);
        ma.add(22);
        ma.add(111);
        ma.add(222);
        ma.add(333);
        ma.add(444);
        ma.add(555);
        System.out.println(ma.get(6));
    }

    public static void main(String args[]) {
        new MyArrayList();
    }

    class MyArray {
        private int size = 5;
        private int[] array = new int[size];
        private int index = 0;

        public void add(int a) {
            if (index < array.length) {
                size *= 2;
                int tmp[] = new int[size];
                System.arraycopy(array, 0, tmp, 0, array.length);
                array = tmp;
            }
            array[index++] = a;
        }

        public int get(int index){
            return array[index];
        }
    }
}
