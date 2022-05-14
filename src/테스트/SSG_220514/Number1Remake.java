package 테스트.SSG_220514;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Number1Remake {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{40,26,30},5,1);
    }
    static class Solution{
        static int N;
        public int solution(int[] v,int a, int b){

            PriorityQueue<Integer> pqBig = new PriorityQueue<>(Collections.reverseOrder());
            int time = 0 ;
            for(int n : v){
                pqBig.offer(n);
            }
            N = v.length;

            out: while(true){
                int poll = pqBig.poll();
                if(poll-a < 0){
                    break;
                }
                Queue<Integer> temp = new LinkedList<>();
                while(!pqBig.isEmpty()){
                    int p = pqBig.poll();
                    if(p-b < 0){
                        break out;
                    }
                    temp.offer(p-b);
                }
                pqBig.offer(poll-a);
                while(!temp.isEmpty()){
                    pqBig.offer(temp.poll());
                }
                time++;
            }
            System.out.println(time);
            return time;
        }
    }
}
