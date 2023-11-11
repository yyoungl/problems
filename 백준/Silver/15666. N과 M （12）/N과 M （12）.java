
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		for (int i=0; i<N; i++) nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		int[] result = new int[M];
		
		permutation(result, 0, 0);
		System.out.println(sb.toString());
	}
	
	static void permutation(int[] result, int idx, int start) {
		if (idx == M) {
			for (int i=0; i<M; i++) 
				sb.append(result[i]+" ");
			
			sb.append("\n");
			return;
		}
		int last = -1;
		for (int i=start; i<N; i++) {
			int now = nums[i];
			if (last != now) {
				last = now;
				result[idx] = nums[i];
				permutation(result, idx+1, i);
			}
		}
	}

}
