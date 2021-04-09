package com.kkh.codingtest.level2_test;

public class Kakao_RankSearch {
    public static void main(String args[]) {
        new Kakao_RankSearch();
    }

    public Kakao_RankSearch() {
        /*
        cpp, java, python 중 하나를 선택
        지원자가 지원서에 입력한 4가지의 정보와 획득한 코딩테스트 점수를 하나의 문자열로 구성한 값의 배열 info,
        개발팀이 궁금해하는 문의조건이 문자열 형태로 담긴 배열 query가 매개변수로 주어질 때,
        각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
         */
        int res[] = solution(new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        }, new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        }); // 1,1,1,1,2,4

    }

    class Candidate {
        String lan;
        String skill;
        String level;
        String soulFood;
        int score;
        Candidate left, right;

        public Candidate(String lan, String skill, String level, String soulFood, String score) {
            this.lan = lan;
            this.skill = skill;
            this.level = level;
            this.soulFood = soulFood;
            this.score = Integer.parseInt(score);
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "lan='" + lan + '\'' +
                    ", skill='" + skill + '\'' +
                    ", level='" + level + '\'' +
                    ", soulFood='" + soulFood + '\'' +
                    ", score=" + score +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            Candidate c = (Candidate) obj;
            if (this.lan.equalsIgnoreCase(c.lan) || this.lan.equalsIgnoreCase("-") || c.lan.equalsIgnoreCase("-")) {
                if (this.skill.equalsIgnoreCase(c.skill) || this.skill.equalsIgnoreCase("-") || c.skill.equalsIgnoreCase("-")) {
                    if (this.level.equalsIgnoreCase(c.level) || this.level.equalsIgnoreCase("-") || c.level.equalsIgnoreCase("-")) {
                        if (this.soulFood.equalsIgnoreCase(c.soulFood) || this.soulFood.equalsIgnoreCase("-") || c.soulFood.equalsIgnoreCase("-")) {
                            if (this.score >= c.score) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        }
    }

    Candidate root;

    public void insert(Candidate c) {
        if (root == null) {
            root = c;
        } else {
            search(root, c);
        }
    }

    private void search(Candidate node, Candidate c) {
        if (node.score < c.score) {
            if (node.right != null) {
                search(node.right, c);
            } else {
                node.right = c;
            }
        } else {
            if (node.left != null) {
                search(node.left, c);
            } else {
                node.left = c;
            }
        }
    }

    private void printNode() {
        print(root);
    }

    private void print(Candidate node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.println(node.score);
        print(node.right);
    }

    private boolean searchNode(Candidate candidate) {
        return searchCandidate(root, candidate);
    }

    private boolean searchCandidate(Candidate node, Candidate candidate) {
        if (node == null) {
            return false;
        }

        if (node.score < candidate.score) {
            return searchCandidate(node.right, candidate);
        } else if (node.score > candidate.score) {
            return searchCandidate(node.left, candidate);
        } else {
            return node.equals(candidate);
        }
    }


    public int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            String text = info[i];
            String split[] = text.split(" ");
            Candidate candidate = new Candidate(split[0], split[1], split[2], split[3], split[4]);
            insert(candidate);
        }
        printNode();

//        // query
//        ArrayList<Candidate> queryList = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            String text = query[i];
            text = text.replace(" and ", " ");
            text = text.trim();
            String split[] = text.split(" ");
            Candidate candidate = new Candidate(split[0], split[1], split[2], split[3], split[4]);
            boolean result = searchNode(candidate);
            System.out.println("text : " + text + " , result : " + result);

        }
        int[] answer = new int[query.length];
//        for (int i = 0; i < queryList.size(); i++) {
//            int count = 0;
//            for (int j = 0; j < list.size(); j++) {
//                if (list.get(j).equals(queryList.get(i))) {
//                    count += 1;
//                }
//            }
//            answer[i] = count;
//
//        }
        return answer;
    }


}
