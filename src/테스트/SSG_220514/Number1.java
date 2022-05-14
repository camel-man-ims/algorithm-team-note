package 테스트.SSG_220514;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{3,9,4},2,1);
    }
    static class Solution{
        static int N;
        public int solution(int[] v,int a, int b){

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int time = 0 ;
            for(int n : v){
                pq.offer(n);
            }
            N = v.length;

            out: while(true){
                int poll = pq.poll();
                if(poll-a < 0){
                    break;
                }
                Queue<Integer> temp = new LinkedList<>();
                while(!pq.isEmpty()){
                    int p = pq.poll();
                    if(p-b < 0){
                        break out;
                    }
                    temp.offer(p-b);
                }
                pq.offer(poll-a);
                while(!temp.isEmpty()){
                    pq.offer(temp.poll());
                }
                time++;
            }
            System.out.println(time);
            return time;
        }
    }
}
