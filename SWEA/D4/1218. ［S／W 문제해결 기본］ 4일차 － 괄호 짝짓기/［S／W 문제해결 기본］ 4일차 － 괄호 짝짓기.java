
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;


class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int test_case=1; test_case<=10; test_case++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String inputS = sc.next();
			char[] bracket = inputS.toCharArray();
			
			for (int i=0; i<N; i++) {
				if (stack.isEmpty()) {
					stack.push(bracket[i]);
					continue;
				}
				if ((bracket[i] == '>') && (stack.peek() == '<')) 
					stack.pop();
				else if ((bracket[i] == ']') && (stack.peek() == '[')) stack.pop();
				else if ((bracket[i] == '}') && (stack.peek() == '{')) stack.pop();
				else if ((bracket[i] == ')') && (stack.peek() == '(')) stack.pop();
				else stack.push(bracket[i]);
			}
			
			if (stack.isEmpty()) System.out.println("#"+test_case+" "+1);
			else System.out.println("#"+test_case+" "+0);
		}
	}
}