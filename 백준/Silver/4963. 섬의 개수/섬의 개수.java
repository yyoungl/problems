
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		 
	}
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1 ,-1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if (M == 0 && N == 0) break;
			visited = new boolean[N][M];
			map = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					int temp = sc.nextInt();
					if (temp == 0 ) visited[i][j] = true;
					map[i][j] = temp;
				}
			}
			
			
			int cnt = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (map[i][j] ==1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static boolean isValid(int r, int c) {
		if (r<0 || r>=N || c<0 || c>=M) return false;
		return true;
	}
	
	static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for (int d=0; d<8; d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] ==1 ) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
			}
		}
	}
}
