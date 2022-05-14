package 테스트.네이버파이낸셜_220514;

import java.util.Arrays;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[][]{{1, 50}, {1, 60}, {3, 70}, {0, 65}, {2, 50}, {1, 90}}, 2, 70);
        System.out.println(Arrays.toString(solution1));
    }
    static class Solution {
        /*
        1. 시니어 숫자 세기
        2. for 2중 loop
        3. pq 에 넣고, 해당 숫자 세기
         */
        static int maxS1;
        static int maxS2;
        static int maxCount;
        static int maxE1;
        static int maxE2;
        static int N;
        public int[] solution(int[][] recruits, int s1, int s2) {
            maxS1 = 0;
            maxS2 = 0;
            maxCount = 0;
            maxE1 = 0;
            maxE2 = 0;
            N = recruits.length;
            for(int[] a : recruits){
                int a1 = a[0];
                int a2 = a[1];

                maxS1 = Math.max(maxS1,a1);
                maxS2 = Math.max(maxS2,a2);
            }
            int expertCnt;
            int seniorCnt;
            int juniorCnt;
            for(int i=0;i<=maxS1;i++){
                for(int j=0;j<=maxS2;j++){
                    expertCnt = 0;
                    seniorCnt = 0;
                    juniorCnt = 0;

                    for(int n=0;n<N;n++){
                        int e1 = recruits[n][0];
                        int e2 = recruits[n][1];

                        if(e1 >= i && e2>=j){
                            expertCnt++;
                        }else if(e1 >= s1 || e2>=s2){
                            seniorCnt++;
                        }else{
                            juniorCnt++;
                        }
                    }
                    if(seniorCnt <= expertCnt || juniorCnt <= seniorCnt || expertCnt == 0) continue;

                    int expertSum = i + j;

                    if(expertSum >= maxCount){
                        maxCount = expertSum;
                        maxE1 = i;
                        maxE2 = j;
                    }
                }
            }
            return new int[]{maxE1,maxE2};
        }
    }
}
