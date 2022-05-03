package 테스트.십일번가_220503;

/*
풀이 :
1. 앞에거 확인 if isOn[target-1] == true:
                isOn[target] = true
                isLight[target] = true
            else
                queue.offer(target)
    뒤에거 확인, i+1이 끝에 도달하거나 isOn[i+1] == true || isLight[i+1] == false 면 멈춤
    isLight[i+1] == true & isOn[i+1] == false 일 때를 찾고 싶은 것

2.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{1, 3, 4, 2, 5});
        System.out.println(solution1);
    }
    static class Solution {
        static boolean[] isOn;
        static boolean[] isLight;
        static PriorityQueue<Integer> queue;
        static int N;
        public int solution(int[] A) {
            N = A.length;

            isOn = new boolean[N+1];
            isLight = new boolean[N+1];
            queue = new PriorityQueue<>();

            int answer = 0;

            for(int i : A){
                isLight[i] = true;
                if(i!=1){
                    if(isOn[i-1]){
                        dfs(i);
                    }else{
                        queue.offer(i);
                    }
                }else{
                    isOn[i] = true;
                    dfs(i);
                }

                while (!queue.isEmpty()){
                    int poll = queue.poll();
                    if(!isOn[poll-1]) {
                        queue.offer(poll);
                        break;
                    }
                    isOn[poll] = true;
                }

                if(queue.isEmpty()){
                    answer++;
                }
            }
            return answer;
        }

        private void dfs(int target) {
            if(target > N){
                return ;
            }
            if(isLight[target] && !isOn[target]){
                isOn[target] = true;
                dfs(target+1);
            }
        }
    }
}
