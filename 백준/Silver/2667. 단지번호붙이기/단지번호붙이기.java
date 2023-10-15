
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
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
		map = new int[N][N];
		visited = new boolean[N][N];
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> cnt = new ArrayList<>();
		int regions = 0;
		for (int i=0; i<N; i++) {
			String s = sc.next();
			for (int j=0; j<N; j++) 
				map[i][j] = s.charAt(j) - '0';			
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					regions++;
					cnt.add(bfs(i, j));
				}
			}
		}
		Collections.sort(cnt);
		System.out.println(regions);
		for (int c: cnt) System.out.println(c);
	}
	
	public static int bfs(int r, int c) {
		int cnt = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					cnt++;
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		return cnt;
	}
	
	public static boolean isValid (int r, int c) {
		if (r < 0 || r>=N || c <0 || c>=N) return false;
		return true;
	}

}
