package com.kkh.condigtest.dynamic;

public class CodingTest_Dynamic1 {
    public static void main(String args[]) {
        new CodingTest_Dynamic1();
    }

    public CodingTest_Dynamic1() {
        System.out.println(solution(5, 12));     // return 4
    }

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        if (answer > 8) return -1;
        else return answer;
    }

    int answer = 0x7f7f7f7f;

    void dfs(int n, int number, int idx, int sum) {
//        System.out.println("n = " + n + " , number = " + number + " , idx = " + idx + " , sum = " + sum);
        if (idx > 8) return;

        if (sum == number) {
            answer = Math.min(answer, idx);
        }

        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            tmp = tmp * 10 + n;
            dfs(n, number, idx + i + 1, sum + tmp);
            dfs(n, number, idx + i + 1, sum - tmp);
            dfs(n, number, idx + i + 1, sum * tmp);
            dfs(n, number, idx + i + 1, sum / tmp);
        }
    }


}
