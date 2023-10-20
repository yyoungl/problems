
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int cnt = 0;
	static int[][] dp;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;				
			}
		}
		dp[0][0] = 1;
		dfs(N-1, M-1);
		System.out.println(dp[N-1][M-1]);
	}
	
	static void dfs(int r, int c) {
		dp[r][c] = 0;
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (isValid(nr, nc) && map[nr][nc] > map[r][c]) {
				if (dp[nr][nc] == -1) dfs(nr, nc);
				dp[r][c] += dp[nr][nc];
			}
		}
		
	}
	
	static boolean isValid(int r, int c) {
		if (r < 0 || r>=N || c<0 || c>=M) {
			return false;
		}
		return true;
	}

}
