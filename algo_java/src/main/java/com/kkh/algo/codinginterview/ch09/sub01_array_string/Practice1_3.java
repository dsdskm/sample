package com.kkh.algo.codinginterview.ch09.sub01_array_string;

public class Practice1_3 {
    /*
    1.3 문자열에 있는 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라
	최종적으로 모든 문자를 다 담을 수 있는 만큼 충분한 공간이 이미 있다
	문자열의 최종 길이가 함께 주어진다
     */
    public static void main(String ags[]) {
        new Practice1_3();
    }

    public Practice1_3() {
        System.out.println(solution("Mr John Smith", 13));
    }

    private String solution(String s, int len) {
        /*
        1. s를 순회하면서 char 배열에 넣는다
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                len+=2;
            }
        }
        char ret[] = new char[len];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                ret[index] = '%';
                ret[index + 1] = '2';
                ret[index + 2] = '0';
                index += 3;
            } else {
                ret[index++] = c;
            }
        }

        return new String(ret);
    }
}
