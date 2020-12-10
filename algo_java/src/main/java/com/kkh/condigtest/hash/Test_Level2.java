package com.kkh.condigtest.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test_Level2 {

    public Test_Level2() {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235","567","88"}));
    }

    public static void main(String args[]) {
        new Test_Level2();
    }

    public boolean solution(String[] phone_book) {
        // 전화 번호 부 중 한 번호가 다른 번호의 접두어인지 확인
        // 접두어가 있으면 false
        // 접두어가 없으면 true

        // 순차적으로 해쉬 값으로 등록
        // 해쉬 등록전 키값 startwith 체크
        boolean answer = true;
        HashMap<String, String> hash = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            Set<String> keySet = hash.keySet();
            Iterator iter = keySet.iterator();
            while (iter.hasNext()) {
                String key = String.valueOf(iter.next());
                if (phone.startsWith(key) || key.startsWith(phone)) {
                    answer = false;
                    break;
                }
            }
            hash.put(phone,phone);
        }

        return answer;
    }

    private void display(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            System.out.println(phone_book[i]);
        }
    }

}
