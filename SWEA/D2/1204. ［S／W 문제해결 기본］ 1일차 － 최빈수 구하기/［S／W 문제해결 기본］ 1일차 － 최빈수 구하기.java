import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			sc.nextInt();
			int[] nums = new int [101];
			for (int j=1; j<=1000; j++) {
				int score = sc.nextInt();
				nums[score] +=1;
			}
			int maxIndex = 0;
			for (int j=1; j<=100; j++) {
				if (nums[j] >= nums[maxIndex]) maxIndex = j;
			}
			System.out.println("#"+test_case+" " + maxIndex);
		}
	}
}