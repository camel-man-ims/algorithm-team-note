package 테스트.SSG_220514;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Number3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}});
    }
    /*
    1. 떨어뜨린다.
    2. 연결된 것 3개 이상인지 BFS 로 탐색
    3. 3개 이상이면 전부 지운다
    4. 빈 공간 있으면 아래로 내린다.
     */
    static class Solution{
        static final int N = 6;
        static int[][] map;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        public String[] solution(int[][] macaron){
            map = new int[N][N];

            for(int[] act : macaron){
                int col = act[0]-1;
                int row = 0;
                int color = act[1];

                // 1. 떨어뜨리기
                while(row < 6 && map[row][col] == 0){
                    row++;
                }
                map[row-1][col] = color;

                // 2. 3개 이상인지 BFS 로 탐색
                int cnt = check(row-1,col);

                // 3. 3개 이상이면 지우기
                if(cnt>=3){
                    remove(row-1,col);
                }

                // 4. 빈 공간 있으면 아래로 내리기
                down();

                // 5. while -> 3개 이상 없을 때까지 반복
                while(true){
                    boolean flag = true;
                    for(int i=0;i<N;i++){
                        for(int j=0;j<N;j++){
                            int check = check(i, j);
                            if(check >= 3){
                                remove(i,j);
                                down();
                                flag = false;
                            }
                        }
                    }
                    if(flag) break;
                }
            }

            String[] res = new String[N];

            for(int i=0;i<N;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<N;j++){
                    sb.append(map[i][j]);
                }
                res[i] = sb.toString();
            }
            System.out.println(Arrays.toString(res));

            print();

            return null;
        }

        private void down() {
            for(int j=0;j<N;j++){
                for(int i=N-1;i>0;i--){
                    if(map[i][j] == 0){
                        int p = -1;
                        for(int k=i;k>=0;k--){
                            if(map[k][j] != 0){
                                p = k;
                                break;
                            }
                        }
                        if(p>=0){
                            map[i][j] = map[p][j];
                            map[p][j] = 0;
                        }
                    }
                }
            }
        }

        private void remove(int r, int c) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[N][N];

            q.offer(new int[]{r,c});
            v[r][c] = true;
            int color = map[r][c];
            map[r][c] = 0;

            while(!q.isEmpty()){
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                map[x][y] = 0;

                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(isOut(nx,ny) || map[nx][ny] == 0 || v[nx][ny] || map[nx][ny] != color) continue;

                    q.offer(new int[]{nx,ny});
                    v[nx][ny] = true;
                }
            }
        }

        private int check(int r, int c) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[N][N];

            q.offer(new int[]{r,c});
            v[r][c] = true;
            int cnt = 1;
            int color = map[r][c];
            while(!q.isEmpty()){
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];

                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(isOut(nx,ny) || map[nx][ny] == 0 || v[nx][ny] || map[nx][ny] != color) continue;

                    cnt++;
                    q.offer(new int[]{nx,ny});
                    v[nx][ny] = true;
                }
            }
            return cnt;
        }

        static boolean isOut(int nx,int ny){
            return nx<0 || ny<0 || nx>=N || ny>=N;
        }

        private void print() {
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
