
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Math.max(N, M);
			int min = Math.min(N, M);

			int[][] dp = new int[max + 1][max + 1];
			
			for (int i=1; i<=max; i++) {
				dp[i][1] = i;
			}
			
			
			for (int i = 2; i <= max; i++) {
				for (int j = 2; j <= max; j++) {

					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

				}
			}

			System.out.println(dp[max][min]);
		}
	}

}
