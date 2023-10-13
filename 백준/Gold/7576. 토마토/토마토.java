import java.util.*;

public class Main {
	static int M;
	static int N;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		int[][] box = new int[N][M];
		int[][] cnt = new int[N][M];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int r = 0;
		int c = 0;
		int tomato = 0;
		int answer = 0;

		boolean[][] visited = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int in = sc.nextInt();
				if (in == -1)
					visited[i][j] = true;
				if (in == 1) {
					visited[i][j] = true;
					q.add(new Node(i, j));
				}
				if (in == 0)
					tomato++;
				box[i][j] = in;
			}
		}

		while (!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isValid(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					cnt[nr][nc] = cnt[r][c] + 1;
					answer = Math.max(answer, cnt[nr][nc]);
					q.add(new Node(nr, nc));
					tomato--;
				}
			}

		}
		if (tomato != 0)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	public static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
