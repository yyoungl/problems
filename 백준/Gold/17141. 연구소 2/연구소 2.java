import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int vNum;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Node> virus;
	static int answer;
	static int[][] map;
	
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		virus = new ArrayList<>();
		
		answer = N*N;
		
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if (temp==2) {
					virus.add(new Node(i, j));
				}
			}
		}
		
		vNum = virus.size();
		Node[] comb = new Node[M];
		boolean[] chk = new boolean[vNum];
		
		combination(chk, 0, comb, 0);
		
		if (answer == N*N) System.out.println(-1);
		else System.out.println(answer);
		
	}
	
	static void combination (boolean[] chk, int idx, Node[] result, int start) {
		if (idx == M) {
			Node[] temp = Arrays.copyOf(result, M);
			
			bfs(temp);
			
			return;
		}
		
		for (int i=start; i<vNum; i++) {
			if (!chk[i]) {
				chk[i] = true;
				result[idx] = virus.get(i);
				combination(chk, idx+1, result, i+1);
				chk[i] = false;
			}
		}
	}
	
	static void bfs (Node[] temp) {
		boolean[][] visited = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)  {
				if (map[i][j] ==1) visited[i][j] = true;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		int[][] vCnt = new int[N][N];
		for (Node n: temp) {
			q.add(n);
			visited[n.r][n.c] = true; 
			vCnt[n.r][n.c] = 0; 
		}
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc])  {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
					vCnt[nr][nc] = vCnt[r][c] +1;
				}
			}
			
		}
		
		
		boolean isOkay = true;
		int max = 0;
		for (int i=0; i<N; i++ ) {
			for (int j=0; j<N; j++) {
				if (map[i][j] ==1) visited[i][j] = true;
				if (!visited[i][j]) isOkay = false;
				max = Math.max(max, vCnt[i][j]);
			}
		}
		
		if (isOkay) answer = Math.min(max, answer);
		
	}
	
	static boolean isValid(int r, int c) {
		if (r<0 || r>=N || c<0 || c>=N) return false;
		return true;
	}
	
}
