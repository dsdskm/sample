package com.kkh.coupang.test;

import java.util.Arrays;

public class Coupang_Test2 {
    public static void main(String args[]) {
        new Coupang_Test2();
    }

    public Coupang_Test2() {
//        System.out.println(solution(new int[]{20, 8, 10, 1, 4, 15}));   // 62
//        System.out.println(solution(new int[]{20, 8, 10, 1, 4, 15, 22}));   // 62
        System.out.println(solution(new int[]{100, 90}));   // 20
        System.out.println(solution(new int[]{
                1,2,3,4,5,6,7,8
        }));   // 20
    }

    public int solution(int[] v) {
        int answer = 0;
        Arrays.sort(v);

        int[] best_arr = new int[v.length];
        int len = v.length;
        int mid = (len / 2) - 1;

        boolean isBigTime = true;
        int big_index = len - 1;
        int small_index = 0;
        int index = mid;
        int right_index = mid + 1;
        int left_index = mid - 1;
        int insert_count = 0;
        while (true) {
            if (isBigTime) {
                // 큰수 넣는다

                if (best_arr[mid] != 0) {
                    // 가운데가 이미 채워졌다면 양쪽에 두개씩 넣는다
                    if (right_index <= len - 1) {
                        best_arr[right_index] = v[big_index];
                        insert_count++;
                        big_index--;
                    }
                    if (left_index >= 0) {
                        best_arr[left_index] = v[big_index];
                        insert_count++;
                        big_index--;
                    }

                    left_index--;
                    right_index++;
                } else {
                    best_arr[index] = v[big_index--];
                    insert_count++;
                }
            } else {
                // 작은수 넣는다
                if (right_index <= len - 1) {
                    best_arr[right_index] = v[small_index];
                    insert_count++;
                    small_index++;
                }
                if (left_index >= 0) {
                    best_arr[left_index] = v[small_index];
                    insert_count++;
                    small_index++;
                }

                left_index--;
                right_index++;
            }

            isBigTime = !isBigTime;
            if(insert_count == best_arr.length){
                break;
            }
            if (right_index > len && left_index < 0) {
                break;
            }
        }

        int max_sum = 0;
        for (int i = 0; i < best_arr.length - 1; i++) {
            max_sum += Math.abs(best_arr[i] - best_arr[i + 1]);
            System.out.print(best_arr[i] + " ");
        }
        answer = max_sum;

        return answer;
    }
}
