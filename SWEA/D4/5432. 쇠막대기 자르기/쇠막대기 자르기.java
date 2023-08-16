import java.util.Stack;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String inputS = sc.next();
			Stack<Character> stack = new Stack<>();
			char[] in = inputS.toCharArray();
			int answer = 1;
			stack.push(in[0]);
			for (int i = 1; i < in.length; i++) {
				if (in[i] == ')' && in[i - 1] == '(') {
					stack.pop();
					answer--;
					answer += stack.size();
//					System.out.println("자름: "+answer);
				} else if (in[i] == ')')
					stack.pop();
				else {
					stack.push(in[i]);
					answer++;
//					System.out.println("넣음: "+answer);
				}
//				for (char b : stack)
//					System.out.print(b + " ");
//				System.out.println();
			}
			System.out.println("#" + test_case + " " + answer);

		}

	}
}