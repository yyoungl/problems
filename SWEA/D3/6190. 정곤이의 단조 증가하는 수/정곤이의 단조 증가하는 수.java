import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			ArrayList<Integer> product = new ArrayList<>();
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {
					product.add(nums[i]*nums[j]);
				}
			}
			int max = 0;
			for (int i: product) {
				boolean isIncrease = true;
				String str = Integer.toString(i);
				int[] check = new int[str.length()];
				for (int idx=0; idx<str.length(); idx++) {
					check[idx] = Integer.valueOf(str.charAt(idx)-'0');
				}
				
				for (int idx=0; idx<check.length-1; idx++) {
					if (check[idx] > check[idx+1]) {
						isIncrease = false;
						break;
					}
				}
				
				if (isIncrease) max = Math.max(max, i);
			}
			if (max != 0)
				System.out.println("#"+test_case+" "+max);
			else System.out.println("#"+test_case+" -1");
		}
	}

}
