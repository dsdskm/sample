package com.kkh.codingtest.level2_test;

import java.util.*;

public class RankSearch {

    // https://programmers.co.kr/learn/courses/30/lessons/72412
    public static void main(String args[]) {

        RankSearch r = new RankSearch();
        r.solution(new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"});
        /*
         개발언어 cpp, java, python
         직군 backend, frontend
         경력 junior, senior
         선호 chicken, pizza

         [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?

         1. custom class를 만든다(name, set)
         2. 각 class에 name과 set을 초기화한다
         3. query내용을 list에서 찾는다
         */
    }

    class Emp {
        String name;
        int score;
        Set<String> set = new HashSet<>();

        public void addSet(String lan, String category, String exp, String food) {
            set.add(lan);
            set.add(category);
            set.add(exp);
            set.add(food);
        }

        public Set<String> getSet() {
            return set;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "score=" + score +
                    ", set=" + set +
                    '}';
        }

        public boolean matched(String[] tokens) {
            boolean isMatched = true;
            //System.out.println("matched set : " + this.set);
            String[] last = tokens[tokens.length - 1].split(" ");
            String scoreStr = last[2];
            int score = Integer.parseInt(scoreStr);
            if (score < this.score) {
                return false;
            }

            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i].trim();
                if (i == tokens.length - 1) {
                    String[] temp = tokens[i].split(" ");
                    token = temp[1];
                }

                if (!set.contains(token) && !token.equalsIgnoreCase("-")) {
                    isMatched = false;
                }


            }
            return isMatched;
        }
    }

    public int[] solution(String[] info, String[] query) {

        ArrayList<String>[] array = new ArrayList[info.length];
        int scoreArray[] = new int[query.length];

        Arrays.fill(array, new ArrayList<String>());

        for (int i = 0; i < info.length; i++) {
            String tokens[] = info[i].split(" ");
            array[i] = new ArrayList<>();
            for (int j = 0; j < tokens.length; j++) {
                array[i].add(tokens[j]);
            }
        }

        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < query.length; i++) {
                String tokens[] = query[i].split(" and ");
                boolean isMatched = true;
                int score = 0;
                for (int j = 0; j < tokens.length; j++) {
                    String token;
                    if (j == tokens.length - 1) {
                        String s[] = tokens[j].split(" ");
                        token = s[0];
                        score = Integer.parseInt(s[1]);
                    } else {
                        token = tokens[j];
                    }
                    if (!array[k].contains(token) && !token.equalsIgnoreCase("-")) {
                        isMatched = false;
                        break;
                    }
                }

                if (isMatched) {
                    int empScore = Integer.parseInt(array[k].get(array[k].size()-1));
                    if (empScore < score) {
                        isMatched = false;
                    }
                }

                if (isMatched) {
                    scoreArray[i] += 1;
                }
            }
        }
        int answer[] = scoreArray;
        return answer;
    }

}
