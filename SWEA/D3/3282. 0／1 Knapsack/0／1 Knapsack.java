import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class Stuff {
		// 부피
		int v;
		// 가치
		int c;
		
		public Stuff(int v, int c) {
			super();

			this.v = v;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Stuff [v=" + v + ", c=" + c + "]";
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] dp = new int[N+1][K+1];
			
			Stuff[] stuffs = new Stuff[N+1];
			for (int i=1; i<N+1; i++) {
				stuffs[i] = new Stuff(sc.nextInt(), sc.nextInt());
			}
			
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=K; j++) {
					dp[i][j] = dp[i-1][j];
					if (j-stuffs[i].v >= 0)
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j-stuffs[i].v] + stuffs[i].c);
				}
			}
			
			System.out.println("#"+test_case+" "+dp[N][K]);
		}
	}

}
