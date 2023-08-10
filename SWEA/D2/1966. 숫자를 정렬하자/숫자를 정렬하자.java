import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i=0; i<N; i++) {
				nums[i]= sc.nextInt();
			}
			for (int i=N-1; i>=0; i--) {
				for (int j=0; j<i; j++) {
					if (nums[j] > nums[j+1]) {
						int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
						
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for (int num: nums) {
				System.out.print(num+" ");
			}
			System.out.println();
			
		}
	}
}