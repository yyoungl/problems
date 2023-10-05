import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
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
	
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String s = sc.next();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
				
			}
		}
		
		int r = 0;
		int c = 0;
		visited[r][c] = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));


		while(!q.isEmpty()) {
			Node curr = q.poll();
//			System.out.println(curr.toString());
			r= curr.r;
			c = curr.c;

			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isMovable(nr, nc, N, M)) {
					q.add(new Node (nr, nc));
					visited[nr][nc] = visited[r][c]+1;
				}
			}
			
		}
		
		System.out.println(visited[N-1][M-1]);
		
	}
	
	static boolean isMovable(int r, int c, int N, int M) {
		if (r < 0 || r>=N || c<0 || c>=M || visited[r][c] > 0 || map[r][c] == 0) return false;
		return true;
	}

}
