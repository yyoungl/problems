import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
				Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			int[] build = new int[N];
			for (int i=0; i<N; i++) build[i] = sc.nextInt();
			int answer = 0;
			for (int i=2; i<N-2; i++) {
				int maxLeft = Math.max(build[i-2], build[i-1]);
				int maxRight = Math.max(build[i+1], build[i+2]);
				int around = Math.max(maxLeft, maxRight);
				
				if (build[i] > around) answer += build[i] - around;
				
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}