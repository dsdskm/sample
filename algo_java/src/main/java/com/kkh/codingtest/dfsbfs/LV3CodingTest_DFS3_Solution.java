package com.kkh.codingtest.dfsbfs;

public class LV3CodingTest_DFS3_Solution {
    public static void main(String args[]) {
        LV3CodingTest_DFS3_Solution l = new LV3CodingTest_DFS3_Solution();
        System.out.println(l.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(l.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println(l.solution("hit", "cog", new String[]{"hot", "dot", "dog", "loz", "log"}));

    }

    public int solution(String begin, String target, String[] words) {
        /*
        begin 에서 target으로 변환
        target이 words에 포함되어야한다
        가장 짧게 변환하는 과정
        hit->hot->dot->dog->cog


        1. 반복문을 돈다. checked array 만든다
        2. 한 단어 차이가 최소로 나는 단어를 찾는다
        3. 찾은 단어를 기준으로 반복문을 돈다
        4. 2.를 반복하되 이미 checked 된 단어는 제외한다
        5. 꼭 모든 단계를

        */

        boolean isChecked[] = new boolean[words.length];
        boolean hasTarget = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equalsIgnoreCase(words[i])) {
                hasTarget = true;
            }
        }
        int answer = 0;
        if (hasTarget) {
            answer = search(begin, target, words, isChecked, 0);
        }
        return answer;
    }

    private int search(String begin, String target, String[] words, boolean[] isChecked, int count) {
        //System.out.println("search begin : " + begin + " , count : " + count);
        if (begin.equalsIgnoreCase(target)) {
            return count;
        }

        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        for (int i = 0; i < words.length; i++) {
            String text = words[i];
            if (checkString(begin, text) > 0 && !isChecked[i]) {
                minDiff = Math.min(minDiff, checkString(begin, text));
                minDiffIndex = i;
            }
        }
        //System.out.println("minDiff : " + minDiff + " , minDiffIndex : " + minDiffIndex + " , begin : " + begin + " , str : " + words[minDiffIndex]);
        isChecked[minDiffIndex] = true;
        return search(words[minDiffIndex], target, words, isChecked, count + 1);
    }

    private int checkString(String text, String word) {
        int ret = -1;
        int diffCount = 0;
        for (int i = 0; i < text.length(); i++) {
            int diff = text.charAt(i) - word.charAt(i);
            if (diff != 0) {
                ret = Math.abs(diff);
                diffCount++;
            }
        }
        if (diffCount == 1) {
            return ret;
        } else {
            return -1;
        }
    }
}
