import java.util.Scanner;

public class Solution {

	static int answer;
	static boolean[][] eat;
	static int N;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int[][] cheese = new int[N][N];
			int maxDay = 0;
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					maxDay = Math.max(cheese[i][j], maxDay);
				}
			}

			for (int day = 0; day <= maxDay; day++) {
				eat = new boolean[N][N];
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] <= day)
							eat[i][j] = true;
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!eat[i][j]) {
							cnt++;
							dfs(i, j);
						}
					}
				}

				answer = Math.max(answer, cnt);
			}
			System.out.println("#" + test_case + " " + answer);
		}

	}

	public static void dfs(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N || eat[r][c])
			return;
		eat[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			dfs(nr, nc);
		}
	}

}
