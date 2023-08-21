import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			for (int i=0;i <N; i++) {
				for (int j=0; j<N; j++) {
					if (nums[i] < nums[j]) {
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
					}
				}
			}
			
			System.out.print("#"+test_case+" ");
			for (int n: nums) System.out.print(n+" ");
			System.out.println();
		}
	}
}