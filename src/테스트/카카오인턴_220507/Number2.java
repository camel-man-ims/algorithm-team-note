package 테스트.카카오인턴_220507;

import java.util.*;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{4, 5, 5}, new int[]{4, 4, 4});
        System.out.println(solution1);
    }
    static class Solution {
        static long sum;
        static int N;
        static long max;
        static long half;
        static long answer;
        Set<Integer> set;
        public int solution(int[] queue1, int[] queue2) {
            sum = 0;
            N = queue1.length;
            max = 0;
            answer = 0;
            set = new HashSet<>();

            for(int i=0;i<N;i++){
                sum += queue1[i] + queue2[i];
            }

            if(sum % 2 == 1){
                return -1;
            }

            for(int i=0;i<N;i++){
                max = Math.max(max,queue1[i]);
                max = Math.max(max,queue2[i]);
            }
            half = sum/2;

            if(max > half){
                return -1;
            }

            int q1sum = 0;
            int q2sum = 0;
            for(int i=0;i<N;i++){
                q1sum += queue1[i];
            }
            for(int i=0;i<N;i++){
                q2sum += queue2[i];
            }
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            for(int i=0;i<N;i++){
                q1.offer(queue1[i]);
                set.add(queue1[i]);
            }
            for(int i=0;i<N;i++){
                q2.offer(queue2[i]);
                set.add(queue2[i]);
            }
            int ans1 = 0;
            while(q1sum != half){
                long dif = Math.abs(half - q1sum);
                boolean flag = false;
                for(int n : set){
                    if (dif >= n) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    ans1 = Integer.MAX_VALUE;
                    break;
                }

                if(q1sum < half){
                    if(q2.isEmpty()){
                        ans1 = Integer.MAX_VALUE;
                        break;
                    }
                    Integer poll = q2.poll();
                    q1sum += poll;
                    q1.offer(poll);
                }else{
                    if(q1.isEmpty()){
                        ans1 = Integer.MAX_VALUE;
                        break;
                    }
                    Integer poll = q1.poll();
                    q1sum -= poll;
                    q2.offer(poll);
                }
                ans1++;
            }
            /* ------------------------------ */
            q1.clear();
            q2.clear();

            int ans2 = 0;
            for(int i=0;i<N;i++){
                q1.offer(queue1[i]);
            }
            for(int i=0;i<N;i++){
                q2.offer(queue2[i]);
            }

            while(q2sum != half){
                long dif = Math.abs(half - q2sum);
                boolean flag = false;
                for(int n : set){
                    if (dif >= n) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    ans2 = Integer.MAX_VALUE;
                    break;
                }

                if(q2sum < half){
                    if(q1.isEmpty()){
                        ans2 = Integer.MAX_VALUE;
                        break;
                    }
                    Integer poll = q1.poll();
                    q2sum += poll;
                    q2.offer(poll);
                }else{
                    if(q2.isEmpty()){
                        ans2 = Integer.MAX_VALUE;
                        break;
                    }
                    Integer poll = q2.poll();
                    q2sum -= poll;
                    q1.offer(poll);
                }
                ans2++;
            }

            answer = Math.min(ans1,ans2);

            return (int) answer == Integer.MAX_VALUE ? -1 : (int)answer;
        }
    }
}
