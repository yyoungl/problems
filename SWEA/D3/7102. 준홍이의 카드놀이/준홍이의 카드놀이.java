import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case ++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] comb = new int[N*M];
			int idx =0;
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=M; j++) {
					comb[idx++] = i+j;
				}
			}
			Arrays.sort(comb);
			int[] count = new int[comb[N*M-1]+1];
			
			for (int num: comb)
				count[num] ++;
			
			int maxCount = count[comb[N*M/2]];
			
			System.out.print("#"+test_case+" ");
			
			for (int i=0; i<count.length; i++) {
				if (count[i] == maxCount)
					System.out.print(i+ " ");
			}
			System.out.println();
			
			
		}
	}

}
