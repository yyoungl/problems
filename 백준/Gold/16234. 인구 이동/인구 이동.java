
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
	static List<Node> nodes = new ArrayList<>();
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int L;
	static int R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}
		
		int answer = 0;
		while (true) {
			boolean chk = false;
			visited = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!visited[i][j]) {
						boolean temp = bfs(i, j);
						if (temp) chk = true;
					}
				}
			}
			
			if (chk) {
				answer++;
			}
			else break;
		}
		System.out.println(answer);
		
	}
	
	static boolean bfs(int i, int j) {
		boolean answer = false;
		Queue<Node> q = new LinkedList<>();
		nodes.clear();
//		System.out.println("i, j: "+i+" "+j);
		int r = i;
		int c = j;
		
		q.add(new Node(r, c));
		nodes.add(new Node(r, c));
		visited[r][c] = true;
		int sum = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			r = curr.r;
			c = curr.c;
			sum += map[r][c];
//			System.out.println("curr: "+curr.toString());
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (isValid(nr, nc) && !visited[nr][nc]) {
					int diff = Math.abs(map[r][c] - map[nr][nc]);
					if (diff >= L && diff <= R) {
						q.add(new Node(nr, nc));
						visited[nr][nc] = true;
						nodes.add(new Node(nr, nc));
					}
				}
			}
			
		}
		
//		for (Node node: nodes) System.out.println(node.toString());
		
		int cnt = nodes.size();
		if (cnt > 1) {
			answer = true;
			for (Node node: nodes) {
				map[node.r][node.c] = sum / cnt;
			}
		}
		
		
		
//		for (int[] m: map) {
//			System.out.println(Arrays.toString(m));
//		}
		
		return answer;
	}
	
	static boolean isValid(int r, int c) {
		return (r >= 0 && r<N && c>=0 && c<N);
	}

}
