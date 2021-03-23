package com.kkh.codingtest.level1_test;

public class NewID {
    // https://programmers.co.kr/learn/courses/30/lessons/72410

    public static void main(String ags[]) {
        NewID n = new NewID();
        System.out.println(n.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(n.solution("z-+.^."));
        System.out.println(n.solution("=.="));
        System.out.println(n.solution("123_.def"));
        System.out.println(n.solution("abcdefghijklmn.p"));

        /*
        규칙에 맞지 않는 아이디를 규칙에 맞도록 추천
        3자이상 15자 이하
        소문자 숫자 - _ . 만 이용 가능
        .는 처음과 끝에 사용할 수 없음
        .는 연속으로 사용할 수 없음 -> 연속되는 경우 . 으로 교체

        7단계 순차처리를 통해 아이디 검사 이후 새로운 아이디 추천천

        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
             만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
         */

    }

    public String solution(String new_id) {

        // 1단계 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계 소문자, 숫자, - _ . 를 제외한 모든 문자 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((122 < c || c < 97) && (57 < c || c < 48) && c != '-' && c != '_' && c != '.') {
                continue;
            } else {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        //  3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        char prv;
        sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c == '.') {
                if (!sb.toString().endsWith(".")) {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }

        }
        new_id = sb.toString();
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id = new_id.concat(String.valueOf(c));
            }
        }

        return new_id;
    }
}
