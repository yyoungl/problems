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
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = 0;
		int max = 1;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				max = Math.max(max, temp);
			}
		}
		
		
		for (int depth=0; depth<=max; depth++) {
			visited = new boolean[N][N];
			int temp = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] > depth && !visited[i][j]) {
						bfs(i, j, depth);
						temp++;
					}
				}
			}
			answer = Math.max(temp, answer);
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int r, int c, int depth) {
		Queue<Node> q = new LinkedList<>();
		int curR = r;
		int curC = c;
		q.add(new Node(curR, curC));
		visited[curR][curC] = true;

		while(!q.isEmpty()) {
			Node curr = q.poll();
			curR = curr.r;
			curC = curr.c;
			for (int d=0; d<4; d++) {
				if(isValid(curR+dr[d], curC+dc[d]) && !visited[curR+dr[d]][curC+dc[d]] && map[curR+dr[d]][curC+dc[d]] > depth) {
					q.add(new Node(curR+dr[d], curC+dc[d]));
					visited[curR+dr[d]][curC+dc[d]] = true;
				}
			}
		}
		
	}
	
	static boolean isValid(int r, int c) {
		if (r < 0 || r>=N || c<0 || c>=N) return false;
		else return true;
	}

}
