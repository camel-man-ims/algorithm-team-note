package 테스트.카카오페이_220519;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오페이_3 {
	
	public static void main(String[] args) {
		int rows = 3;
		int columns = 3;
		int[][] maze = {{1,1,1,2},{1,2,2,2},{1,3,2,3},{2,2,2,3},{2,1,2,2},{2,1,3,1},{2,2,3,2},{3,2,3,3}};
		int r1 = 9;
		int c1 = 1;
		int r2 = 1;
		int c2 = 9;
		System.out.println(solution(rows, columns, maze, r1, c1, r2, c2));
	}
	
	static int R,C,ans;
	static boolean[][][] map;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌
	
	public static int solution(int rows, int columns, int[][] maze, int r1, int c1, int r2, int c2) {
		R = rows*rows;
		C = columns*columns;
		map = new boolean[R][C][4]; // 각 칸마다 4방향(상우하좌)
		int len = maze.length;
		for(int i=0; i<len; ++i) {
			int a1 = maze[i][0]-1;
			int b1 = maze[i][1]-1;
			int a2 = maze[i][2]-1;
			int b2 = maze[i][3]-1;
			int to = -1; // 향하는 방향
			if(a1>a2) { // 상
				to = 0;
			}else if(a1<a2) { // 하
				to = 2;
			}else {
				if(b1>b2) { // 좌
					to = 3;
				}else { // 우
					to = 1;
				}
			}
			// 작은 한 칸
			for(int a=a1; a<R; a+=rows) {
				for(int b=b1; b<C; b+=columns) {
					path(a,b,to);
				}
			}
			// 큰 한 칸
			if(to==0) { // 상
				int a = a1*rows;
				for(int b=b1*columns; b<(b1+1)*columns; ++b) {
					path(a, b, to);
				}
			}else if(to==1) { // 우
				int b = (b1+1)*columns-1;
				for(int a=a1*rows; a<(a1+1)*rows; ++a) {
					path(a, b, to);
				}
			}else if(to==2) { // 하
				int a = (a1+1)*rows-1;
				for(int b=b1*columns; b<(b1+1)*columns; ++b) {
					path(a, b, to);
				}
			}else if(to==3) { // 좌
				int b = b1*columns;
				for(int a=a1*rows; a<(a1+1)*rows; ++a) {
					path(a, b, to);
				}
			}
		}
//		print();
//		int answer = 0;
		bfs(r1-1,c1-1,r2-1,c2-1);
		return ans;
	}
//	public static void print() {
//		for(int i=0; i<R; ++i) {
//			for(int j=0; j<C; ++j) {
//				for(int k=0; k<4; ++k) {
//					System.out.print(map[i][j][k]+" ");
//				}
//				System.out.println();
//			}
//		}
//	}
	public static void bfs(int r1, int c1, int r2, int c2) {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1,c1});
		int dist = 0; // 이동 거리
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				if(visited[r][c]) continue;
				visited[r][c] = true;
				if(r==r2 && c==c2) { // 도착하면
					ans = dist;
					return;
				}
				for(int d=0; d<4; ++d) {
					if(!map[r][c][d]) continue; // 통로 없으면 무시
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue; // 경계 및 방문 체크
					q.offer(new int[] {nr,nc});
				}
			}
			dist++; // 이동거리 증가
		}
	}
	public static void path(int a, int b, int d) {
//		System.out.println(a+"m"+b+"m"+d);
		map[a][b][d] = true;
		int na = a+dir[d][0];
		int nb = b+dir[d][1];
		map[na][nb][(d+2)%4] = true;
	}
}