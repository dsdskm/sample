package com.kkh.codingtest.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LV2_SkillTree {
    public static void main(String args[]) {
        LV2_SkillTree l = new LV2_SkillTree();
        System.out.println(l.solution("CBD", new String[]{"BACDE", "CBADFQWE", "AECB", "BDA"}));

    }

    public int solution(String skill, String[] skill_trees) {
        /*
        스킬 트리를 순회하면서 스킬과 비교한다


         */
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i];
            // 첫번째 스킬을 거치지 않았거나 첫번째 스킬이 뒤에 나온다면 fail
            // 모든 스킬을 다 수행하지 않아고 순서만 지켰다면 pass
            boolean isValid = true;
            int prvIndex = -1;
            for (int j = 0; j < skill.length(); j++) {
                int index = tree.indexOf(skill.charAt(j));
//                System.out.print("[" + j + "]" + index + " ");
                // 처음 indexOf가 0보다 큰 문자가 첫번째 문자가 아니라면 fail
                if (j == 0) {
                    if (index < 0) {
                        isValid = false;
                        break;
                    }
                }
                if(index!=-1 && index<prvIndex){
                    isValid = false;
                    break;
                }
                prvIndex = index;
            }
//            System.out.println();
            System.out.println("tree : " + tree + " , isValid : " + isValid);



            if(isValid){
                answer++;
            }
        }

        return answer;
    }

}
