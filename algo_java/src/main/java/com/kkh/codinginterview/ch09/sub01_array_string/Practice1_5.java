package com.kkh.codinginterview.ch09.sub01_array_string;

public class Practice1_5 {
    /*
    1.5 하나 빼기 : 문자열을 편집하는 방법에는 세 가지 종류가 있다.
	문자열 두 개가 주어졌을 때, 문자열을 같게 만들기 위한 편집 횟수가 회 이내인지 확인
     */
    public static void main(String args[]) {
        new Practice1_5();
    }

    public Practice1_5() {
        System.out.println(solution("pale", "ple"));
        System.out.println(solution("pales", "pale"));
        System.out.println(solution("pale", "bale"));
        System.out.println(solution("pale", "bake"));
        System.out.println(solution("pale", "paleKK"));
    }

    public boolean solution(String str1, String str2) {
        /*
        pale,ple -> true
        pales,pale -> true

        pale,bale -> true
        pale,bake -> false

        1. 길이가 다른 경우와 같은 경우 구분
         */
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 - len2 >= 2 || len2 - len1 >= 2) {
            return false;
        } else if (len1 > len2) {
            // 길이가 작은 문자열 길이만큼 반복
            // 문자열이 같다면 1차이 true, 다르다면 false
            return checkCaseForDiff(str1, str2);
        } else if (len1 < len2) {
            return checkCaseForDiff(str2, str1);
        } else {
            return checkCaseForSame(str1, str2);
        }
    }

    private boolean checkCaseForDiff(String big, String small) {
        // 큰문자열안에 작은 문자열이 모두 있으면 true

        int index = 0;
        for (int i = 0; i < small.length(); i++) {
            char c = small.charAt(index);
            if (big.indexOf(c) < 0) {
                return false;

            }
        }

        return true;
    }

    private boolean checkCaseForSame(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                diffCount++;
            }

            if (diffCount == 2) {
                return false;
            }
        }
        return true;
    }
}
