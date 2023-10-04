
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
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] campus;
	static int N;
	static int M;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Node doyeon = new Node(0, 0);
		campus = new char[N][M];
		visited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String s = sc.next();
			for (int j=0; j<M; j++) {
				campus[i][j] = s.charAt(j);
				if (s.charAt(j) == 'I') {
					doyeon.r = i;
					doyeon.c = j;
				}
			}
		}
		
		int answer = walk(0, doyeon);
		if (answer == 0) System.out.println("TT");
		else System.out.println(answer);
	}
	
	static int walk(int cnt, Node curr) {
		Queue<Node> q = new LinkedList<>();
		q.add(curr);
		visited[curr.r][curr.c] = true; 
		while(!q.isEmpty()) {
			Node now = q.poll();
			if (campus[now.r][now.c] == 'P' ) cnt++;
			
			for (int d=0; d<4; d++) {
				if (isMovable(now.r+dr[d], now.c+dc[d])) {
					q.add(new Node(now.r+dr[d], now.c+dc[d]));
					visited[now.r+dr[d]][now.c+dc[d]] = true;
				}
			}
		}
		
		return cnt;
	}
	
	static boolean isMovable(int r, int c) {
		if (r < 0 || r>=N || c<0 || c>=M || visited[r][c] || campus[r][c] == 'X') return false;
		return true;
	}

}
