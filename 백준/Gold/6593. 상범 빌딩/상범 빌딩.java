
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static class Node {
		int l;
		int r;
		int c;
		int time;
		@Override
		public String toString() {
			return "Node [l=" + l + ", r=" + r + ", c=" + c + ", time=" + time + "]";
		}
		public Node(int l, int r, int c, int time) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
		
	}
	// 층
	static int L;
	// 행
	static int R;
	// 열
	static int C;
	static int[][][] building;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dl = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			if (L == 0 && R == 0 && C == 0)
				break;

			int answer = 0;
			building = new int[L][R][C];
			visited = new boolean[L][R][C];
			int l = 0;
			int r = 0;
			int c = 0;
			int time = 0;
			int endL = 0;
			int endR = 0;
			int endC = 0;
			boolean chk = false;
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String input = sc.next();
					for (int k = 0; k < C; k++) {
						char in = input.charAt(k);
						if (in == 'S') {
							l = i;
							r = j;
							c = k;
						} else if (in == 'E') {
							endL = i;
							endR = j;
							endC = k;
						} else if (in == '#') {
							visited[i][j][k] = true;
						}
						building[i][j][k] = in;
					}
				}
			}
			
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(l, r, c, 0));
			
			while(!q.isEmpty()) {
				Node curr = q.poll();
				l = curr.l;
				r = curr.r;
				c = curr.c;
				time = curr.time;
				
				if (l==endL && r==endR && c==endC) {
					answer = time;
					chk = true;
					break;
				}
				
				for (int d=0; d<6; d++) {
					int nl = l+dl[d];
					int nr = r+dr[d];
					int nc = c+dc[d];
					if (isValid(nl, nr, nc) && !visited[nl][nr][nc]) {
						q.add(new Node(nl, nr, nc, time+1));
						visited[nl][nr][nc] = true;
					}
				}
			}
			
			if (chk) {
				System.out.println("Escaped in "+time+" minute(s).");
			}
			else System.out.println("Trapped!");
			
		}
	}
	
	static boolean isValid (int l, int r, int c) {
		if (l<0 || l>=L || r<0 || r>=R || c<0 || c>=C) return false;
		return true;
	}

}
