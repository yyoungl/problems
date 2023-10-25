
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] picture;
	static int cnt = 0;
	static int answer = 0;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		picture = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
			{
				int in = sc.nextInt();
				picture[i][j] = in;
				if (in==0) visited[i][j] = true;
				
			}
		}
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (picture[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
				
			}
		}
		
		System.out.println(cnt);
		System.out.println(answer);
		
	}
	
	static void bfs(int r, int c) {
		int wide = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node (r, c));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc]) {
					q.add(new Node(nr, nc));
					visited[nr][nc] =true;
					wide++;
				}
			}
		}
		
		
		answer = Math.max(wide, answer);
	}
	
	static boolean isValid(int r, int c) {
		if (r < 0 || r>=N || c <0 || c>=M) return false;
		return true;
	}

}
