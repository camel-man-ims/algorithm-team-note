package 테스트.카카오페이_220519;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(7,8,new int[][]{{2,2},{1,4},{3,5}});
    }
    static class Solution{
        static int[][] map;
        static int N,M;
        public int[][] solution(int n, int m, int[][] rectangle){
            N = m;
            M = n;
            map = new int[N][M];

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

            for(int[] a : rectangle){
                pq.offer(a);
            }

            int p = 1;

            out: for(int i=N-1;i>=0;i--){
                lo: for(int j=0;j<M;j++){
                    if(map[i][j] != 0) continue;

                    if(pq.isEmpty()){
                        break out;
                    }
                    int[] poll = pq.poll();

                    int range = poll[0];

                    for(int k=i;k>i-range;k--){
                        for(int o=j;o<j+range;o++){
                            if(isOut(k,o) || map[k][o] != 0){
                                pq.offer(new int[]{poll[0],poll[1]});
                                continue lo;
                            }
                        }
                    }

                    for(int k=i;k>i-range;k--){
                        for(int o=j;o<j+range;o++){
                            map[k][o] = p;
                        }
                    }
                    p++;
                    poll[1] -= 1;
                    if(poll[1] > 0){
                        pq.offer(new int[]{poll[0],poll[1]});
                    }
                }
            }
            // p = 마지막 + 1
            boolean[] v = new boolean[p];
            int[][] res = new int[p-1][3];
            int d = 1;

            for(int i=N-1;i>=0;i--){
                for(int j=0;j<M;j++){
                    if(map[i][j] == d && !v[d]){
                        int end =0 ;
                        for(int k=j;k<M;k++){
                            if(map[i][k] != d){
                                end = k;
                                break;
                            }
                        }
                        int len = end - j;
                        res[d-1] = new int[]{j,N-1-i,len};
                        v[d] = true;
                        d++;
                    }
                }
            }

            for(int[] a : res){
                System.out.println(Arrays.toString(a));
            }
            return null;
        }

        private void print() {
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

        static boolean isOut(int nx,int ny){
            return nx<0 || ny>=M;
        }
    }
}
