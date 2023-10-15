
import java.util.ArrayList;
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
	static int M;
	static int[][] map;
	static int answer;
	static int empty;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static ArrayList<Node> space = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		answer = 0;
		empty = 0;
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					space.add(new Node(i, j));
					empty++;
				}
				map[i][j] = temp;
			}
		}
		
		empty = space.size();
		int[] result = new int[3];
		boolean[] chk = new boolean[empty];
		combination(0, 0, result, chk);
		System.out.println(answer);
		
	}
	
	public static void combination(int idx, int start, int[] result, boolean[] chk) {
		if (idx==3) {
			int[] temp = Arrays.copyOf(result, 3);
			bfs(temp);
			return;
		}
		for (int i=start; i<empty; i++) {
			if (!chk[i]) {
				chk[i] = true;
				result[idx] = i;
				combination(idx+1, i+1, result, chk);
				chk[i] = false;
			}
		}
	}
	
	
	public static void bfs(int[] temp) {
		int cnt = empty - 3;
		boolean[][] visited = new boolean[N][M];
		for (int i=0; i<3; i++) {
			Node now = space.get(temp[i]);
			visited[now.r][now.c] = true; 
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 2) {
					q.add(new Node(i, j));
					visited[i][j] = true;
				} 
				if (map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
					cnt--;
				}
				
			}
			
		}
		answer = Math.max(answer, cnt);
		
	}
	
	
	public static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c<0 || c>=M) return false;
		return true;
	}

}
