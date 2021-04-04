package com.kkh.codinginterview.ch09.sub01_array_string;

public class Practice1_1 {
    /*
    1.1 중복이 없는가:문자열이 주어졌을 때 이, 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
	자료구조를 추가로 사용하지 않고 구현
     */
    public static void main(String ags[]) {
        new Practice1_1();
    }

    public Practice1_1() {
        System.out.println(solution("ABCEA"));
    }

    private boolean solution(String str) {
        int len = 128;
        if (str.length() > len) {
            return false;
        }

        boolean arr[] = new boolean[len];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;

        // 시간 복잡도 O(n) => n:문자열 길이
        // 공간 복잡도 O(1) =>
    }
}
