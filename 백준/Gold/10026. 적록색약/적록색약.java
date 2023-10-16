
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
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
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String in = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = in.charAt(j);
			}
		}
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int d=0; d<4; d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if (isValid(nr, nc) && map[nr][nc] == map[curr.r][curr.c] && !visited[nr][nc] ) {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	public static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}

}
