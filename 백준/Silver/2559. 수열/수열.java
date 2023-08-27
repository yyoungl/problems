import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0;i<N; i++)
			nums[i] = sc.nextInt();
		int answer = -100 * N;
		int[] sum= new int[N];
		sum[0] = nums[0];
		for (int i=1; i<N; i++) {
			sum[i] = sum[i-1] + nums[i];
		}
		for (int i=K-1; i<N; i++) {
			if (i==K-1) {
				answer = Math.max(sum[i], answer);
				continue;
			}
			answer = Math.max(sum[i]-sum[i-K], answer);
		}
		System.out.println(answer);
	}

}
