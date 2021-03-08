package com.kkh.codingtest.bruteforce;

public class LV2CodingTest_BF3_Solution {
    /*
    Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
    Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
    Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
    노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
    카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

     */

    public static void main(String args[]) {
        LV2CodingTest_BF3_Solution l = new LV2CodingTest_BF3_Solution();
//        l.solution(10, 2);
        l.solution(8, 1);
//        l.solution(24, 24);

    }

    public int[] solution(int brown, int yellow) {

        /*
        1. 주어진 두 배열로 한 배열을 만들어야 한다
        2. 가로가 세로 보다 같거나 길다 => 노란색 갈색 모두
        3. 노란색으로 먼저 내부 사각형을 조합을 만든다
        4. 노란색으로 만든 사각형을 갈색이 감쌀수 있는지 확인한다
        */

        // yellow 의 약수를 모두 구하고 각각 곱 조합을 사각형으로 본다
        int answer[] = new int[0];
        if (yellow == 1) {
            answer = checkRect(1, 1, brown);
            if (answer.length > 0) {
                return answer;
            }
        } else {

            for (int i = 1; i <= yellow / 2; i++) {
                if (yellow % i == 0) {
                    int value1 = i;             // 가로
                    int value2 = yellow / i;    // 세로

                    // 가로가 세로보다 크거나 같도록 한다
                    int temp = 0;
                    if (value1 <= value2) {
                        temp = value1;
                        value1 = value2;
                        value2 = temp;
                    }
//                    System.out.println("value1 : " + value1 + " , value2 : " + value2);
                    answer = checkRect(value1, value2, brown);
                    if (answer.length > 0) {
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int[] checkRect(int value1, int value2, int brown) {
        int[] ret = new int[0];
        // 둘러싸고 있는게 오로지 한줄
        // 전체 가로 = (value1+2) *2;
        // 전체 세로 = value2 *2
        // 전체 블록 개수 = (value1+2)*2 + value2*2
        int total = (value1 + 2) * 2 + value2 * 2;
        if (brown == total) {
            int width = value1 + 2;
            int height = value2 + 2;
            ret = new int[]{width, height};
//            System.out.println("width : " + width + " , height : " + height);
        }
        return ret;
    }
}
