import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int answer = 0;
			for (int i=1; i<(1<<N); i++) {
				int[] result = new int[N];
				int idx = 0;
				for (int j=0; j<N; j++) {
					if ((i&(1<<j)) > 0) {
						result[idx++] = arr[j];
					}
				}
				int sum = 0;
				for (int k=0; k<N; k++) {
					sum += result[k];
				}
				if (sum == K) answer++;
			}
			System.out.println("#"+test_case+" "+answer);
			
		}
	}

}
