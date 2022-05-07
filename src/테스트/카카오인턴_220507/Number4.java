package 테스트.카카오인턴_220507;

import java.util.ArrayList;

public class Number4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(7,new int[][]{{1,4,4},{1,6,1},{1,7,3},{2,5,2},{3,7,4},{5,6,6}},new int[]{1},new int[]{2,3,4});
    }
    static class Solution {
        static int N;
        static ArrayList<Connect>[] lists;
        static class Connect{
            int y;
            int cost;

            public Connect(int y, int cost) {
                this.y = y;
                this.cost = cost;
            }
        }
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            N = n;

            lists = new ArrayList[N+1];

            for(int i=1;i<N+1;i++){
                lists[i] = new ArrayList<>();
            }

            for(int[] path : paths){
                int from = path[0];
                int to = path[1];
                int cost = path[2];

                lists[from].add(new Connect(to,cost));
                lists[to].add(new Connect(from,cost));
            }

            return null;
        }
    }
}
