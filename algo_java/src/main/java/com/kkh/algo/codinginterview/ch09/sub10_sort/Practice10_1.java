package com.kkh.algo.codinginterview.ch09.sub10_sort;

public class Practice10_1 {
    public static void main(String args[]) {
        new Practice10_1();
    }

    public Practice10_1() {
        /*
        정렬된 배열 A와 B가 주어진다.
        A의 끝에는 B를 전부 넣을 수 있을 만큼 충분한 여유 공간이 있다.
        B와 A를 정렬된 상태로 병합하는 메서드를 작성하라
         */
        solution(new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0}, new int[]{2, 4, 6, 8});

    }

    public void solution(int A[], int B[]) {
        /*
        1. B와 A를 순회하면서 A에 넣어야 한다
        2. A에 넣을때 중간에 삽입하는 경우 배열 A를 전체적으로 shift해야한다

         */
        int res[] = new int[A.length];
        int indexA = 0;
        int lenA = 0;
        int indexB = 0;
        int indexRes = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                lenA = i + 1;
                break;
            }
        }
        while (true) {
            if (indexA < lenA && indexB < B.length) {
                if (A[indexA] <= B[indexB]) {
                    res[indexRes] = A[indexA++];
                } else {
                    res[indexRes] = B[indexB++];
                }
            } else {
                if (indexA < lenA && indexB >= B.length) {
                    res[indexRes] = A[indexA++];
                } else {
                    res[indexRes] = B[indexB++];
                }
            }
            indexRes++;
            if (indexRes == res.length) {
                break;
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }

}
