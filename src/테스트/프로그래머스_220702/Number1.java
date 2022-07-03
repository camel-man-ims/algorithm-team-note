package 테스트.프로그래머스_220702;

import java.util.PriorityQueue;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{3,2,3,6,4,5});
    }
    static class Info implements Comparable<Info>{
        int index;
        int value;

        public Info(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.value,o.value);
        }
    }
    static class Solution {
        static int N;
        public int solution(int[] grade) {
            int res = 0;
            PriorityQueue<Info> pq = new PriorityQueue<>();
            N = grade.length;
            for(int i=1;i<N;i++){
                pq.offer(new Info(i,grade[i]));
            }

            int cur = grade[0];

            while(!pq.isEmpty()){
                if(cur > pq.peek().value){
                    res += cur - pq.peek().value;
                }

            }
            System.out.println(res);
            return res;
        }
    }
}
