package com.kkh.codinginterview.ch09.sub01_array_string;

public class Practice1_6 {
    /*
    1.6 문자열 압축 : 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성
	aabccccaa를 압축하면 a2b1c5a3이 된다. 압축된 문자열의 길이가 기존 보다 길면 기존 문자열 반환
     */
    public static void main(String args[]) {
        new Practice1_6();
    }

    public Practice1_6() {
        System.out.println(solution("aabccccaa"));
        System.out.println(solution("aabccccaa"));
    }

    private String solution(String str) {
        char[] chars = str.toCharArray();
        char[] tmps = chars;
        StringBuilder ret = new StringBuilder();
        char prv = tmps[0];
        int count = 1;
        for (int i = 1; i < tmps.length; i++) {
            char c = tmps[i];
            if (prv == c) {
                count++;
                if (i == tmps.length - 1) {
                    ret.append(prv);
                    ret.append(count);
                }
            } else {
                ret.append(prv);
                ret.append(count);
                count = 1;
            }
            prv = c;
            System.out.println("c : " + c + " , count : " + count);

        }
        System.out.println(ret.length() + " , " + str.length());
        if (ret.toString().length() < str.length()) {
            return ret.toString();
        } else {
            return str;
        }
    }
}
