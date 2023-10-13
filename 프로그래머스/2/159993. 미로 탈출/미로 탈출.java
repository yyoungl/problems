import java.util.*;

class Solution {
    static class Node {
		int r;
		int c;
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c +"]";
		}
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int M;

    public int solution(String[] maps) {
int answer = 0;
		N = maps.length;
		M = maps[0].length();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		char[][] map = new char[N][M];
		int[][] cnt = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		int lr = 0;
		int lc = 0;
		int r = 0;
		int c = 0;
		int endr = 0;
		int endc = 0;
		for (int i=0; i<N; i++) {
			String temp = maps[i];
			for (int j=0; j<M; j++) {
				char t = temp.charAt(j);
				map[i][j] = t;
				if (t == 'L') {
					lr = i;
					lc = j;
				}
				if (t == 'S'){
					r = i;
					c = j;
				}
				if (t == 'E') {
					endr = i;
					endc = j;
				}
			}
		}
		
		int nr;
		int nc;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			
			if (r == lr && c == lc) break;
			
			for (int d=0; d<4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X') {
					cnt[nr][nc] = cnt[r][c]+1;
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
			
		}
		
		
		if (cnt[lr][lc] == 0) return -1;
		
		visited = new boolean[N][M];

		q.clear();
		visited[r][c] = true;
		q.add(new Node(r, c));
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			
			if (r==endr && c == endc) break;
			
			for (int d=0; d<4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X') {
					cnt[nr][nc] = cnt[r][c] + 1;
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		
		if (cnt[endr][endc] == 0) return -1;
		
		return cnt[endr][endc];
    }
    
    	public static boolean isValid(int r, int c) {
		if (r<0 || r >=N || c<0 || c>=M) return false;
		return true;
		
	}

}