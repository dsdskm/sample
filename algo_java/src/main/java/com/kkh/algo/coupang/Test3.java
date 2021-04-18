package com.kkh.algo.coupang;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Test3 {
    public static void main(String args[]) {

        Test3 t = new Test3();
//        t.solution(new String[]{
//                "DS7651 A0",
//                "CA0055 D+",
//                "AI5543 C0",
//                "0S1808 B-",
//                "DS7651 B+",
//                "AI0001 F",
//                "DB0001 B-",
//                "AI5543 D+",
//                "DS7651 A+",
//                "0S1808 B-"});
//        t.solution(new String[]{
//                "DM0106 D-",
//                "PL6677 B+",
//                "DM0106 B+",
//                "DM0106 B+",
//                "PL6677 C0",
//                "GP0000 A0",
        t.solution(new String[]{
                "DM0106 D-",
                "PL6677 B+",
                "DM0106 B+",
                "DM0106 B+",
                "PL6677 C0",
                "GP0000 A0",
        });

    }

    class Student implements Comparable<Student> {
        int order = 0;
        String name;
        String grade;
        int score = 0;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }


        @Override
        public int compareTo(@NotNull Student o) {
            if(o.score - this.score==0){
                return o.order - this.order;
            } else {
                return o.score - this.score;
            }

        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public String[] solution(String[] grades) {
        /*
        동일 수강이면 높은거 우선
        동일 수강 동일 점수면 먼저가 우선
         */
        HashMap<String, Integer> gradeHash = new HashMap<>();
        gradeHash.put("A+", 13);
        gradeHash.put("A0", 12);
        gradeHash.put("A-", 11);
        gradeHash.put("B+", 10);
        gradeHash.put("B0", 9);
        gradeHash.put("B-", 8);
        gradeHash.put("C+", 7);
        gradeHash.put("C0", 6);
        gradeHash.put("C-", 5);
        gradeHash.put("D+", 4);
        gradeHash.put("D0", 3);
        gradeHash.put("D-", 2);
        gradeHash.put("F", 1);
        HashMap<String, String> infoHash = new HashMap<>();
        for (int i = 0; i < grades.length; i++) {
            String grade = grades[i];
            System.out.println(grade);
            String infos[] = grade.split(" ");
            String name = infos[0];
            String g = infos[1];
            int score = gradeHash.get(g);
            if (infoHash.containsKey(name)) {
                String temp_grade = infoHash.get(name);
                System.out.println("name : "+name+" , temp_grade : "+temp_grade+" , g : "+g+" , "+temp_grade.equalsIgnoreCase(g));
                if (temp_grade.equalsIgnoreCase(g.trim())) {
                    continue;
                } else {
                    int temp_score = gradeHash.get(temp_grade);
                    if (temp_score < score) {
                        System.out.println("    replace : "+name);
                        infoHash.replace(name, g);
                    }
                }
            } else {
                System.out.println("    put : "+name);
                infoHash.put(name, g);
            }
        }

        ArrayList<Student> res = new ArrayList<>();

        Iterator iter = infoHash.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = infoHash.get(key);
            System.out.println("key : " + key + " , value : " + value);
            Student s = new Student();
            s.setName(key);
            s.setGrade(value);
            int score = gradeHash.get(value);
            s.setScore(score);
            res.add(s);
        }
        Collections.sort(res);
        String answer[] = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i).getName() + " " + res.get(i).getGrade();
            System.out.println(answer[i]);
        }

        return answer;
    }
}
