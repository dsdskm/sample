package com.kkh.codingtest.greedy;

import java.util.Arrays;

public class CodingTest_Greedy4 {

    public static void main(String args[]) {
        new CodingTest_Greedy4();
    }

    public CodingTest_Greedy4() {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int index = people.length - 1;
        for (int i = 0; i <= index; i++, answer++)
            while (index > i && people[i] + people[index--] > limit)
                answer++;

        return answer;
    }

}
