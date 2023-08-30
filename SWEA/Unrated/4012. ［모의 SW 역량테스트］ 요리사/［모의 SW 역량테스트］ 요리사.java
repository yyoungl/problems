import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[][] menu = new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					menu[i][j] = sc.nextInt();
				}
			}
			int answer  = 20000;
			for (int bit=0; bit<(1<<N); bit++) {
				if (Integer.bitCount(bit) != N/2) continue;
				int[] result1 = new int[N/2];
				int[] result2 = new int[N/2];
				int idx1 = 0;
				int idx2 = 0;
				for (int j=0; j<N; j++) {
					if ((bit&(1<<j)) > 0) {
						result1[idx1++] = j;
					} else result2[idx2++] = j;
				}
				int sum1 = 0;
				int sum2 = 0;
				
				for (int i=0; i<N/2; i++) {
					for (int j=0; j<N/2; j++) {
						sum1 += menu[result1[i]][result1[j]];
						sum2 += menu[result2[i]][result2[j]];
					}
				}
				
				answer = Math.min(answer, Math.abs(sum1-sum2));
				
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}

}
