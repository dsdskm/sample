package com.kkh.codinginterview.ch09.array_string;

import java.util.Hashtable;

public class P136 {
    public P136(){
        exam1();
        exam3();
        exam4();
    }

    private void exam4(){
        System.out.println("exam4");
        System.out.println(solution4("pale","ple"));
        System.out.println(solution4("pales","pale"));
        System.out.println(solution4("pale","bale"));
        System.out.println(solution4("pale","bake"));
    }

    private boolean solution4(String str1,String str2){
        if(str1.length() > str2.length()){
            String tmp = str2;
            str2 = str1;
            str1 = tmp;
        }
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(c1-c2!=0){
                diff++;
            }
        }
        if(str1.length()!=str2.length()){
            if(diff==0){
                return true;
            } else {
                return false;
            }
        } else {
            if(diff<=1){
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
        return str.replace(" ","%20");
    }

    public static void main(String args[]){
        new P136();
    }

    public void exam1(){
        /*
        문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 작성
        자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 고민
         */
        String str = "ABCDEFAA";
        Hashtable<Character,Boolean> hashtable = new Hashtable<>();

        boolean ret = false;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(hashtable.containsKey(c)){
                ret = true;
                break;
            } else {
                hashtable.put(c,true);

            }
        }
        System.out.println("ret : "+ret);

    }

}
