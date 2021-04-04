package com.kkh.codinginterview.ch09.sub01_array_string;

import java.util.Hashtable;
import java.util.Iterator;

public class Practice1_4 {
    /*
    1.4 회문순열 : 주어진 문자열이 회문의 순열인지 아닌지 확인하는 함수
	회문이랑 앞으로 읽으나 뒤로 읽으나 같은 단어
     */
    public static void main(String args[]) {
        new Practice1_4();
    }

    public Practice1_4() {
        System.out.println(solution("tact coa"));
        System.out.println(solution("tact coa"));
    }

    public boolean solution(String str) {
        /*
        1. 문자열에 등장하는 각 문자의 개수를 센다
        2. 하나의 문자만 홀수개이고 나머지가 짝수개이면 회문이 가능하다
         */
        str = str.replace(" ","");
        Hashtable<Character, Integer> table = new Hashtable<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (table.containsKey(c)) {
                int count = table.get(c);
                table.replace(c, count + 1);
            } else {
                table.put(c, 1);
            }
        }

        Iterator iter = table.keySet().iterator();
        int oddCount = 0;
        while (iter.hasNext()) {
            char c = (char) iter.next();
            int count = table.get(c);
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount >= 2) {
            return false;
        }
        return true;
    }
}
