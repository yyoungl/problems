import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case=1; test_case<=TC; test_case++) {
			int K = sc.nextInt();
			Stack<Integer> money = new Stack<>();
			for (int i=0; i<K; i++) {
				int inputMoney = sc.nextInt();
				if (inputMoney == 0) money.pop();
				else money.push(inputMoney);
			}
			
			int sum = 0;
			while(!money.isEmpty()) sum+=money.pop();
			
			System.out.println("#"+test_case+" "+sum);
		}
		
	}
}