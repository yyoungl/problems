
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r;
		int c;
		int depth;
		
		public Node(int r, int c, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}


	}

	static int[][] sea;
	static int N;
	static int M;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		sea = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = sc.nextInt();
				sea[i][j] = temp;
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (sea[i][j]==0) answer = Math.max(answer, bfs(i,j));
			}
		}
		
		System.out.println(answer);
		
	}

	static int bfs(int r, int c) {
		int result = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c, 0));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if (sea[curr.r][curr.c] == 1 && curr.depth > 0) {
				result = Math.min(result, curr.depth);
			}
			
			for (int d=0; d<8; d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc]) {
					q.add(new Node(nr, nc, curr.depth+1));
					visited[nr][nc] = true;
				}
			}
			
		}
		
		if (result == Integer.MAX_VALUE) return -1;
		else return result;
	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
