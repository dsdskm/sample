package com.kkh.algo.codinginterview.ch09.sub01_array_string;

public class Practice1_9 {
    /*
    1.9 문자열 회전 : 한 단어가 다른 문자열에 포함되어 있는지를 판별하는 isSubstring이라는 메서드가 있다
	s1과 s의 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자 한다
	isSubstring 메서드를 한 번만 호출해서 판별할 수 있는 코드를 작성하라
     */
    public static void main(String args[]) {
        new Practice1_9();
    }

    public Practice1_9() {
        System.out.println(solution("waterbottle", "erbottlewat"));
    }

    private boolean solution(String str1, String str2) {
        /*
        1. 직접 회전해가면서 비교한다
        */
        for (int i = 1; i < str1.length(); i++) {
            String s1 = str1.substring(i);
            String s2 = str1.substring(0, i);
            System.out.println("s1 : " + s1 + " , s2 : " + s2);
            String s = s1.concat(s2);
            if (str2.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
