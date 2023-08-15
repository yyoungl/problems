import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] stickers = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j < N + 1; j++) {
					stickers[i][j] = sc.nextInt();
				}
			}

			int[][] dp = new int[2][N + 1];
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];

			for (int j = 2; j < N + 1; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];

			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}

	}
}
