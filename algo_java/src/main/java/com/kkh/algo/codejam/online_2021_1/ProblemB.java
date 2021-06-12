package com.kkh.algo.codejam.online_2021_1;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;

public class ProblemB {
    /*
    문제 Albert 는 n장의 숫자 카드를 가지고 있다.
    각 카드에는 0부터 9까지 숫자 하나씩이 적혀있고, 6이나 9가 적힌 카드를 회전할 경우 구분할 수 없다 (즉, 6이 적힌 카드는 회전하면 9로 보이고, 9가 적힌 카드는 회전하면 6으로 보인다).
    Albert는 최근 두 수의 곱셈에 대해 배운터라 n장의 카드를 모두 이용하여 두 개의 수를 만든 후, 그 수의 곱이 최대가 되도록 하고 싶다.
    단, n장의 카드 모두 사용하여야 하며, 각 수는 최소 1장 (그리고 최대 n-1장)의 카드로 구성되어야 한다. 6이나 9가 적힌 카드는 Albert가 임의로 회전하여 사용할 수 있다.

    예를 들어 n = 8이고 Albert가 가진 카드가 [2, 0, 2, 0, 2, 0, 2, 1] 이라 하자.
    이 때 8장의 카드를 활용하여 "2200" 과 "2210"을 만들면 두 수의 곱은 4862000이 된다.
    혹은 "2020"과 "2021"을 만들어 곱이 4082420이 되도록 할 수도 있다.
    이 예제에서 Albert가 만들 수 있는 최대 곱은 4862000이다.

    입력으로 Albert가 가진 n장의 숫자 카드가 주어졌을 때, 달성 가능한 최대 곱을 구하시오.
    입력
    첫 줄에 테스트 케이스의 수 T가 주어진다.
    다음 각 줄에 Albert가 가진 숫자 카드를 표현하는 문자열이 (공백없이) 주어지는데, 문자열의 각 문자는 '0'-'9' 중 하나이다.

    출력
    각 테스트 케이스에 대해 Albert가 만들 수 있는 최대 곱을 출력한다.ong
5
90000
66
102030
20202021
999999999999999999

0
81
63000
4862000
999999998000000001

     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
//        System.out.println(solution(90000));
//        System.out.println(solution("66"));
//        System.out.println(solution("102030"));
//        System.out.println(solution("20202021"));
//        System.out.println(solution("999999999999999999"));
//        int T = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int s = Integer.parseInt(br.readLine().trim());
            long result = solution(s);
            bw.write("" + result + "\n");
            bw.flush();
        }
    }

    public static long solution(int num) {
        /*
        1. 내림차순으로 정렬한다
        2. 두수로 나눈다
        3. 각 두 수에서 카장 큰자리수를 제외하고 조합을 하여 가장 큰 값을 저장한다
         */
        String str = String.valueOf(num);
        int numArr[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            numArr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        Arrays.sort(numArr);
        boolean bigTurn = true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = numArr.length - 1; i >= 0; i--) {
            int n = numArr[i];
            if (n == 6) {
                n = 9;
            }
            if (bigTurn) {
                sb1.append(n);
            } else {
                sb2.append(n);
            }
            bigTurn = !bigTurn;
        }
        System.out.println(sb1.toString() + " , " + sb2.toString());


        long ret = Long.parseLong(sb1.toString()) * Long.parseLong(sb2.toString());
        return ret;
    }

    private static long multi(String str) {

        String newStr = str.substring(1);
        long mul = 1;
        for (int i = 0; i < newStr.length(); i++) {
            int n = Integer.parseInt(String.valueOf(newStr.charAt(i)));
            mul *= n;
        }
        return 0;
    }

}
