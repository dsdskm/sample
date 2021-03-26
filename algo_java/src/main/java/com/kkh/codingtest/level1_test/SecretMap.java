package com.kkh.codingtest.level1_test;

public class SecretMap {
    public static void main(String args[]) {
        SecretMap s = new SecretMap();
        s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        /*
        지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
        전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
        각각 "지도 1"과 "지도 2"라고 하자.
        지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
        지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
        "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
        암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
         */
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        /*
        1. arr1 = arr2 길이가 같다
        2. 각 배열을 2차원 배열로 변환한다
        3. 교차한다
         */


        int map1[][] = getArray(arr1, n);
        int map2[][] = getArray(arr2, n);
        char resultMap[][] = new char[n][n];
        String[] answer = new String[n];
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[i].length; j++) {
                if (map1[i][j] == 1 && map2[i][j] == 1) {
                    resultMap[i][j] = '#';
                } else if (map1[i][j] == 0 && map2[i][j] == 0) {
                    resultMap[i][j] = ' ';
                } else {
                    resultMap[i][j] = '#';
                }
            }
            answer[i] = new String(resultMap[i]);
        }


        return answer;
    }

    private int[][] getArray(int[] arr1, int n) {
        int result[][] = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            String num = Integer.toBinaryString(arr1[i]);

            while (num.length() < n) {
                num = "0".concat(num);
            }
            for (int j = 0; j < result.length; j++) {
                result[i][j] = Character.getNumericValue(num.charAt(j));
            }
        }
        return result;
    }
}
