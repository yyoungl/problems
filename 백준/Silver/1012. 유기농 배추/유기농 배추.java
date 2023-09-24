
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	
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
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int C = sc.nextInt();
			int R = sc.nextInt();
			map = new int[R][C];
			int K = sc.nextInt();
			int answer = 0;
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = 1;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						bfs(new Node(i, j), R, C, dr, dc);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	public static void bfs(Node p, int R, int C, int[] dr, int[] dc) {
		Queue<Node> q = new LinkedList<>();
		q.add(p);
		while (!q.isEmpty()) {
			Node Node = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = Node.r + dr[d];
				int nc = Node.c + dc[d];
				if (Node.r + dr[d] >= 0 && Node.r + dr[d] < R && Node.c + dc[d] >= 0 && Node.c + dc[d] < C
						&& map[Node.r + dr[d]][Node.c + dc[d]] == 1) {
					q.add(new Node(Node.r + dr[d], Node.c + dc[d]));
					map[Node.r+dr[d]][Node.c+dc[d]] = 0;
				}
			}
		}
	}


}


