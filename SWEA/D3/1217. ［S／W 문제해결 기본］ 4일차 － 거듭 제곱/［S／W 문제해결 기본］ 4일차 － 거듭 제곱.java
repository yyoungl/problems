import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			int T = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#"+test_case+" "+power(a, b));
			
			
		}
	}
	
	public static int power(int a, int b) {
		if (b == 0) return 1;
		else {
			return a * power(a, b-1);
		}
	}
}