
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = sc.nextInt();

		dp[0] = nums[0];
		int answer = nums[0];
		
		if (N > 1) {
			
			for (int i = 1; i < N; i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i]) {
						max = Math.max(dp[j], max);
					}
				}
				dp[i] = max + nums[i];
				answer = Math.max(dp[i], answer);
			}
			
		}
		
		System.out.println(answer);

	}

}
