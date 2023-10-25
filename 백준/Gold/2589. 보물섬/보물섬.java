import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static char[][] island;
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
	}
	static int answer = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		island = new char[N][M];
		for (int i=0; i<N; i++) {
			String in = sc.next();
			for (int j=0; j<M; j++) {
				island[i][j] = in.charAt(j);
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (island[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Node(i, j, 0));
		visited[i][j] = true;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int depth = curr.depth;
			answer = Math.max(depth, answer);
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc] && island[nr][nc] == 'L') {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, depth+1));
				}
			}
		}
		
	}

	static boolean isValid(int r, int c) {
		if (r<0 || r>=N || c<0 || c>=M) return false;
		return true;
	}
}
