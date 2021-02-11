package com.kkh.codingtest.dfsbfs;

public class CodingTest_DFSBFS1 {
    public static void main(String args[]) {
        new CodingTest_DFSBFS1();
    }

    public CodingTest_DFSBFS1() {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1,}, 3));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int node, int sum, int target){
        if(node == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return dfs(numbers, node+1, sum + numbers[node], target)
                + dfs(numbers, node+1, sum - numbers[node], target);
    }
}
