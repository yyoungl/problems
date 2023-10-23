
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int h;
		int r;
		int c;
		@Override
		public String toString() {
			return "Node [h=" + h + ", r=" + r + ", c=" + c + "]";
		}
		public Node(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}

	}

	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static int N;
	static int M;
	static int H;
	static int[][][] tomato;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		boolean[][][] visited = new boolean[H][N][M];
		tomato = new int[H][N][M];
		int answer = 0;
		int zeroCnt = 0;
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					int in = sc.nextInt();
					tomato[i][j][k] = in;
					if (in == 1) {
						q.add(new Node(i, j, k));
						visited[i][j][k] = true;
					} else if (in == 0)
						zeroCnt++;
					else if (in==-1) visited[i][j][k] = true;
				}
			}
		}
		

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int h = curr.h;
			for (int d = 0; d < 6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int nh = h + dh[d];
				if (isValid(nr, nc, nh) && !visited[nh][nr][nc] && tomato[nh][nr][nc] == 0) {
					tomato[nh][nr][nc] = tomato[h][r][c] + 1;
					zeroCnt--;
					visited[nh][nr][nc] = true;
					q.add(new Node(nh, nr, nc));
					answer = Math.max(answer, tomato[nh][nr][nc]);
				}

			}
		}
		
		for (int k=0; k<H; k++) {
			
		}
		
		if (zeroCnt > 0)
			System.out.println(-1);
		else if (answer == 0) System.out.println(0);
		else 
			System.out.println((answer - 1));

	}

	static boolean isValid(int r, int c, int h) {
		if (r < 0 || r >= N || c < 0 || c >= M || h < 0 || h >= H)
			return false;
		return true;
	}

}
