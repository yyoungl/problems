import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[] height = new int[N];
			int answer = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			// B보다 큰 것 중에서 가장 작은 것
			for (int i=0; i<(1<<N); i++) {
				int sum = 0;
				for (int j=0; j<N; j++) {
					if ((i&(1<<j)) > 0) {
						sum += height[j];
					}
				}
				if (sum >= B) answer = Math.min(answer, sum);
				else if (sum==B) {
					answer = sum;
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+(answer-B));
		}
		
	}

}
