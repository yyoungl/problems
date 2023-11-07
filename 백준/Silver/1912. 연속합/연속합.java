
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = arr[0];
		max = dp[0];
		for (int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}	
		System.out.println(max);
	}

}
