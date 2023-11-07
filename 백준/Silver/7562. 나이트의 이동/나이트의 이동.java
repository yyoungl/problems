
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
	}
	static int N;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Node> q = new LinkedList<>();
		
		for (int tc=0; tc<T; tc++) {
			
			N = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int endR = sc.nextInt();
			int endC = sc.nextInt();
			int answer = Integer.MAX_VALUE;
			int[][] cnt = new int[N][N];
			
			boolean[][] visited = new boolean[N][N];
			q.clear();
			q.add(new Node(r, c));
			visited[r][c] = true;
			
			while(!q.isEmpty()) {
				Node curr = q.poll();
				int currR = curr.r;
				int currC = curr.c;
				
				if (currR == endR && currC == endC) {
					answer = Math.min(answer, cnt[currR][currC]);
				}
				
				for (int d=0; d<8; d++) {
					int nr = currR+dr[d];
					int nc = currC+dc[d];
					if (isValid(nr, nc) && !visited[nr][nc]) {
						q.add(new Node(nr, nc));
						cnt[nr][nc] = cnt[currR][currC] + 1;
						visited[nr][nc] = true;
					} 
				}
			}
			
			System.out.println(answer);
			
		}
	}
	
	static boolean isValid(int r, int c) {
		if (r < 0 || r>=N || c<0 || c>=N) return false;
		return true;
	}
	
}
