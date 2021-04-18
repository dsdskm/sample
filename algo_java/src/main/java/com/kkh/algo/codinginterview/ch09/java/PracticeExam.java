package com.kkh.algo.codinginterview.ch09.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeExam {
    public static void main(String args[]) {
        new PracticeExam();
    }

    public PracticeExam() {
        JList<Integer> list = new JList<>();
        list.add(1);
        System.out.println("get : " + list.get(0));
        JList<String> list2 = new JList<>();
        list2.add("AAA");
        System.out.println("get : " + list2.get(0));
        InnerClass ic = new InnerClass();

        List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream result = ages.stream()
                .filter(x -> x > 3)
                .limit(3);
//        result.forEach(o ->
//                System.out.println(o));
        List<Integer> l = (List<Integer>) result.collect(Collectors.toList());
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }

    }

    public static class InnerClass {

    }
}

interface IJava {
    static void print() {

    }
}

class JList<T> {
    ArrayList<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    public T get(int index) {
        return list.get(index);
    }
}

class A {
    private A() {

    }

    private void print() {
        System.out.println("print");
    }

    class innerA extends A {
        public innerA() {
            print();
        }
    }
}

/*
상속 불가
class B extends A{

}

 */
