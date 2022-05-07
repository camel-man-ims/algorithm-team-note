package 테스트.카카오인턴_220507;

public class Number5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{9,10,11,12},{1,2,3,4},{5,6,7,8}},new String[]{"Rotate", "ShiftRow"});
    }
    static class Solution {
        static int[][] map;
        static int N;
        static int M;
        static int dir;
        static boolean[][] v;
        // 하 우 상 좌
        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};
        public int[][] solution(int[][] rc, String[] operations) {
            map = rc;
            N = map.length;
            M = map[0].length;

            for(String s : operations){
                if(s.equals("Rotate")){
                    rotate(map);
                }else{
                    shift(map);
                }
            }
            return map;
        }

        private void print() {
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

        static void shift(int[][] arr){
            int[] save = arr[N-1].clone();

            for(int i=N-1;i>=1;i--){
                arr[i] = arr[i-1].clone();
            }
            arr[0] = save.clone();
        }

        static void rotate(int[][] arr){
            dir = 0;
            v = new boolean[N][M];

            int x = 0;
            int y = 0;
            v[x][y] = true;

            int save = arr[x][y];

            int nx = 1;
            int ny = 0;

            while(!v[nx][ny]){
                arr[x][y] = arr[nx][ny];
                v[nx][ny] = true;
                x = nx;
                y = ny;
                nx = x + dx[dir];
                ny = y + dy[dir];

                if(isOut(nx,ny)){
                    dir += 1;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
            }
            arr[0][1] = save;
        }

        private static void printV() {
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(v[i][j] + " ");
                }
                System.out.println();
            }
        }

        static boolean isOut(int nx,int ny){
            return nx<0 || ny<0 || nx>=N || ny>=M;
        }
    }
}
