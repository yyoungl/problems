import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
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
		int[][] map = new int[N][M];
		int[][] cnt = new int[N][M];
		int r = 0;
		int c = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
				if (input == 0) cnt[i][j] = 0;
				else if (input == 2) { 
					r = i;
					c = j;
				}
				else cnt[i][j] = -1;
				
			}
		}
		cnt[r][c] = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && cnt[nr][nc] == -1) {
					cnt[nr][nc] = cnt[r][c] + 1;
					q.add(new Node(nr, nc));
				}
			}
		} 
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(cnt[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean isValid(int r, int c) {
		if (r<0 || r>=N || c<0 || c>=M) return false;
		return true;
	}

}
