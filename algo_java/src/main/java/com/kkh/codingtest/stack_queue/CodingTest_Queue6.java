package com.kkh.codingtest.stack_queue;

import java.util.ArrayList;

public class CodingTest_Queue6 {
    public static void main(String args[]) {
        new CodingTest_Queue6();
    }

    public CodingTest_Queue6() {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
//        System.out.println(solution(new int[]{1, 1, 9, 1, 1,1}, 0));
    }


    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList a = new ArrayList<Integer>();

        // ArrayList
        ArrayList p = new ArrayList<Integer>(progresses.length);
        ArrayList s = new ArrayList<Integer>(speeds.length);
        for (int e : progresses)
            p.add(Integer.valueOf(e));
        for (int e : speeds)
            s.add(Integer.valueOf(e));

        // 반복문
        while (p.size() != 0) {
            int cnt = 0; // 배포 수

            // 하나씩 더하기
            for (int i = 0; i < p.size(); i += 1)
                p.set(i, (int) p.get(i) + (int) s.get(i));

            // 100 넘는 것 처리
            while (p.size() != 0) {
                if ((int) p.get(0) >= 100) {
                    cnt += 1;
                    p.remove(0);
                    s.remove(0);
                } else
                    break;
            }

            // 0이 아니면 정답 추가
            if (cnt != 0)
                a.add(cnt);
        }

        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++)
            answer[i] = (int) a.get(i);
        return answer;

    }

}
