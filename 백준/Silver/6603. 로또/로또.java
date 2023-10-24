import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		while(true) {
			int N = sc.nextInt();
			if (N==0) {
				break;
			}
			sb = new StringBuilder();
			
			int[] nums = new int[N];
			
			for (int i=0; i<N; i++) nums[i] = sc.nextInt();
			int[] result = new int[6];
			boolean[] chk = new boolean[N];
			combination(0, 0, N, result, nums, chk);
			System.out.println(sb.toString());
		}
		
	}
	
	static void combination(int idx, int start, int N, int[] result, int[] nums, boolean[] chk) {
		if (idx==6) {
			int[] temp = Arrays.copyOf(result, 6);
			Arrays.sort(temp);
			for (int i=0; i<5; i++) sb.append(temp[i]+" ");
			sb.append(temp[5]);
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (!chk[i]) {
				result[idx] = nums[i];
				chk[i] = true;
				combination(idx+1, i+1, N, result, nums, chk);
				chk[i] = false;
			}
		}
	}

}
