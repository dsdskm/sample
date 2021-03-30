package com.kkh.codinginterview.ch09.array_string;

import java.util.Arrays;
import java.util.Hashtable;

public class Practice01 {
    public Practice01() {
        exam1();
        exam3();
        exam5();
        exam6();
        exam7();
        exam8();
        exam9();
    }

    private void exam9() {
        System.out.println("exam9");
        System.out.println(solution9("waterbottle", "erbottlewat"));
    }

    private boolean solution9(String str1, String str2) {
        /*
        한 단어가 다른 단어의 회전시킨 결과인지 판단
        2번째 단어에서 회전
        3번째 단어에서 회전
        ..n-1번쨰 단어에서 회전 하면서 확인한다
         */
        if (str1.equalsIgnoreCase(str2)) {
            return true;
        }

        if(str1.length()!=str2.length()){
            return false;
        }

        int index = 1;
        boolean ret = false;
        while(index<str1.length()){

            String t1 = str1.substring(0,index);
            String t2 = str1.substring(index);
            StringBuilder sb = new StringBuilder();
            sb.append(t2);
            sb.append(t1);
            if(sb.toString().equalsIgnoreCase(str2)){
                ret = true;
                break;
            }

            index++;
        }
        return ret;

    }

    private void exam8() {
        System.out.println("exam8");
        solution8(new int[][]{
                {1, 1, 1, 0},
                {2, 2, 2, 2},
                {3, 3, 3, 3,}
        });
    }

    private void solution8(int[][] arr) {
        boolean hasZero = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
        }

        if (hasZero) {
            Arrays.fill(arr, new int[]{0});
        }
    }

    private void exam7() {
        System.out.println("exam7");
        /*
        NxN 행렬을 90도 회전
        행렬을 추가사용하지 않고 하라
         */
        solution7(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        });
    }

    private void solution7(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int tmp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tmp[j][arr.length - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }

    }

    private void exam6() {
        System.out.println("exam6");
        /*
        반복되는 문자의 개수를 세는 문자열 압축 메서드
        aabccccaaa -> a2b1c5a3
        압축문자열의 길이가 더 긴경우 압축 문자열 리턴
         */
        System.out.println(solution6("aabcccccaaa"));
    }

    private String solution6(String str) {
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
        System.out.println(ret.toString());
        if (ret.toString().length() >= str.length()) {
            return ret.toString();
        } else {
            return str;
        }
    }


    private void exam5() {
        System.out.println("exam5");
        System.out.println(solution5("pale", "ple"));
        System.out.println(solution5("pales", "pale"));
        System.out.println(solution5("pale", "bale"));
        System.out.println(solution5("pale", "bake"));
    }

    private boolean solution5(String str1, String str2) {
        if (str1.length() > str2.length()) {
            String tmp = str2;
            str2 = str1;
            str1 = tmp;
        }
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 - c2 != 0) {
                diff++;
            }
        }
        if (str1.length() != str2.length()) {
            if (diff == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (diff <= 1) {
                return true;
            } else {
                return false;
            }
        }

    }


    private void exam3() {
        /*
        문자열에 들어 있는 모든 공백을 %20으로 바꿔주는 메서드를 작성
         */
        System.out.println(solution3("Mr John Smith"));

    }

    private String solution3(String str) {
        return str.replace(" ", "%20");
    }

    public static void main(String args[]) {
        new Practice01();
    }

    public void exam1() {
        /*
        문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 작성
        자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 고민
         */
        String str = "ABCDEFAA";
        Hashtable<Character, Boolean> hashtable = new Hashtable<>();

        boolean ret = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashtable.containsKey(c)) {
                ret = true;
                break;
            } else {
                hashtable.put(c, true);

            }
        }
        System.out.println("ret : " + ret);

    }

}
