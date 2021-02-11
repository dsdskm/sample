package com.kkh.codingtest.bruteforce;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CodingTest_BFS1 {

    class Score implements Comparable<Score> {

        int people;
        int count;
        int arr[];

        public Score(int people, int count, int[] arr) {
            this.people = people;
            this.count = count;
            this.arr = arr;
        }

        @Override
        public int compareTo(@NotNull Score o) {
            if (count > o.count) {
                return -1;
            } else if (count == o.count) {
                if (people < o.people) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Score{" +
                    "people=" + people +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String args[]) {
        new CodingTest_BFS1();
    }

    public CodingTest_BFS1() {
//        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
        solution(new int[]{1, 3, 2, 4, 2});
        //solution(new int[]{2, 1, 2, 3, 2, 4, 2, 5, 1, 3, 1, 3, 1});
    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5}; //이만큼씩 반복
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answer1 = 0, answer2 = 0, answer3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (person1[i % person1.length] == answers[i]) answer1++;
            if (person2[i % person2.length] == answers[i]) answer2++;
            if (person3[i % person3.length] == answers[i]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2), answer3); // max값 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max == answer1) list.add(1); //max값이랑 같으면 넣는다.
        if (max == answer2) list.add(2);
        if (max == answer3) list.add(3);

        answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
