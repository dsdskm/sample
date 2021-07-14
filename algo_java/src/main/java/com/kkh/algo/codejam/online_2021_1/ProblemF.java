package com.kkh.algo.codejam.online_2021_1;

import com.kkh.Utils;

import java.io.*;
import java.util.*;

public class ProblemF {
    /*
    처음에는 n개의 정수를 포함한 집합 S0을 이용하여 자료 구조를 초기화 하며, 그 이후 q개의 연산을 수행하여 옳은 답을 출력해야한다.
    find_min(v): 현재 자료 구조에 저장된 정수 집합이 S라면, (v XOR s) 값이 최소가 되는 S의 원소 s를 찾아 (v XOR s) 값을 출력한다. S는 변경되지 않는다.
    find_max(v): 현재 자료 구조에 저장된 정수 집합이 S라면, (v XOR s) 값이 최대가 되는 S의 원소 s를 찾아 (v XOR s) 값을 출력한다. S는 변경되지 않는다.
    add(v): 현재 자료 구조에 저장된 정수 집합 S에 v를 추가한다. 추가한 후, S에 저장된 고유한 정수의 개수를 출력한다.
    remove_min(): 현재 자료 구조에 저장된 정수 집합 S의 원소 중 가장 작은 수를 출력한 후, 이를 삭제한다. 만약 가장 작은 수가 여럿이라면 모두 삭제한다.
    remove_max(): 현재 자료 구조에 저장된 정수 집합 S의 원소 중 가장 큰 수를 출력한 후, 이를 삭제한다. 만약 가장 큰 수가 여럿이라면 모두 삭제한다.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
    T
    n q
    arr
    q list
     */
    public static void main(String args[]) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String arr1[] = br.readLine().split(" ");
            int n = Integer.parseInt(arr1[0]);
            int q = Integer.parseInt(arr1[1]);

            String arr2[] = br.readLine().split(" ");
            int nArr[] = new int[arr2.length];
            for (int j = 0; j < arr2.length; j++) {
                nArr[j] = Integer.parseInt(arr2[j]);
            }
            int qArr[][] = new int[q][2];

            for (int j = 0; j < q; j++) {
                String arr3[] = br.readLine().split(" ");

                if (arr3.length > 1) {
                    qArr[j] = new int[]{Integer.parseInt(arr3[0]), Integer.parseInt(arr3[1])};
                } else {
                    qArr[j] = new int[]{Integer.parseInt(arr3[0]), -1};
                }
            }
            String result = solution(nArr, qArr);
            bw.write(result);
            bw.flush();
        }
    }

    public static String solution(int[] arr, int[][] q) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        /*
        1. find_min()
        2. find_max()
        3. add()
        4. remove_min()
        5. remove_max()
        6. find_min()
        7.find_max()
         */

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q.length; i++) {
            int command[] = q[i];
            int type = command[0];
            int value = command[1];
            int print = -1;
            switch (type) {
                case 1: // find_min
                    int minXor = Integer.MAX_VALUE;
                    for (int j = 0; j < list.size(); j++) {
                        minXor = Math.min(minXor, value ^ list.get(j));
                    }
                    print = minXor;
                    break;
                case 2: // find_max
                    int maxXor = Integer.MIN_VALUE;
                    for (int j = 0; j < list.size(); j++) {
                        maxXor = Math.max(maxXor, value ^ list.get(j));
                    }
                    print = maxXor;
                    break;
                case 3: // add
                    list.add(value);
                    HashSet<Integer> set = new HashSet<>();
                    for (int j = 0; j < list.size(); j++) {
                        set.add(list.get(j));
                    }
                    print = set.size();
                    break;
                case 4: // remove_min
                    ArrayList<Integer> minList = new ArrayList<>();
                    Collections.sort(list);
                    int min = list.get(0);
                    for (int j = 0; j < list.size(); j++) {
                        int v = list.get(j);
                        if (min == v) {
                            minList.add(v);
                        }
                    }

                    print = min;
                    for (int j = 0; j < minList.size(); j++) {
                        list.remove(minList.get(j));
                    }
                    break;
                case 5: //remove_max
                    ArrayList<Integer> maxList = new ArrayList<>();
                    Collections.sort(list, Collections.reverseOrder());
                    int max = list.get(0);
                    for (int j = 0; j < list.size(); j++) {
                        int v = list.get(j);
                        if (max == v) {
                            maxList.add(v);
                        }
                    }
                    print = max;
                    for (int j = 0; j < maxList.size(); j++) {
                        list.remove(maxList.get(j));
                    }
                    break;
            }
            if (i != q.length - 1) {
                sb.append(print + "\n");
            } else {
                sb.append(print);
            }

        }

        return sb.toString();
    }
}
