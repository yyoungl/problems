
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N+1];
		int[] totalSum = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = sc.nextInt();
			totalSum[i] += nums[i] + totalSum[i-1];
		}
		for (int tc = 0; tc < M; tc++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int sum = totalSum[j] - totalSum[i-1];
			
			
			System.out.println(sum);
		}

	}

}
