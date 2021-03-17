package com.kkh.codingtest.practice;

public class LV2_124 {
    public static void main(String args[]) {
        LV2_124 l = new LV2_124();
        System.out.println(l.solution(1));      //1
        System.out.println(l.solution(2));      //2
        System.out.println(l.solution(3));      //4
        System.out.println(l.solution(4));      //11
    }

    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while (num > 0) {
            int remainder = num % 3;
            num /= 3;

            if (remainder == 0) {
                num--;
            }
            answer = numbers[remainder] + answer;
        }

        return answer;
    }

    private void working(String[] defaultArr, String[] arr) {
        for (int i = 0; i < defaultArr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String v = defaultArr[i] + arr[j];
                System.out.println(v);
            }
        }
    }

}
