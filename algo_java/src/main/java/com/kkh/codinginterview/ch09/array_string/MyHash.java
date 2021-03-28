package com.kkh.codinginterview.ch09.array_string;

import java.util.LinkedList;

public class MyHash {

    public MyHash() {
        MyHashMap mhm = new MyHashMap();
        mhm.put("ABC", "Hello");
        mhm.put("ABC", "WOW");
        mhm.put("DEF", "MYMY");
        mhm.put("DEFG", "MYMYMY");
        System.out.println("get DEF : "+mhm.get("DEF"));
        System.out.println("get XYZ : "+mhm.get("XYZ"));
        mhm.print();
    }

    public static void main(String args[]) {
        new MyHash();
    }

    class MyHashMap {
        private int size = 10;
        private LinkedList<String[]>[] hashArray = new LinkedList[size];

        private int getIndex(String key){
            return key.length() % size;
        }

        public void remove(String key){
            int index = getIndex(key);
            for (Object o : hashArray[index]) {
                String v[] = (String[]) o;
                if (v[0].equalsIgnoreCase(key)) {
                    hashArray[index].remove(o);
                }
            }
        }

        public void put(String key, String value) {
            int index = getIndex(key);
            System.out.println("put key : " + key + " , value : " + value + " , index : " + index);
            if (hashArray[index] == null) {
                hashArray[index] = new LinkedList<>();

            }
            remove(key);
            hashArray[index].add(new String[]{key, value});
        }

        public String get(String key){
            int index = getIndex(key);
            if(hashArray[index]==null){
                return "EMPTY";
            }
            for (Object o : hashArray[index]) {
                String v[] = (String[]) o;
                if (v[0].equalsIgnoreCase(key)) {
                    return v[1];
                }
            }
            return "EMPTY";
        }

        public void print() {
            for (LinkedList ll : hashArray) {
                if (ll != null) {
                    for (Object o : ll) {
                        String v[] = (String[]) o;
                        System.out.println(v[0] + " , " + v[1]);
                    }
                }
            }
        }
    }

}
