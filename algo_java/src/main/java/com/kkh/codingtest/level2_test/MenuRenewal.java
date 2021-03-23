package com.kkh.codingtest.level2_test;

import java.util.*;

public class MenuRenewal {
    //https://programmers.co.kr/learn/courses/30/lessons/72411
    private String[] orders;
    private int[] courseLengths;

    private List<String> answer = new ArrayList<>();
    private Set<String> checkedCourses = new HashSet<>();
    private List<String> combinations;
    private List<Course> candidates;
    private int maxCountOnCurrentLength;

    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        this.courseLengths = course;
        findAvailableCourses();
        this.answer.sort(String::compareTo);
        return this.answer.toArray(new String[0]);
    }

    private void findAvailableCourses() {
        for (int length : this.courseLengths) {
            this.candidates = new ArrayList<>();
            this.maxCountOnCurrentLength = 0;
            for (String order : this.orders) {
                makeCombinations(order, length);
                if (!this.combinations.isEmpty())
                    findCandidateCourses();
            }
            getAnswerFromCandidates();
        }
    }

    private void makeCombinations(String order, int length) {
        char[] menus = order.toCharArray();
        boolean[] visited = new boolean[menus.length];
        char[] result = new char[menus.length];
        this.combinations = new ArrayList<>();
        doCombination(menus, visited, result, length, 0, 0);
    }

    private void doCombination(char[] menus, boolean[] visited, char[] result, int length, int start, int depth) {
        if (depth == length) {
            this.combinations.add(new String(result).trim());
            return;
        }

        for (int i = start; i < menus.length; i++) {
            visited[i] = true;
            result[depth] = menus[i];
            doCombination(menus, visited, result, length, i + 1, depth + 1);
            visited[i] = false;
            result[depth] = 0;
        }
    }

    private void findCandidateCourses() {
        for (String course : this.combinations) {
            course = sortString(course);
            if (!this.checkedCourses.contains(course)) {
                this.checkedCourses.add(course);
                int orderedCount = getOrderedCount(course);
                if (orderedCount > 1) {
                    this.candidates.add(new Course(course, orderedCount));
                    this.maxCountOnCurrentLength = Math.max(this.maxCountOnCurrentLength, orderedCount);
                }
            }
        }
    }

    private String sortString(String course) {
        char[] courseArr = course.toCharArray();
        Arrays.sort(courseArr);
        return new String(courseArr);
    }

    private int getOrderedCount(String course) {
        int count = 0;
        for (String order : this.orders)
            if (orderContainCourse(order, course)) count++;
        return count;
    }

    private boolean orderContainCourse(String order, String course) {
        for (char menu : course.toCharArray())
            if (!order.contains(menu + "")) return false;
        return true;
    }

    private void getAnswerFromCandidates() {
        for (Course candidate : this.candidates)
            if (candidate.orderedCount == this.maxCountOnCurrentLength)
                this.answer.add(candidate.menus);
    }
}

class Course {
    String menus;
    int orderedCount;

    public Course(String menus, int orderedCount) {
        this.menus = menus;
        this.orderedCount = orderedCount;
    }
}
