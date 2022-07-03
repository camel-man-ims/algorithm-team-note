package 테스트.라인_220528;

import java.util.Arrays;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5,new int[]{2,4,5});
    }
    static class Solution {
        static int[] dp;
        static int N;
        public int solution(int n, int[] times) {
            N = n;

            dp = new int[N+1];

            for(int i=2;i<N+1;i++){
                int min = Integer.MAX_VALUE;
                for(int t=0;t<times.length;t++){
                    int j = t+1;
                    if(i-j > 0){
                        min = Math.min(min,dp[i] + dp[i-j] + times[t]);
                    }
                }
                dp[i] = min;
            }
            System.out.println(Arrays.toString(dp));

            return 1;
        }
    }
}
