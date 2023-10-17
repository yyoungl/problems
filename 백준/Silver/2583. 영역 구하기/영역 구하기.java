
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[][] map;
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[N][M];
		int com = sc.nextInt();
		for (int coms=0; coms<com; coms++) {
			int c1 = sc.nextInt();
			int r1 = sc.nextInt();
			int c2 = sc.nextInt();
			int r2 = sc.nextInt();
			for (int i=r1; i<r2; i++) {
				for (int j=c1; j<c2; j++) {
					map[i][j] = true;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (!map[i][j]) {
					cnt++;
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for (int i: list) System.out.print(i+" ");
		
	}
	
	static int bfs(int r, int c) {
		int cnt = 1;
		Queue<Node> q = new LinkedList<>();
		map[r][c] = true;
		q.add(new Node(r, c));
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for (int d=0; d<4; d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				if (isValid(nr, nc) && !map[nr][nc]) {
					map[nr][nc] = true;
					q.add(new Node(nr, nc));
					cnt++;
				}
			}
			
		}
		return cnt;
	}
	
	static boolean isValid(int r, int c) {
		if (r<0 || r>=N || c<0 || c>=M) return false;
		return true;
	}

}
