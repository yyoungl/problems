import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		visited = new boolean[N][M];
		int answer = 0;
		int[][] room = new int[N][M];
		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int temp = sc.nextInt();
				room[i][j] = temp;
				if (temp == 1) visited[i][j] = true;
			}
		}
		
		while(true) {
			if (!visited[r][c]) {
				visited[r][c] = true;
				answer++;
			}
			boolean chk = false;
			for (int i=0; i<4; i++) {
				if (dirty(r+dr[i], c+dc[i])) chk = true;
			}
			
			if (chk) {
				d = (d+3)%4;
				if (!visited[r+dr[d]][c+dc[d]]) {
					r = r+dr[d];
					c = c+dc[d];
				}
			} else {
				if (room[r-dr[d]][c-dc[d]] == 0 && r<N && r>=0 && c<M && c>=0) {
					r=r-dr[d];
					c=c-dc[d];
				} else break;
			}
			
		}
		
		System.out.println(answer);
		
	}
	
	public static boolean dirty(int r, int c) {
		if (visited[r][c] || r < 0 || r >= N || c<0 || c>=M) return false;
		return true;
	}

}
