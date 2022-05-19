package 테스트.SSG_220514.동석님풀이;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SSG_4 {
	
	public static void main(String[] args) {
		int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		solution(macaron);
	}
	
	static boolean[][] visited;
	static int[][] map = new int[6][6];
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌
	
	public static String[] solution(int[][] macaron) {
		visited = new boolean[6][6];
		for(int i=0,len=macaron.length; i<len; ++i) {
			int col = macaron[i][0]-1; // 열
			int n = macaron[i][1]; // 색깔
			int[] pos = drop(col,n);
			int num = check(pos[0],pos[1],n);
			while(num>=3) { // 3개 이상 연속하면
				bomb(); // 터트리기
				down(); // 내리기
				num = 0; // 터트릴 갯수 초기화
				for(int j=0; j<6; ++j) {
					for(int k=0; k<6; ++k) {
						if(map[j][k]!=0) { // 빈칸 아니면
							int cnt = check(j, k, map[j][k]);
							if(cnt>=3) num+=cnt; // 3개 이상이면 더한다
						}
					}
				}
			}
		}
		String[] answer = new String[6];
		for(int i=0; i<6; ++i) {
			String str = "";
			for(int j=0; j<6; ++j) {
				str += map[i][j];
			}
			answer[i] = str;
		}
		return answer;
	}
	
	public static void down() {
		for(int c=0; c<6; ++c) {
			int idx = 5;
			for(int r=5; r>=0; --r) {
				if(map[r][c]!=0) {
					map[idx--][c] = map[r][c]; // 내리기
				}
			}
			for(int r=idx; r>=0; --r) {
				map[r][c] = 0; // 남은 칸 0으로 만들기
			}
		}
	}

	public static void bomb() {
		for(int i=0; i<6; ++i) {
			for(int j=0; j<6; ++j) {
				if(visited[i][j]) { // 터질 곳이면
					map[i][j] = 0; // 마카롱 삭제
					visited[i][j] = false; // 초기화
				}
			}
			
		}
	}

	public static int[] drop(int col, int n) {
		for(int r=5; r>=0; --r) {
			if(map[r][col]==0) { // 빈칸 찾으면
				map[r][col]=n;
				return new int[] {r,col}; // 위치 반환
			}
		}
		return new int[] {-1,-1};
	}

	public static int check(int i, int j, int n) {
		boolean[][] checked = new boolean[6][6];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		ArrayList<int[]> list = new ArrayList<int[]>();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			if(checked[r][c]) continue;
			checked[r][c] = true;
			list.add(new int[] {r,c});
			for(int d=0; d<4; ++d) {
				int nr = r+dir[d][0];
				int nc = c+dir[d][1];
				if(nr<0 || nr>5 || nc<0 || nc>5 || map[nr][nc]!=n) continue; // 경계 및 색깔
				q.offer(new int[] {nr,nc});
			}
		}
		int size = list.size();
		if(size>=3) {
			for(int[] cur : list) {
				visited[cur[0]][cur[1]] = true;
			}
		}
		return size;
	}
}