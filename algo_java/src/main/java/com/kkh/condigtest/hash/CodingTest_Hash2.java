package com.kkh.condigtest.hash;

import java.util.Arrays;

public class CodingTest_Hash2 {
    public static void main(String args[]) {

        new CodingTest_Hash2();
    }

    public CodingTest_Hash2() {
//        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
//        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235","567","88"}));
    }

    public boolean solution(String[] phone_book) {
        // 접두어 중복이 있으면 false 없으면 true

        boolean answer = true;
        Arrays.sort(phone_book);
        // 정렬후 다음 원소랑만 비교하면 된다
        String prv = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(prv)) {
                answer = false;
                break;
            }

        }
        return answer;
    }
}
